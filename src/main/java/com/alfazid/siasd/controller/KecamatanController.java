package com.alfazid.siasd.controller;

import com.alfazid.siasd.model.entity.KabupatenEntity;
import com.alfazid.siasd.model.entity.KecamatanEntity;
import com.alfazid.siasd.model.dto.KecamatanDto;
import com.alfazid.siasd.service.KecamatanService;
import com.alfazid.siasd.utilities.RestError;

import java.util.List;
import java.util.Optional;

import javax.xml.ws.http.HTTPException;

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

import com.alfazid.siasd.repository.KabupatenRepository;
import com.alfazid.siasd.repository.KecamatanRepository;

@RestController
@RequestMapping(value = "/kecamatan")
public class KecamatanController {
	@Autowired
	private KecamatanRepository kecamatanRepository;
	@Autowired
	private KecamatanService kecamatanService;
	@Autowired
    private KabupatenRepository kabupatenRepository;
	
	  @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	    public ModelAndView index(Model model, @PageableDefault(size = 10) Pageable pageable) {
	        Page<KecamatanDto> page = kecamatanService.findAll(pageable);
	        model.addAttribute("page", page);
	        return new ModelAndView("kecamatan/kecamatan-list");
	    }
	   @RequestMapping(value = "/{by}/{value}", method = RequestMethod.GET)
	    public ModelAndView getByName(Model model, @PageableDefault(size = 10) Pageable pageable, @PathVariable String by, @PathVariable String value) {
	        Page<KecamatanDto> page = null;
	        switch (by) {
	            case "All":
	                page = kecamatanService.findAll(pageable);
	                break;
	            default:
	                page = kecamatanService.findBy(pageable,by, value);
	        }
	        model.addAttribute("page", page);
	        return new ModelAndView("kecamatan/kecamatan-list");
	    }
	   
	   @RequestMapping(value = "/create")
	    public ModelAndView create(ModelMap model, KecamatanEntity kecamatanEntity) {
	        List<KabupatenEntity> kabupaten = kabupatenRepository.findKabupaten();
	        model.addAttribute("kabupaten",kabupaten);
	        model.addAttribute("mode", "Create");
	      
	        return new ModelAndView("kecamatan/kecamatan-create");
	    }
	   
	    @PostMapping(value = "/")
	    public ModelAndView doPost(Model model, KecamatanEntity kecamatanEntity, BindingResult result, @PageableDefault(size = 10) Pageable pageable) {
	        if (result.hasErrors()) {
	            new ModelAndView("kecamatan/kecamatan-create");
	        }

	        String id = kecamatanRepository.existByKode(kecamatanEntity.getKodeKecamatan());
	        if (id != null) {
	            model.addAttribute("error", "true");
	            return new ModelAndView("redirect:/kecamatan/" + id);
	        } else {
	            try {
	                kecamatanRepository.save(kecamatanEntity);
	            } catch (HTTPException he) {
	                return new ModelAndView("error");
	            }
	        }
	        return new ModelAndView("redirect:/kecamatan");
	    }
	    
	    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public ModelAndView update(@PathVariable("id") int id, Model model) {
	        Optional<KecamatanEntity> kecamatanEntity = kecamatanRepository.findById(id);
	        if (kecamatanEntity.isPresent()) {
	            KecamatanEntity kecamatan = kecamatanEntity.get();
	            model.addAttribute("kecamatanEntity", kecamatan);
	        }
	        List<KabupatenEntity> kabupaten = kabupatenRepository.findKabupaten();
	        model.addAttribute("kabupaten",kabupaten);
	        model.addAttribute("mode", "Update");
	        return new ModelAndView("kecamatan/kecamatan-update");
	    }
	    
	    @RequestMapping(value ="/{id}",method = RequestMethod.POST)
	    public ModelAndView  doPut(Model model,@ModelAttribute("kecamatanEntity") KecamatanEntity kecamatanEntity,@PathVariable int id){
	       try{
	           kecamatanEntity.setIdKecamatan(id);
	           kecamatanRepository.save(kecamatanEntity);
	           model.addAttribute("error",new RestError(false,200,"Success"));
	       }catch (HTTPException he){
	           model.addAttribute("error",new RestError(true,500,"Error"));
	       }
	       return new ModelAndView ("redirect:/kecamatan");
	   }
}
