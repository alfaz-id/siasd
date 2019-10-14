package com.alfazid.siasd.controller;

import com.alfazid.siasd.dto.GuruDto;
import com.alfazid.siasd.dto.KelasDto;
import com.alfazid.siasd.dto.MapelDto;
import com.alfazid.siasd.dto.MengajarDto;
import com.alfazid.siasd.repository.GuruRepository;
import com.alfazid.siasd.repository.KelasRepository;
import com.alfazid.siasd.repository.MapelRepository;
import com.alfazid.siasd.repository.MengajarRepository;
import com.alfazid.siasd.service.MengajarService;
import com.alfazid.siasd.model.MapelEntity;
import com.alfazid.siasd.model.MengajarEntity;
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
 * Created by cigist on 31/07/19.
 */
@RestController
@RequestMapping(value = "/mengajar")
public class MengajarController {
    private int idSekolah=1;
    @Autowired
    private MengajarRepository mengajarRepository;
    @Autowired
    private MengajarService mengajarService;
    @Autowired
    private GuruRepository guruRepository;
    @Autowired
    private KelasRepository kelasRepository;
    @Autowired
    private MapelRepository mapelRepository;
    
    @RequestMapping(value = {"", "/"},method = RequestMethod.GET)
    public ModelAndView index(Model model,@PageableDefault(size = 10) Pageable pageable){
        Page<MengajarDto> page = mengajarService.findAll(pageable,idSekolah);
        model.addAttribute("page",page);
        return new ModelAndView ("mengajar/list-mengajar");
    }

    @RequestMapping(value ="/{by}/{value}",method = RequestMethod.GET)
    public ModelAndView  getByName(Model model,@PageableDefault(size = 10) Pageable pageable,@PathVariable String by,@PathVariable String value){
        if(value.isEmpty()){
            value="";
        }
        Page<MengajarDto> page = null;
        switch (by){
            case "All":
                page = mengajarService.findAll(pageable,idSekolah);
                break;
            default:
                page = mengajarService.findBy(pageable,by,value,idSekolah);
        }
        model.addAttribute("page",page);
        return new ModelAndView ("mengajar/list-mengajar");
    }
    @RequestMapping(value ="/create")
    public ModelAndView create(ModelMap model,MengajarEntity mengajarEntity){
        List<GuruDto> guruDtos =guruRepository.findGuru(idSekolah);
        List<KelasDto> kelasDtos = kelasRepository.findKelas(idSekolah);
        List<MapelDto> mapelDtos = mapelRepository.findMapel(idSekolah);

        model.addAttribute("mode","Create");
        model.addAttribute("gurus",guruDtos);
        model.addAttribute("kelass",kelasDtos);
        model.addAttribute("mapels",mapelDtos);

        return new ModelAndView ("mengajar/create");
    }
    @PostMapping(value="/")
    public ModelAndView  doPost(Model model,MengajarEntity mengajarEntity,BindingResult result,@PageableDefault(size = 10) Pageable pageable){
        if (result.hasErrors()) {
            new ModelAndView ("mengajar/create");
        }
        try{
            mengajarEntity.setIdSekolah(idSekolah);
            mengajarRepository.save(mengajarEntity);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }
        Page<MapelEntity> page = mapelRepository.findAll(pageable);
        model.addAttribute("page",page);
        return new ModelAndView ("redirect:/mengajar");
    }
    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") int id,Model model){
        Optional<MengajarEntity> mengajarEntities = mengajarRepository.findById(id);
        if (mengajarEntities.isPresent()) {
            MengajarEntity mengajarEntity= mengajarEntities.get();
            List<GuruDto> guruDtos =guruRepository.findGuru(idSekolah);
            List<KelasDto> kelasDtos = kelasRepository.findKelas(idSekolah);
            List<MapelDto> mapelDtos = mapelRepository.findMapel(idSekolah);

            model.addAttribute("mode","Create");
            model.addAttribute("gurus",guruDtos);
            model.addAttribute("kelass",kelasDtos);
            model.addAttribute("mapels",mapelDtos);
            model.addAttribute("mengajarEntity", mengajarEntity);
        }

        model.addAttribute("mode","Update");
        return new ModelAndView ("mengajar/update");
    }
    @RequestMapping(value ="/{id}",method = RequestMethod.POST)
    public ModelAndView  doPut(Model model,@ModelAttribute("mengajarEntity") MengajarEntity mengajarEntity,@PathVariable int id,
                               @PageableDefault(size = 10) Pageable pageable){
        try{
            mengajarEntity.setIdMengajar(id);
            mengajarEntity.setIdSekolah(idSekolah);
            mengajarRepository.save(mengajarEntity);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }
        Page<MengajarDto> page = mengajarService.findAll(pageable,idSekolah);
        model.addAttribute("page",page);
        return new ModelAndView ("redirect:/mengajar");
    }
    @RequestMapping(value ="/delete/{id}",method = RequestMethod.GET)
    public ModelAndView  doDelete(Model model,@PathVariable int id,@PageableDefault(size = 10) Pageable pageable){
        try{
            mengajarRepository.deleteById(id);
            model.addAttribute("error",new RestError(false,200,"Success"));
        }catch (HTTPException he){
            model.addAttribute("error",new RestError(true,500,"Error"));
        }
        Page<MengajarDto> page = mengajarService.findAll(pageable,idSekolah);
        model.addAttribute("page",page);
        return new ModelAndView ("redirect:/mengajar");
    }
}
