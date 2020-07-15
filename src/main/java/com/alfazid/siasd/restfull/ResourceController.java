package com.alfazid.siasd.restfull;

import com.alfazid.siasd.model.entity.User;
import com.alfazid.siasd.model.entity.RandomCity;
import com.alfazid.siasd.repository.RandomCityRepository;
import com.alfazid.siasd.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 10/10/19.
 */
@RestController
@RequestMapping("/jwttest")
public class ResourceController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RandomCityRepository randomCityRepository;

    @RequestMapping(value ="/cities")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public List<RandomCity> getUser(){
        return randomCityRepository.findAll();
    }

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

}