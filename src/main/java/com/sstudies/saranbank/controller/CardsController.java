package com.sstudies.saranbank.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/getMyCards")
    public String getMyCardDetails (){
        return "Welcome to Srping Application with secuirty";

    }

}
