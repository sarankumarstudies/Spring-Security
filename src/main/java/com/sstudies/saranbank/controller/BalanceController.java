package com.sstudies.saranbank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @GetMapping("/myBalance")
    public String myBalanceDetails (){
        return "Welcome to Srping Application with secuirty";

    }
}
