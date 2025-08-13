package com.sstudies.saranbank.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

    @GetMapping("/getNotices")
    public String getNoticeDetails (){
        return "Welcome to Srping Application with secuirty";

    }
}
