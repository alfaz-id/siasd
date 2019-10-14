package com.alfazid.siasd.controller;

import com.alfazid.siasd.model.GuruEntity;
import com.alfazid.siasd.model.SekolahEntity;
import com.alfazid.siasd.repository.SekolahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value = {"", "/"},method = RequestMethod.GET)
    public ModelAndView index(Model model,@PageableDefault(size = 10) Pageable pageable){
        Page<SekolahEntity> page = sekolahRepository.findAll(pageable);
        model.addAttribute("page",page);
        return new ModelAndView ("sekolah/sekolah-list");
    }
}
