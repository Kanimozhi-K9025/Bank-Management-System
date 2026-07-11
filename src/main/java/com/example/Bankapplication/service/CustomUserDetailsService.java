package com.example.Bankapplication.service;

import com.example.Bankapplication.entity.User;
import com.example.Bankapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        try {
            System.out.println("Entered username: " + username);

            User user = userRepository.findByUsername(username)
                    .orElseThrow(() ->
                            new UsernameNotFoundException("User not found"));

            System.out.println("Database username: " + user.getUsername());
            System.out.println("Encoded password: " + user.getPassword());
            System.out.println("Role: " + user.getRole());
            System.out.println("User loaded successfully");

            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    Collections.singleton(
                            new SimpleGrantedAuthority("ROLE_" + user.getRole())
                    )
            );

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}