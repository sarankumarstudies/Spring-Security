package com.sstudies.saranbank.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/contacts")
    public String getContacts (){
        return "Welcome to Srping Application with secuirty";

    }
}
