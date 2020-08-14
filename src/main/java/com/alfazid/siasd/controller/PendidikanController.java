package com.alfazid.siasd.controller;

import com.alfazid.siasd.model.entity.BahasaIbu;
import com.alfazid.siasd.model.entity.Pendidikan;
import com.alfazid.siasd.repository.PendidikanRepository;
import com.alfazid.siasd.service.PendidikanService;
import com.alfazid.siasd.utilities.BasePagintaion;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by cigist on 14/08/20.
 */

@Controller
@RequestMapping(value = "/pendidikan")
public class PendidikanController {
    private PendidikanService pendidikanService;

    public PendidikanController(PendidikanService pendidikanService) {
        this.pendidikanService = pendidikanService;
    }

    @RequestMapping(value = {"", "/"},method = RequestMethod.GET)
    public ModelAndView index(Model model,BasePagintaion basePagintaion,@PageableDefault(size = 10) Pageable pageable){
        Page<Pendidikan> page = pendidikanService.read(new Pendidikan(),basePagintaion,pageable);
        model.addAttribute("page",page);
        return new ModelAndView ("pendidikan/pendidikan-list");
    }
    
    @GetMapping(value = "/create")
    public ModelAndView create(Model model,@Valid Pendidikan pendidikan) {
    	model.addAttribute("mode","Create");
        return new ModelAndView("pendidikan/pendidikan-create");
    	
    }
    
    @PostMapping(value = "/")
    public ModelAndView doPost(Pendidikan pendidikan,BindingResult bindingResult) {
    	if(bindingResult.hasErrors()) {
    		new ModelAndView ("redirect:/pendidikan");
    	}
    	pendidikanService.create(pendidikan);
    	return new ModelAndView ("redirect:/pendidikan");
    }
    
    @GetMapping(value = "/{id}")
    public ModelAndView update(@PathVariable("id") String id,Model model) {
    	Optional<Pendidikan> pendidikan=pendidikanService.findById(id);
    	if(!pendidikan.isPresent()){
            return new ModelAndView("redirect:/pendidikan");
        }
        model.addAttribute("mode","Update");
        model.addAttribute("pendidikan",pendidikan.get());

        return new ModelAndView("pendidikan/pendidikan-update");
    }
    
    @PostMapping(value = "/{id}")
    public ModelAndView doPut(@PathVariable String id,Pendidikan pendidikan,BindingResult bindingResult) {
    	if(bindingResult.hasErrors()) {
    		new ModelAndView ("redirect:/pendidikan");
    	}
    	pendidikanService.update(pendidikan);
    	return new ModelAndView ("redirect:/pendidikan");
    }
    
    @GetMapping(value = "/delete/{id}")
    public ModelAndView doDelete(@PathVariable ("id") String id) {
    	pendidikanService.delete(id);
    	return new ModelAndView ("redirect:/pendidikan");
    }
}
