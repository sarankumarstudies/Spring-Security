package com.sstudies.saranbank.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcountController {

    @GetMapping("/myAccount")
    public String getAccountDetails (){
        return "Welcome to Srping Application with secuirty";

    }

}
