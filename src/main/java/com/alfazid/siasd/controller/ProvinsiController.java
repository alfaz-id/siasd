package com.alfazid.siasd.controller;

import com.alfazid.siasd.model.entity.ProvinsiEntity;
import com.alfazid.siasd.repository.ProvinsiRepository;
import com.alfazid.siasd.utilities.RestError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.http.HTTPException;
import java.util.Optional;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 08/09/19.
 */
@RestController
@RequestMapping(value = "/provinsi")
public class ProvinsiController {
    @Autowired
    private ProvinsiRepository provinsiRepository;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ModelAndView index(Model model, @PageableDefault(size = 10) Pageable pageable) {
        Page<ProvinsiEntity> page = provinsiRepository.findAll(pageable);
        model.addAttribute("page", page);
        return new ModelAndView("provinsi/provinsi-list");
    }

    @RequestMapping(value = "/{by}/{value}", method = RequestMethod.GET)
    public ModelAndView getByName(Model model, @PageableDefault(size = 10) Pageable pageable, @PathVariable String by, @PathVariable String value) {
        Page<ProvinsiEntity> page = null;
        switch (by) {
            case "All":
                page = provinsiRepository.findAll(pageable);
                break;
            case "kode":
                page = provinsiRepository.findKode(pageable, Integer.parseInt(value));
                break;
            case "active":
                page = provinsiRepository.findAvtive(pageable, value);
                break;
            default:
                page = provinsiRepository.findBy(pageable, value);
        }
        model.addAttribute("page", page);
        model.addAttribute("error", "false");
        return new ModelAndView("provinsi/provinsi-list");
    }

    @RequestMapping(value = "/create")
    public ModelAndView create(ModelMap model, ProvinsiEntity provinsiEntity) {
        model.addAttribute("mode", "Create");
        return new ModelAndView("provinsi/provinsi-create");
    }

    @PostMapping(value = "/")
    public ModelAndView doPost(Model model, ProvinsiEntity provinsiEntity, BindingResult result, @PageableDefault(size = 10) Pageable pageable) {
        if (result.hasErrors()) {
            new ModelAndView("provinsi/provinsi-create");
        }

        String id = provinsiRepository.existByKode(provinsiEntity.getKodeProvinsi());
        if (id != null) {
            model.addAttribute("error", "true");
            return new ModelAndView("redirect:/provinsi/" + id);
        } else {
            try {
                provinsiRepository.save(provinsiEntity);
            } catch (HTTPException he) {
                return new ModelAndView("error");
            }
        }
        return new ModelAndView("redirect:/provinsi");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") int id, Model model) {
        Optional<ProvinsiEntity> provinsiEntity = provinsiRepository.findById(id);
        if (provinsiEntity.isPresent()) {
            ProvinsiEntity provinsi = provinsiEntity.get();
            model.addAttribute("provinsiEntity", provinsi);
        }

        model.addAttribute("mode", "Update");
        return new ModelAndView("provinsi/provinsi-update");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ModelAndView doPut(Model model, @ModelAttribute("provinsiEntity") ProvinsiEntity provinsiEntity, @PathVariable int id) {
        try {
            provinsiEntity.setIdProvinsi(id);
            provinsiRepository.save(provinsiEntity);
            model.addAttribute("error", new RestError(false, 200, "Success"));
        } catch (HTTPException he) {
            model.addAttribute("error", new RestError(true, 500, "Error"));
        }
        return new ModelAndView("redirect:/provinsi");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView doDelete(Model model, @PathVariable int id) {
        try {
            provinsiRepository.deleteById(id);
            model.addAttribute("error", new RestError(false, 200, "Success"));
        } catch (HTTPException he) {
            model.addAttribute("error", new RestError(true, 500, "Error"));
        }
        return new ModelAndView("redirect:/provinsi");
    }
}
