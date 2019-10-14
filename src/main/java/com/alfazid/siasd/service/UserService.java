package com.alfazid.siasd.service;

import com.alfazid.siasd.model.User;
import com.alfazid.siasd.repository.RoleRepository;
import com.alfazid.siasd.model.Role;
import com.alfazid.siasd.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 09/10/19.
 */

@Service("userService")
@AllArgsConstructor
@NoArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public User findUserByUsername(String username){
        return  userRepository.findByUsername(username);
    }

    public void saveUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role role = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet(Arrays.asList(role)));
        userRepository.save(user);

    }
}