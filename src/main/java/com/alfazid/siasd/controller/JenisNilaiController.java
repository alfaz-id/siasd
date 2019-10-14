/**
 * 
 */
package com.alfazid.siasd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alfazid.siasd.model.JenisNilai;
import com.alfazid.siasd.model.KelasEntity;
import com.alfazid.siasd.repository.JenisNilaiRepository;

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

	@RequestMapping(value = "/create")
	public ModelAndView create(ModelMap model,JenisNilai jenisNilai){
		model.addAttribute("mode","Create");

		return new ModelAndView("jenis_nilai/jenis-nilai-create");
	}

}
