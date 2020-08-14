package com.alfazid.siasd.controller;

import com.alfazid.siasd.model.entity.BahasaIbu;
import com.alfazid.siasd.service.BahasaIbuService;
import com.alfazid.siasd.utilities.BasePagintaion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by cigist on 23/07/20.
 */

@Controller
@RequestMapping(value = "/bahasa-ibu")
public class BahasIbuController {
    private BahasaIbuService bahasaIbuService;

    public BahasIbuController(BahasaIbuService bahasaIbuService) {
        this.bahasaIbuService = bahasaIbuService;
    }

    @RequestMapping(value = {"", "/"},method = RequestMethod.GET)
    public ModelAndView index(Model model,BasePagintaion basePagintaion,@PageableDefault(size = 10) Pageable pageable){
        Page<BahasaIbu> page = bahasaIbuService.read(new BahasaIbu(),basePagintaion,pageable);
        model.addAttribute("page",page);
        return new ModelAndView ("bahasa/bahasa-list");
    }

    @GetMapping(value = "/create")
    public ModelAndView create(Model model,@Valid BahasaIbu bahasaIbu){
        model.addAttribute("mode","Create");
        return new ModelAndView("bahasa/bahasa-create");
    }

    @PostMapping(value = "/")
    public ModelAndView doPost(BahasaIbu bahasaIbu,BindingResult result){
        if (result.hasErrors()) {
            new ModelAndView ("bahasa/bahasa-list");
        }else{
            bahasaIbuService.create(bahasaIbu);
        }

       return new ModelAndView ("redirect:/bahasa-ibu");
    }

    @GetMapping(value = "/{id}")
    public ModelAndView update(Model model,@PathVariable String id){
        Optional<BahasaIbu> record = bahasaIbuService.findById(id);
        if(!record.isPresent()){
            return new ModelAndView("redirect:/bahasa-list");
        }
        model.addAttribute("mode","Update");
        model.addAttribute("bahasaIbu",record.get());

        return new ModelAndView("bahasa/bahasa-update");
    }

    @PostMapping(value = "/{id}")
    public ModelAndView doPut(BahasaIbu bahasaIbu,@PathVariable String id){
        bahasaIbuService.update(bahasaIbu);
        return new ModelAndView ("redirect:/bahasa-ibu");
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView doDelete(@PathVariable String id){
        bahasaIbuService.delete(id);
        return new ModelAndView ("redirect:/bahasa-ibu");
    }
}
