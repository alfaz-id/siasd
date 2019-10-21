/**
 * 
 */
package com.alfazid.siasd.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alfazid.siasd.model.JenisNilai;
import com.alfazid.siasd.model.KelasEntity;
import com.alfazid.siasd.repository.JenisNilaiRepository;

import net.bytebuddy.asm.Advice.Return;
import net.bytebuddy.pool.TypePool.Default.ReaderMode;

/**
 * @author   mohirwanh@gmail.com
 * @web	     www.alfaz.id
 * @Date     Oct 13, 2019
 * @projects siasd @package com.alfazid.siasd.controller
 */

@Controller
@RequestMapping(value = "/jenis-nilai")
public class JenisNilaiController {
	@Autowired
	private JenisNilaiRepository jenisNilaiRepository;
	private int idSekolah=1;
	
	@RequestMapping(value = {"", "/"},method = RequestMethod.GET)
	public ModelAndView index(Model model,@PageableDefault(size = 10) Pageable pageable){
	    Page<JenisNilai> page = jenisNilaiRepository.findAll(pageable);
	    model.addAttribute("page",page);
	    return new ModelAndView ("jenis_nilai/jenis-nilai-list");
	}

	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public ModelAndView create(ModelMap model,JenisNilai jenisNilai){
		model.addAttribute("mode","Create");

		return new ModelAndView("jenis_nilai/jenis-nilai-create");
	}
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public ModelAndView doUCreate(Model model,ModelAndView modelAndView, @ModelAttribute("jenisNilai") JenisNilai jenisNilai,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			model.addAttribute("mode","Create");
			modelAndView.setViewName("jenis_nilai/jenis-nilai-create");
		}else {
			jenisNilai.setIdSekolah(idSekolah);
			jenisNilaiRepository.save(jenisNilai);
			modelAndView.setViewName("redirect:/jenis-nilai");;
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id,Model model) {
		Optional<JenisNilai> jeniNilai = jenisNilaiRepository.findById(id);
		if(jeniNilai.isPresent()) {
			JenisNilai jenisNilais = jeniNilai.get();
			model.addAttribute("jenisNilai", jenisNilais);
		}
		model.addAttribute("mode","Upadate");
		
		return new ModelAndView("jenis_nilai/jenis-nilai-update");
		
	}
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public ModelAndView doUpdate(Model model,ModelAndView modelAndView,@ModelAttribute("jenisNilai") JenisNilai jenisNilai,
			@PathVariable("id") int id,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			model.addAttribute("mode","Upadate");
			modelAndView.setViewName("jenis_nilai/jenis-nilai-update");
		}else {
			jenisNilai.setIdSekolah(idSekolah);
			jenisNilai.setIdJenisNilai(id);
			jenisNilaiRepository.save(jenisNilai);
			modelAndView.setViewName("redirect:/jenis-nilai");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ModelAndView doDelete(Model model,@PathVariable("id") int id){
		Optional<JenisNilai> jeniNilai = jenisNilaiRepository.findById(id);
		if(jeniNilai.isPresent()) {
			JenisNilai jenisNilais = jeniNilai.get();
			jenisNilais.setActive("N");
			jenisNilaiRepository.save(jenisNilais);
			model.addAttribute("jenisNilai", jenisNilais);
		}
		return new ModelAndView ("redirect:/jenis-nilai");
	}

}
