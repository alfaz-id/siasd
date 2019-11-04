/**
 * 
 */
package com.alfazid.siasd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alfazid.siasd.repository.MstGlobalRepository;
import com.alfazid.siasd.service.MstGlobalService;

/**
 * @author   mohirwanh@gmail.com
 * @web	     www.alfaz.id
 * @Date     Oct 27, 2019
 * @projects siasd @package com.alfazid.siasd.controller
 */
@Controller
@RequestMapping(value = "/global")
public class MstGlobalController {
	@Autowired
	private MstGlobalRepository globalRepository;
	@Autowired
	private MstGlobalService globalService;

}
