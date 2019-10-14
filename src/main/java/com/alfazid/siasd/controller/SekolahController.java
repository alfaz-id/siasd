package com.alfazid.siasd.controller;

import com.alfazid.siasd.model.SekolahEntity;
import com.alfazid.siasd.repository.SekolahRepository;
import com.alfazid.siasd.service.SekolahService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 13/10/19.
 */
@Controller
@RequestMapping(value = "/sekolah")
public class SekolahController {
    @Autowired
    private SekolahRepository sekolahRepository;
    @Autowired
    private SekolahService sekolahService;

    @RequestMapping(value = {"", "/"},method = RequestMethod.GET)
    public ModelAndView index(Model model,@PageableDefault(size = 10) Pageable pageable){
        Page<SekolahEntity> page = sekolahRepository.findAll(pageable);
        model.addAttribute("page",page);
        return new ModelAndView ("sekolah/sekolah-list");
    }

    @RequestMapping(value = "/{by}/{value}", method = RequestMethod.GET)
    public ModelAndView findByValue(Model model, @PageableDefault(size = 10) Pageable pageable, @PathVariable String by, @PathVariable String value){
        Page<SekolahEntity> page=null;
        switch(by){
            case "All":
            page = sekolahRepository.findAll(pageable);
            break;
            default:
            page = sekolahService.findByValue(pageable, by, value);
        }
        model.addAttribute("page", page);
        return new ModelAndView("sekolah/sekolah-list");
    }
}
