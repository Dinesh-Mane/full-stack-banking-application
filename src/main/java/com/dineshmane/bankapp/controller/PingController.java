package com.dineshmane.bankapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    // for sanity-check
    @GetMapping("/api/ping")
    public String ping(){
        return "Hello Dineshh!";
    }
}