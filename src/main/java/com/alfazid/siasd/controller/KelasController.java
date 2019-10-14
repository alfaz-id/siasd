package com.alfazid.siasd.controller;

import com.alfazid.siasd.model.KelasEntity;
import com.alfazid.siasd.repository.KelasRepository;
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
 * Created by cigist on 31/07/19.
 */
@RestController
@RequestMapping(value = "/kelas")
public class KelasController {
    @Autowired
    private KelasRepository kelasRepository;
    private int idSekolah=1;


    @RequestMapping(value = {"", "/"},method = RequestMethod.GET)
    public ModelAndView index(Model model,@PageableDefault(size = 10) Pageable pageable){
        Page<KelasEntity> page = kelasRepository.findAll(pageable, idSekolah);
        model.addAttribute("page",page);
        return new ModelAndView ("kelas/kelas-list");
    }
    @RequestMapping(value ="/{by}/{value}",method = RequestMethod.GET)
    public ModelAndView  getByName(Model model,@PageableDefault(size = 10) Pageable pageable,@PathVariable String by,@PathVariable String value){
        if(value.isEmpty()){
            value="";
        }
        Page<KelasEntity> page = null;
        switch (by){
            case "Nama":
                page= kelasRepository.findByName(pageable,idSekolah, value);
                break;
            case "Active":
                page= kelasRepository.findActive(pageable,idSekolah, value);
                break;
            case "All":
                page = kelasRepository.findAll(pageable,idSekolah);
                break;
        }
        model.addAttribute("page",page);
        return new ModelAndView ("kelas/kelas-list");
    }
    @RequestMapping(value ="/create")
    public ModelAndView create(ModelMap model,KelasEntity kelas){
        model.addAttribute("mode","Create");
        return new ModelAndView ("kelas/kelas-create");
    }
    @PostMapping(value="/")
    public ModelAndView  doPost(Model model,KelasEntity kelas,BindingResult result,@PageableDefault(size = 10) Pageable pageable){
        if (result.hasErrors()) {
            new ModelAndView ("kelas/kelas-create");
        }
        try{
            kelas.setIdSekolah(idSekolah);
            kelasRepository.save(kelas);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }
        Page<KelasEntity> page = kelasRepository.findAll(pageable);
        model.addAttribute("page",page);
        return new ModelAndView ("redirect:/kelas");
    }
    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") int id,Model model){
        Optional<KelasEntity> kelas = kelasRepository.findById(id);
        if (kelas.isPresent()) {
            KelasEntity kelasEntity= kelas.get();
            model.addAttribute("kelasEntity", kelasEntity);
        }

        model.addAttribute("mode","Update");
        return new ModelAndView ("kelas/kelas-update");
    }
    @RequestMapping(value ="/{id}",method = RequestMethod.POST)
    public ModelAndView  doPut(Model model,@ModelAttribute("kelasEntity") KelasEntity kelasEntity,@PathVariable int id,
                               @PageableDefault(size = 10) Pageable pageable){
        try{
            kelasEntity.setIdKelas(id);
            kelasEntity.setIdSekolah(idSekolah);
            kelasRepository.save(kelasEntity);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }
        Page<KelasEntity> page = kelasRepository.findAll(pageable,idSekolah);
        model.addAttribute("page",page);
        return new ModelAndView ("redirect:/kelas");
    }
    @RequestMapping(value ="/delete/{id}",method = RequestMethod.GET)
    public ModelAndView  doDelete(Model model,@PathVariable int id,@PageableDefault(size = 10) Pageable pageable){
        try{
            kelasRepository.deleteById(id);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }
        Page<KelasEntity> page = kelasRepository.findAll(pageable,idSekolah);
        model.addAttribute("page",page);
        return new ModelAndView ("redirect:/kelas");
    }
}
