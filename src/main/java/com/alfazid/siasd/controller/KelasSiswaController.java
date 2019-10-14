package com.alfazid.siasd.controller;

import com.alfazid.siasd.model.KelasSiswaEntity;
import com.alfazid.siasd.repository.KelasSiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by cigist on 31/07/19.
 */
@RestController
@RequestMapping(value = "/kelas_siswa")
public class KelasSiswaController {
    @Autowired
    private KelasSiswaRepository kelasSiswaRepository;
    
    @RequestMapping(value = {"", "/"},method = RequestMethod.GET)
    public ModelAndView index(Model model,@PageableDefault(size = 10) Pageable pageable){
        Page<KelasSiswaEntity> page = kelasSiswaRepository.findAll(pageable);
        model.addAttribute("page",page);
        return new ModelAndView ("kelas_siswa/list-kelas-siswa");
    }
}
