package com.alfazid.siasd.controller;

import com.alfazid.siasd.model.KabupatenEntity;
import com.alfazid.siasd.model.ProvinsiEntity;
import com.alfazid.siasd.dto.KabupatenDto;
import com.alfazid.siasd.repository.KabupatenRepository;
import com.alfazid.siasd.repository.ProvinsiRepository;
import com.alfazid.siasd.service.KabupatenService;
import com.alfazid.siasd.utilities.RestError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

import javax.xml.ws.http.HTTPException;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 08/09/19.
 */

@RestController
@RequestMapping(value = "/kabupaten")
public class KabupatenController {
    @Autowired
    private KabupatenRepository kabupatenRepository;
    @Autowired
    private KabupatenService kabupatenService;
    @Autowired
    private ProvinsiRepository provinsiRepository;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ModelAndView index(Model model, @PageableDefault(size = 10) Pageable pageable) {
        Page<KabupatenDto> page = kabupatenService.findAll(pageable);
        model.addAttribute("page", page);
        return new ModelAndView("kabupaten/kabupaten-list");
    }
    @RequestMapping(value = "/{by}/{value}", method = RequestMethod.GET)
    public ModelAndView getByName(Model model, @PageableDefault(size = 10) Pageable pageable, @PathVariable String by, @PathVariable String value) {
        Page<KabupatenDto> page = null;
        switch (by) {
            case "All":
                page = kabupatenService.findAll(pageable);
                break;
            default:
                page = kabupatenService.findBy(pageable,by, value);
        }
        model.addAttribute("page", page);
        return new ModelAndView("kabupaten/kabupaten-list");
    }

    @RequestMapping(value = "/create")
    public ModelAndView create(ModelMap model, KabupatenEntity kabupatenEntity) {
        List<ProvinsiEntity> provinsiEntityList = provinsiRepository.findProvinsi();
        model.addAttribute("mode", "Create");
        model.addAttribute("provinsi",provinsiEntityList);

        return new ModelAndView("kabupaten/kabupaten-create");
    }
    
    @PostMapping(value = "/")
    public ModelAndView doPost(Model model, KabupatenEntity kabupatenEntity, BindingResult result, @PageableDefault(size = 10) Pageable pageable) {
        if (result.hasErrors()) {
            new ModelAndView("kabupaten/kabupaten-create");
        }

        String id = kabupatenRepository.existByKode(kabupatenEntity.getKodeKabupaten());
        if (id != null) {
            model.addAttribute("error", "true");
            return new ModelAndView("redirect:/kabupaten/" + id);
        } else {
            try {
                kabupatenRepository.save(kabupatenEntity);
            } catch (HTTPException he) {
                return new ModelAndView("error");
            }
        }
        return new ModelAndView("redirect:/kabupaten");
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") int id, Model model) {
        Optional<KabupatenEntity> kabupatenEntity = kabupatenRepository.findById(id);
        if (kabupatenEntity.isPresent()) {
            KabupatenEntity kabupaten = kabupatenEntity.get();
            model.addAttribute("kabupatenEntity", kabupaten);
        }
        List<ProvinsiEntity> provinsiEntityList = provinsiRepository.findProvinsi();
        model.addAttribute("provinsi",provinsiEntityList);
        model.addAttribute("mode", "Update");
        return new ModelAndView("kabupaten/kabupaten-update");
    }
    @RequestMapping(value ="/{id}",method = RequestMethod.POST)
    public ModelAndView  doPut(Model model,@ModelAttribute("kabupatenEntity") KabupatenEntity kabupatenEntity,@PathVariable int id){
       try{
           kabupatenEntity.setIdKabupaten(id);
           kabupatenRepository.save(kabupatenEntity);
           model.addAttribute("error",new RestError(false,200,"Success"));
       }catch (HTTPException he){
           model.addAttribute("error",new RestError(true,500,"Error"));
       }
       return new ModelAndView ("redirect:/kabupaten");
   }

}
