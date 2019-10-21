package com.alfazid.siasd.controller;

import com.alfazid.siasd.model.GuruEntity;
import com.alfazid.siasd.model.User;
import com.alfazid.siasd.repository.GuruRepository;
import com.alfazid.siasd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 09/10/19.
 */

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private GuruRepository guruRepository;

    @RequestMapping(value = {"/", "/login"},method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public ModelAndView registration(ModelAndView modelAndView){
        User user = new User();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("registration");

        return modelAndView;
    }

    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public  ModelAndView createNewUser(ModelAndView modelAndView,@Valid User user,BindingResult bindingResult){
        User userExist = userService.findUserByUsername(user.getUsername());
        if(userExist !=null){
            bindingResult.rejectValue("email","error.user","There is already a user registered with the email provided");
        }
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("registration");
        }else{
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");
        }

        return modelAndView;
    }

    @RequestMapping(value="/dashboard", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(auth.getName());
        request.getSession().setAttribute("nip", user.getUsername());
        GuruEntity guruEntity =  guruRepository.findByNip(user.getUsername());
        request.getSession().setAttribute("idSekolah", guruEntity.getIdSekolah());
        modelAndView.setViewName("admin/dashboard");
        return modelAndView;
    }
}
