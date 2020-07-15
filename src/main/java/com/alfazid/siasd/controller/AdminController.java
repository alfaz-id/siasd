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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alfazid.siasd.model.Kkm;
import com.alfazid.siasd.repository.KkmRepository;

/**
 * @author   mohirwanh@gmail.com
 * @web	     www.alfaz.id
 * @Date     Oct 20, 2019
 * @projects siasd @package com.alfazid.siasd.controller
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
		@Autowired
		private KkmRepository kkmRepository;
		
		@RequestMapping (value = {"","/"},method = RequestMethod.GET)
		public ModelAndView index(Model model,@PageableDefault(size = 10) Pageable pageable) {
			Page<Kkm>page = kkmRepository.findAll(pageable);
			model.addAttribute("page",page);
			return new ModelAndView("admin/admin-list");
		}

	@RequestMapping (value = "/page",method = RequestMethod.GET)
	public ModelAndView paging(Model model,@PageableDefault(size = 10) Pageable pageable) {
		Page<Kkm>page = kkmRepository.findAll(pageable);
		model.addAttribute("page",page);
		return new ModelAndView("admin/admin-list");
	}
}
