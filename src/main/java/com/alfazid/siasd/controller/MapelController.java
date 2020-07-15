package com.alfazid.siasd.controller;

import com.alfazid.siasd.model.MapelEntity;
import com.alfazid.siasd.repository.MapelRepository;
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

import java.util.Optional;

/**
 * Created by cigist on 31/07/19.
 */
@RestController
@RequestMapping(value = "/mapel")
public class MapelController {
    @Autowired
    private MapelRepository mapelRepository;
    private int idSekolah=1;


    @RequestMapping(value = {"", "/"},method = RequestMethod.GET)
    public ModelAndView index(Model model,@PageableDefault(size = 10) Pageable pageable){
        Page<MapelEntity> page = mapelRepository.findAll(pageable, idSekolah);
        model.addAttribute("page",page);
        return new ModelAndView ("mapel/mapel-list");
    }
    @RequestMapping(value ="/{by}/{value}",method = RequestMethod.GET)
    public ModelAndView  getByName(Model model,@PageableDefault(size = 10) Pageable pageable,@PathVariable String by,@PathVariable String value){
        if(value.isEmpty()){
            value="";
        }
        Page<MapelEntity> page = null;
        switch (by){
            case "Nama":
                page= mapelRepository.findByName(pageable,idSekolah, value);
                break;
            case "Active":
                page= mapelRepository.findActive(pageable,idSekolah, value);
                break;
            case "All":
                page = mapelRepository.findAll(pageable, idSekolah);
                break;
        }
        model.addAttribute("page",page);
        return new ModelAndView ("mapel/mapel-list");
    }
    @RequestMapping(value ="/create")
    public ModelAndView create(ModelMap model,MapelEntity mapel){
        model.addAttribute("mode","Create");
        return new ModelAndView ("mapel/mapel-create");
    }
    @PostMapping(value="/")
    public ModelAndView  doPost(Model model,MapelEntity mapel,BindingResult result,@PageableDefault(size = 10) Pageable pageable){
        if (result.hasErrors()) {
            new ModelAndView ("mapel/mapel-create");
        }
        try{
            mapel.setIdSekolah(idSekolah);
            mapelRepository.save(mapel);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }
        Page<MapelEntity> page = mapelRepository.findAll(pageable);
        model.addAttribute("page",page);
        return new ModelAndView ("redirect:/mapel");
    }
    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") int id,Model model){
        Optional<MapelEntity> mapel = mapelRepository.findById(id);
        if (mapel.isPresent()) {
            MapelEntity mapelEntity= mapel.get();
            model.addAttribute("mapelEntity", mapelEntity);
        }

        model.addAttribute("mode","Update");
        return new ModelAndView ("mapel/mapel-update");
    }
    @RequestMapping(value ="/{id}",method = RequestMethod.POST)
    public ModelAndView  doPut(Model model,@ModelAttribute("mapelEntity") MapelEntity mapelEntity,@PathVariable int id,
                               @PageableDefault(size = 10) Pageable pageable){
        try{
            mapelEntity.setIdMapel(id);
            mapelEntity.setIdSekolah(idSekolah);
            mapelRepository.save(mapelEntity);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }
        Page<MapelEntity> page = mapelRepository.findAll(pageable,idSekolah);
        model.addAttribute("page",page);
        return new ModelAndView ("redirect:/mapel");
    }
    @RequestMapping(value ="/delete/{id}",method = RequestMethod.GET)
    public ModelAndView  doDelete(Model model,@PathVariable int id,@PageableDefault(size = 10) Pageable pageable){
        try{
            mapelRepository.deleteById(id);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }
        Page<MapelEntity> page = mapelRepository.findAll(pageable,idSekolah);
        model.addAttribute("page",page);
        return new ModelAndView ("redirect:/mapel");
    }
}
