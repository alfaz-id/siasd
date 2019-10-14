package com.alfazid.siasd.controller;

import com.alfazid.siasd.model.WaliKelasEntity;
import com.alfazid.siasd.dto.*;
import com.alfazid.siasd.repository.GuruRepository;
import com.alfazid.siasd.repository.KelasRepository;
import com.alfazid.siasd.repository.WalikelasRepository;
import com.alfazid.siasd.service.WalikelasService;
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
import java.util.List;
import java.util.Optional;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 07/09/19.
 */
@RestController
@RequestMapping(value = "/walikelas")
public class WalikelasController {
    private int idSekolah=1;

    @Autowired
    private WalikelasRepository walikelasRepository;
    @Autowired
    private WalikelasService walikelasService;
    @Autowired
    private GuruRepository guruRepository;
    @Autowired
    private KelasRepository kelasRepository;

    @RequestMapping(value = {"", "/"},method = RequestMethod.GET)
    public ModelAndView index(Model model,@PageableDefault(size = 10) Pageable pageable){
        Page<WalikelasDto> page = walikelasService.findAll(pageable,idSekolah);
        model.addAttribute("page",page);
        return new ModelAndView ("walikelas/walikelas-list");
    }
    @RequestMapping(value ="/{by}/{value}",method = RequestMethod.GET)
    public ModelAndView  getByName(Model model,@PageableDefault(size = 10) Pageable pageable,@PathVariable String by,@PathVariable String value){
        if(value.isEmpty()){
            value="";
        }
        Page<WalikelasDto> page = null;
        switch (by){
            case "All":
                page = walikelasService.findAll(pageable,idSekolah);
                break;
            default:
                page = walikelasService.findBy(pageable,by,value,idSekolah);
        }
        model.addAttribute("page",page);
        return new ModelAndView ("walikelas/walikelas-list");
    }
    @RequestMapping(value ="/create")
    public ModelAndView create(ModelMap model,WaliKelasEntity waliKelasEntity){
        List<GuruDto> guruDtos =guruRepository.findGuru(idSekolah);
        List<KelasDto> kelasDtos = kelasRepository.findKelas(idSekolah);

        model.addAttribute("mode","Create");
        model.addAttribute("gurus",guruDtos);
        model.addAttribute("kelass",kelasDtos);

        return new ModelAndView ("walikelas/walikelas-create");
    }
    @PostMapping(value="/")
    public ModelAndView  doPost(Model model,WaliKelasEntity waliKelasEntity,BindingResult result,@PageableDefault(size = 10) Pageable pageable){
        if (result.hasErrors()) {
            new ModelAndView ("walikelas/walikelas-create");
        }
        try{
            waliKelasEntity.setIdSekolah(idSekolah);
            walikelasRepository.save(waliKelasEntity);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }

        return new ModelAndView ("redirect:/walikelas");
    }
    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") int id,Model model){
        Optional<WaliKelasEntity> walikelasEntities = walikelasRepository.findById(id);
        if (walikelasEntities.isPresent()) {
            WaliKelasEntity waliKelasEntity= walikelasEntities.get();
            List<GuruDto> guruDtos =guruRepository.findGuru(idSekolah);
            List<KelasDto> kelasDtos = kelasRepository.findKelas(idSekolah);


            model.addAttribute("mode","Create");
            model.addAttribute("gurus",guruDtos);
            model.addAttribute("kelass",kelasDtos);
            model.addAttribute("waliKelasEntity", waliKelasEntity);
        }

        model.addAttribute("mode","Update");
        return new ModelAndView ("walikelas/walikelas-update");
    }
    @RequestMapping(value ="/{id}",method = RequestMethod.POST)
    public ModelAndView  doPut(Model model,@ModelAttribute("walikelasEntity") WaliKelasEntity waliKelasEntity,@PathVariable int id,
                               @PageableDefault(size = 10) Pageable pageable){
        try{
            waliKelasEntity.setIdWakel(id);
            waliKelasEntity.setIdSekolah(idSekolah);
            walikelasRepository.save(waliKelasEntity);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }
        return new ModelAndView ("redirect:/walikelas");
    }
    @RequestMapping(value ="/delete/{id}",method = RequestMethod.GET)
    public ModelAndView  doDelete(Model model,@PathVariable int id,@PageableDefault(size = 10) Pageable pageable){
        try{
            walikelasRepository.deleteById(id);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }
        return new ModelAndView ("redirect:/walikelas");
    }
}
