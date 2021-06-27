package com.example.usermain.service;

import com.example.usermain.repository.User;
import com.example.usermain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User usr=repository.findByName(s);
        return new org.springframework.security.core.userdetails.User(usr.getName(),usr.getPassword(),new ArrayList<>());
    }
}
