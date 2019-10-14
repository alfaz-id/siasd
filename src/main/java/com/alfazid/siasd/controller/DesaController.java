/**
 * 
 */
package com.alfazid.siasd.controller;

import java.util.List;
import java.util.Optional;

import javax.xml.ws.http.HTTPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alfazid.siasd.model.DesaEntity;
import com.alfazid.siasd.model.KecamatanEntity;
import com.alfazid.siasd.dto.DesaDto;
import com.alfazid.siasd.repository.DesaRepository;
import com.alfazid.siasd.repository.KecamatanRepository;
import com.alfazid.siasd.service.DesaServices;
import com.alfazid.siasd.utilities.RestError;

/**
 * @author mohirwanh@gmail.com
 *
 * Sep 22, 2019
 *
 * erapot com.alfazid.erapot.controller
 *
 * www.alfaz.id
 */
@RestController
@RequestMapping(value = "/desa")
public class DesaController {
	@Autowired
	private DesaRepository desaRepository;
	@Autowired
	private DesaServices desaServices;
	@Autowired
	private KecamatanRepository kecamatanRepository;
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ModelAndView index(Model model, @PageableDefault(size = 10) Pageable pageable) {
        Page<DesaDto> page = desaServices.findAll(pageable);
        model.addAttribute("page", page);
        return new ModelAndView("desa/desa-list");
    }
	  @RequestMapping(value = "/{by}/{value}", method = RequestMethod.GET)
	    public ModelAndView getByName(Model model, @PageableDefault(size = 10) Pageable pageable, @PathVariable String by, @PathVariable String value) {
	        Page<DesaDto> page = null;
	        switch (by) {
	            case "All":
	                page = desaServices.findAll(pageable);
	                break;
	            default:
	                page = desaServices.findBy(pageable,by, value);
	        }
	        model.addAttribute("page", page);
	        return new ModelAndView("desa/desa-list");
	    }


	   @RequestMapping(value = "/create")
	    public ModelAndView create(ModelMap model, DesaEntity desaEntity) {
	        List<KecamatanEntity> kecamatan = kecamatanRepository.findKecamatan();
	        model.addAttribute("kecamatan",kecamatan);
	        model.addAttribute("mode", "Create");
	      
	        return new ModelAndView("desa/desa-create");
	    }
	   
	    @PostMapping(value = "/")
	    public ModelAndView doPost(Model model, DesaEntity desaEntity, BindingResult result) {
	        if (result.hasErrors()) {
	            new ModelAndView("desa/desa-create");
	        }

	        String id = desaRepository.existByKode(desaEntity.getKodeDesa());
	        if (id != null) {
	            model.addAttribute("error", "true");
	            return new ModelAndView("redirect:/desa/" + id);
	        } else {
	            try {
	                desaRepository.save(desaEntity);
	            } catch (HTTPException he) {
	                return new ModelAndView("error");
	            }
	        }
	        return new ModelAndView("redirect:/desa");
	    }
	    
	    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public ModelAndView update(@PathVariable("id") int id, Model model) {
	        Optional<DesaEntity> desaEntity = desaRepository.findById(id);
	        if (desaEntity.isPresent()) {
	            DesaEntity desa = desaEntity.get();
	            model.addAttribute("desaEntity", desa);
	        }
			List<KecamatanEntity> kecamatan = kecamatanRepository.findKecamatan();
			model.addAttribute("kecamatan",kecamatan);
			model.addAttribute("mode", "updaye");

			return new ModelAndView("desa/desa-update");
	    }
	    
	    @RequestMapping(value ="/{id}",method = RequestMethod.POST)
	    public ModelAndView  doPut(Model model,@ModelAttribute("desaEntity") DesaEntity desaEntity,@PathVariable int id){
	       try{
	           desaEntity.setIdDesa(id);
	           desaRepository.save(desaEntity);
	           model.addAttribute("error",new RestError(false,200,"Success"));
	       }catch (HTTPException he){
	           model.addAttribute("error",new RestError(true,500,"Error"));
	       }
	       return new ModelAndView ("redirect:/desa");
	   }


		@RequestMapping(value ="/delete/{id}",method = RequestMethod.GET)
		public ModelAndView  doDelete(Model model,@PathVariable int id){
			try{
				Optional<DesaEntity> desaEntity = desaRepository.findById(id);
				if (desaEntity.isPresent()) {
					DesaEntity desa = desaEntity.get();
					desa.setActive("N");
					desaRepository.save(desa);
					model.addAttribute("success",new RestError(false,200,"Success"));
				}
			}catch (HTTPException he){
				model.addAttribute("error",new RestError(true,500,"Error"));
			}
			return new ModelAndView ("redirect:/desa");
		}
}
