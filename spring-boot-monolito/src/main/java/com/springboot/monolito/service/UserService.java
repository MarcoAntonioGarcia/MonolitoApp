package com.springboot.monolito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.monolito.entity.User;
import com.springboot.monolito.repository.UserRepository;

@Service
public class UserService {
	
    @Autowired
    private UserRepository repoUser;
    
    public User getByEmail(String email) {
        return repoUser.findByEmail(email);
        }


}
