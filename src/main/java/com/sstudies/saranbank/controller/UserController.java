package com.sstudies.saranbank.controller;


import com.sstudies.saranbank.model.Customer;
import com.sstudies.saranbank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody Customer customer){

        try {
        String hashPassword =  passwordEncoder.encode(customer.getPassword());
        customer.setPassword(hashPassword);
         Customer savedCustomer = customerRepository.save(customer);
        if (savedCustomer.getId()>0){
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created Succcessfully");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error Creating user with the provided credentials");
        }}
        catch(Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occured "+exception);
        }
    }



}
