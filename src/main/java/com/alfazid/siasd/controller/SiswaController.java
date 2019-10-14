package com.alfazid.siasd.controller;

import com.alfazid.siasd.model.SiswaEntity;
import com.alfazid.siasd.repository.SiswaRepository;
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
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 28/09/19.
 */
@Controller
@RequestMapping(name = "/siswa")
public class SiswaController {
    @Autowired
    SiswaRepository siswaRepository;
    private int idSekolah=1;

    @RequestMapping(value = {"", "/siswa"}, method = RequestMethod.GET)
    public ModelAndView index(Model model, @PageableDefault(size = 10) Pageable pageable) {
        Page<SiswaEntity> page = siswaRepository.findAll(pageable);
        model.addAttribute("page", page);
        return new ModelAndView("siswa/siswa-list");
    }

//    @RequestMapping(value ="/{by}/{value}",method = RequestMethod.GET)
//    public ModelAndView  getByName(Model model,@PageableDefault(size = 10) Pageable pageable,@PathVariable String by,@PathVariable String value){
//        if(value.isEmpty()){
//            value="";
//        }
//        Page<SiswaEntity> page = null;
//        switch (by){
//            case "Nama":
//                page= siswaRepository.findByName(pageable,idSekolah, value);
//                break;
//            case "Active":
//                page= siswaRepository.findActive(pageable,idSekolah, value);
//                break;
//            case "All":
//                page = siswaRepository.findAll(pageable,idSekolah);
//                break;
//        }
//        model.addAttribute("page",page);
//        return new ModelAndView("siswa/siswa-list");
//    }
}
