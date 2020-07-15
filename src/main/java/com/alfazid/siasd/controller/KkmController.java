/**
 * 
 */
package com.alfazid.siasd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alfazid.siasd.model.dto.KelasDto;
import com.alfazid.siasd.model.dto.KkmDto;
import com.alfazid.siasd.model.dto.MapelDto;
import com.alfazid.siasd.model.entity.Kkm;
import com.alfazid.siasd.repository.KelasRepository;
import com.alfazid.siasd.repository.KkmRepository;
import com.alfazid.siasd.repository.MapelRepository;
import com.alfazid.siasd.service.KkmService;

/**
 * @author mohirwanh@gmail.com
 * @web www.alfaz.id
 * @Date Oct 20, 2019
 * @projects siasd @package com.alfazid.siasd.controller
 */
@Controller
@RequestMapping(value = "/kkm")
public class KkmController {
	@Autowired
	private KkmRepository kkmRepository;
	@Autowired
	private KkmService kkmService;
	@Autowired
	private MapelRepository mapelRepository;
	@Autowired
	private KelasRepository kelasRepository;
	int idSekolah = 1;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ModelAndView index(Model model, @PageableDefault(size = 10) Pageable pageable) {
		Page<KkmDto> page = kkmService.findAll(pageable, idSekolah);
		model.addAttribute("page", page);
		return new ModelAndView("kkm/kkm-list");
	}

	@RequestMapping(value = "/{by}/{value}", method = RequestMethod.GET)
	public ModelAndView getByName(Model model, @PageableDefault(size = 10) Pageable pageable, @PathVariable String by,
			@PathVariable String value) {
		Page<KkmDto> page = null;
		switch (by) {
		case "All":
			page = kkmService.findAll(pageable, idSekolah);
			break;
		default:
			page = kkmService.findBy(pageable, by, value, idSekolah);
		}
		model.addAttribute("page", page);
		return new ModelAndView("kkm/kkm-list");
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(Model model, Kkm kkm) {
		List<MapelDto> mapelEntities = mapelRepository.findMapel(idSekolah);
		model.addAttribute("mapel", mapelEntities);
		List<KelasDto> kelasDtos = kelasRepository.findKelas(idSekolah);
		model.addAttribute("kelas", kelasDtos);
		model.addAttribute("mode", "Create");
		return new ModelAndView("kkm/kkm-create");
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView doCreate(ModelAndView modelAndView, Model model, @ModelAttribute("kkm") Kkm kkm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("mode", "Create");
			modelAndView.setViewName("kkm/kkm-create");
		} else {
			model.addAttribute("mode", "Create");
			kkm.setIdSekolah(idSekolah);
			kkmRepository.save(kkm);
			modelAndView.setViewName("redirect:/kkm");
		}

		return modelAndView;
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id,Model model) {
		Optional<Kkm> kkm = kkmRepository.findById(id);
		if(kkm.isPresent()) {
			Kkm kkms = kkm.get();
			model.addAttribute("kkm", kkms);
			List<MapelDto> mapelEntities = mapelRepository.findMapel(idSekolah);
			model.addAttribute("mapel", mapelEntities);
			List<KelasDto> kelasDtos = kelasRepository.findKelas(idSekolah);
			model.addAttribute("kelas", kelasDtos);
			model.addAttribute("mode","Update");
		}
		return new ModelAndView("kkm/kkm-update");
	}
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public ModelAndView doUpdate(Model model,ModelAndView modelAndView,@ModelAttribute("kkm") Kkm kkm,
			@PathVariable("id") int id,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			model.addAttribute("mode","Update");
			modelAndView.setViewName("kkm/kkm-update");
		}else {
			kkm.setIdSekolah(idSekolah);
			kkm.setIdKkm(id);
			kkmRepository.save(kkm);
			modelAndView.setViewName("redirect:/kkm");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
	public ModelAndView doDelete(Model model,@PathVariable("id") int id){
		Optional<Kkm> kkm = kkmRepository.findById(id);
		if(kkm.isPresent()) {
			Kkm kkms = kkm.get();
			kkms.setActive("N");
			kkmRepository.save(kkms);
		}
		return new ModelAndView ("redirect:/kkm");
	}
}
