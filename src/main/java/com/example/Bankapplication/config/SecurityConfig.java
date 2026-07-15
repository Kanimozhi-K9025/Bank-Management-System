package com.example.Bankapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
<<<<<<< HEAD
=======
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
>>>>>>> 394798f9933cba42543052bbce1dcee15f85fbeb
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
<<<<<<< HEAD
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
=======
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
>>>>>>> 394798f9933cba42543052bbce1dcee15f85fbeb

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
<<<<<<< HEAD
                        .requestMatchers("/admin/**").permitAll()
                        .anyRequest().authenticated())
=======
                        .requestMatchers("/auth/register").permitAll()
                        .anyRequest().authenticated()
                )
>>>>>>> 394798f9933cba42543052bbce1dcee15f85fbeb
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
<<<<<<< HEAD
}
=======

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
>>>>>>> 394798f9933cba42543052bbce1dcee15f85fbeb
