package com.alfazid.springmvcsecurity.service;

import com.alfazid.siasd.model.User;
import com.alfazid.siasd.repository.RoleRepository;
import com.alfazid.siasd.repository.UserRepository;
import com.alfazid.siasd.service.UserService;
import org.junit.Before;
import org.mockito.Mock;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 09/10/19.
 */
public class UserServiceTest {
    @Mock
    private UserRepository muserRepository;
    @Mock
    private RoleRepository mroleRepository;
    @Mock
    private BCryptPasswordEncoder mbCryptPasswordEncoder;


    private UserService muserService;
    private User user;

    @Before
    public void setUp(){
        initMocks(this);
        muserService = new UserService(muserRepository,mroleRepository,mbCryptPasswordEncoder);

    }
}
