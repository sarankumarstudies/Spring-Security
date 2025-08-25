package com.sstudies.saranbank.config;


import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

    @Bean
public UserDetailsService userDetailsService (){

      UserDetails user =  User.withUsername("user").password("{noop}Stdies@123").authorities("read").build();
    /* Studies@54 */
      UserDetails admin =  User.withUsername("admin").password("{bcrypt}$2a$12$wSZq7CPFymmCQil.qq0gjOLDYiCERn//o5llEDe..hPFfW7M6HwdO").authorities("admin").build();
    return new InMemoryUserDetailsManager(user,admin);


}

@Bean
    public PasswordEncoder passwordEncoder (){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
}

}
