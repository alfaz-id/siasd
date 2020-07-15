package com.alfazid.siasd.controller;

import com.alfazid.siasd.model.entity.GlobalEntity;
import com.alfazid.siasd.model.entity.ProvinsiEntity;
import com.alfazid.siasd.model.entity.SiswaEntity;
import com.alfazid.siasd.repository.MstGlobalRepository;
import com.alfazid.siasd.repository.ProvinsiRepository;
import com.alfazid.siasd.repository.SiswaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 28/09/19.
 */
@Controller
@RequestMapping(value = "/siswa")
public class SiswaController {
    @Autowired
    private SiswaRepository siswaRepository;
    @Autowired
    private MstGlobalRepository globalRepository;
    @Autowired
    private ProvinsiRepository provinsiRepository;
    private int idSekolah=1;

    @RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
    public ModelAndView indexSiswa(Model model, @PageableDefault(size = 10) Pageable pageable) {
        Page<SiswaEntity> page = siswaRepository.findAll(pageable);
        model.addAttribute("page", page);
        return new ModelAndView("siswa/siswa-list");
    }
    @RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(Model model, SiswaEntity siswaEntity) {
    	List<GlobalEntity> globalEntities = globalRepository.findByTypeMaster("JOB");
    	List<ProvinsiEntity>provinsiEntities = provinsiRepository.findProvinsi();
    	
    	model.addAttribute("globalEntities", globalEntities);
    	model.addAttribute("provinsiEntities", provinsiEntities);
    	model.addAttribute("mode", "Create");
		return new ModelAndView("siswa/siswa-create");
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView doCreate(ModelAndView modelAndView, Model model, @ModelAttribute("siswa") SiswaEntity siswa,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("mode", "Create");
			modelAndView.setViewName("siswa/siswa-create");
		} else {
			model.addAttribute("mode", "Create");
			siswa.setIdSekolah(idSekolah);
			siswaRepository.save(siswa);
			modelAndView.setViewName("redirect:/siswa");
		}

		return modelAndView;
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
