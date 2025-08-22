package com.sstudies.saranbank.config;


import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests.requestMatchers("/myAccount","/myBalance","/myLoans", "/getMyCards").authenticated());

        http.authorizeHttpRequests((requests) -> requests.requestMatchers("/getNotices","/contacts","/error").permitAll ());/*
        requests.anyRequest().permitAll() // permit all the request without Authentication
          requests.anyRequest().denyAll() // deny All the request
           requests.anyRequest().authenticated());// Authenticate All the requests
         */

        http.formLogin(flc->{
           flc.disable();
        } );
        http.httpBasic(withDefaults());
        return http.build();
    }

}
