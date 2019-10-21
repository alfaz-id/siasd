package com.alfazid.siasd.controller;

import com.alfazid.siasd.model.GuruEntity;
import com.alfazid.siasd.repository.GuruRepository;
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
@RequestMapping(value = "/guru")
public class GuruController {
    @Autowired
    private GuruRepository guruRepository;
    private int idSekolah=1;

    @RequestMapping(value = {"", "/"},method = RequestMethod.GET)
    public ModelAndView index(Model model,@PageableDefault(size = 10) Pageable pageable){
        Page<GuruEntity> page = guruRepository.findAll(pageable,idSekolah);
        model.addAttribute("page",page);
        return new ModelAndView ("guru/list-guru");
    }
    @RequestMapping(value ="/{by}/{value}",method = RequestMethod.GET)
    public ModelAndView  getByName(Model model,@PageableDefault(size = 10) Pageable pageable,@PathVariable String by,@PathVariable String value){
        Page<GuruEntity> page = null;
        switch (by){
            case "Nama":
                page= guruRepository.findByName(pageable,idSekolah, value);
                break;
            case "Nip":
               page= guruRepository.findByNip(pageable,idSekolah, value);
                break;
            case "Alamat":
                page=guruRepository.findByAlamat(pageable,idSekolah, value);
                break;
            case "Telp":
              page= guruRepository.findByTelp(pageable,idSekolah, value);
                break;
            case "Active":
                page= guruRepository.findActive(pageable,idSekolah, value);
                break;
            case "All":
                page = guruRepository.findAll(pageable,idSekolah);
                break;
        }
        model.addAttribute("page",page);
        return new ModelAndView ("guru/list-guru");
    }
    @RequestMapping(value ="/create")
    public ModelAndView create(ModelMap model,GuruEntity guru){
        model.addAttribute("mode","Create");
       return new ModelAndView ("guru/create");
    }
     @PostMapping(value="/")
      public ModelAndView  doPost(Model model,GuruEntity guru,BindingResult result,
                                  @PageableDefault(size = 10) Pageable pageable){
        if (result.hasErrors()) {
            new ModelAndView ("guru/create");
        }
        try{
            guru.setIdSekolah(1);
            guruRepository.save(guru);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }
         Page<GuruEntity> page = guruRepository.findAll(pageable,idSekolah);
         model.addAttribute("page",page);
         return new ModelAndView ("redirect:/guru");
    }
    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") int id,Model model){
        Optional<GuruEntity> guru = guruRepository.findById(id);
        if (guru.isPresent()) {
            GuruEntity guruEntity= guru.get();
            model.addAttribute("guruEntity", guruEntity);
        }

        model.addAttribute("mode","Update");
        return new ModelAndView ("guru/update");
    }
    @RequestMapping(value ="/{id}",method = RequestMethod.POST)
     public ModelAndView  doPut(Model model,@ModelAttribute("guruEntity") GuruEntity guruEntity,@PathVariable int id){
        try{
            guruEntity.setIdGuru(id);
            guruEntity.setIdSekolah(idSekolah);
            guruRepository.save(guruEntity);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }
        return new ModelAndView ("redirect:/guru");
    }
    @RequestMapping(value ="/delete/{id}",method = RequestMethod.GET)
    public ModelAndView  doDelete(Model model,@PathVariable int id,@PageableDefault(size = 10) Pageable pageable){
        try{
            guruRepository.deleteById(id);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }
        Page<GuruEntity> page = guruRepository.findAll(pageable,idSekolah);
        model.addAttribute("page",page);
        return new ModelAndView ("redirect:/guru");
    }
}
