package com.ruben.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Auth {
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    
}
