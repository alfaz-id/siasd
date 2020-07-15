package com.alfazid.siasd.controller;

import com.alfazid.siasd.model.entity.EkskulEntity;
import com.alfazid.siasd.repository.EkskulRepository;
import com.alfazid.siasd.utilities.RestError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
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

@Controller
@RequestMapping(value = "/ekskul")
public class EkskulController {
    @Autowired
    private EkskulRepository ekskulRepository;
    private int idSekolah=1;
    
    @RequestMapping(value = {"", "/"},method = RequestMethod.GET)
    public ModelAndView index(Model model,@PageableDefault(size = 10) Pageable pageable){
        Page<EkskulEntity> page = ekskulRepository.findAll(pageable,idSekolah);
        model.addAttribute("page",page);
        return new ModelAndView ("ekskul/ekskul-list");
    }
    @RequestMapping(value ="/{by}/{value}",method = RequestMethod.GET)
    public ModelAndView  getByName(Model model,@PageableDefault(size = 10) Pageable pageable,@PathVariable String by,@PathVariable String value){
        if(value.isEmpty()){
            value="";
        }
        Page<EkskulEntity> page = null;
        switch (by){
            case "Nama":
                page= ekskulRepository.findByName(pageable,idSekolah, value);
                break;
            case "Active":
                page= ekskulRepository.findActive(pageable,idSekolah, value);
                break;
            case "All":
                page = ekskulRepository.findAll(pageable,idSekolah);
                break;
        }
        model.addAttribute("page",page);
        return new ModelAndView ("ekskul/ekskul-list");
    }

    @RequestMapping(value ="/create")
    public ModelAndView create(ModelMap model,EkskulEntity ekskul){
        model.addAttribute("mode","Create");
        return new ModelAndView ("ekskul/ekskul-create");
    }
    @PostMapping(value="/")
    public ModelAndView  doPost(Model model,EkskulEntity ekskulEntity,BindingResult result,@PageableDefault(size = 10) Pageable pageable){
        if (result.hasErrors()) {
            new ModelAndView ("ekskul/ekskul-create");
        }
        try{
            ekskulEntity.setIdSekolah(idSekolah);
            ekskulRepository.save(ekskulEntity);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }
        Page<EkskulEntity> page = ekskulRepository.findAll(pageable);
        model.addAttribute("page",page);
        return new ModelAndView ("redirect:/ekskul");
    }
    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") int id,Model model){
        Optional<EkskulEntity> ekskul = ekskulRepository.findById(id);
        if (ekskul.isPresent()) {
            EkskulEntity ekskulEntity= ekskul.get();
            model.addAttribute("ekskulEntity", ekskulEntity);
        }

        model.addAttribute("mode","Update");
        return new ModelAndView ("ekskul/ekskul-update");
    }
    @RequestMapping(value ="/{id}",method = RequestMethod.POST)
    public ModelAndView  doPut(Model model,@ModelAttribute("ekskulEntity") EkskulEntity ekskulEntity,@PathVariable int id,
                               @PageableDefault(size = 10) Pageable pageable){
        try{
            ekskulEntity.setIdEkskul(id);
            ekskulEntity.setIdSekolah(idSekolah);
            ekskulRepository.save(ekskulEntity);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }
        Page<EkskulEntity> page = ekskulRepository.findAll(pageable,idSekolah);
        model.addAttribute("page",page);
        return new ModelAndView ("redirect:/ekskul");
    }
    @RequestMapping(value ="/delete/{id}",method = RequestMethod.GET)
    public ModelAndView  doDelete(Model model,@PathVariable int id,@PageableDefault(size = 10) Pageable pageable){
        try{
            ekskulRepository.deleteById(id);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }
        Page<EkskulEntity> page = ekskulRepository.findAll(pageable,idSekolah);
        model.addAttribute("page",page);
        return new ModelAndView ("redirect:/ekskul");
    }
}
