package com.xingyun.springbootwithjspsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/home.do")
    public String homePage(){
        return "home";
    }
}
