package com.xingyun.springbootwithspringsecuritytokensample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qing-feng.zhao
 */
@Controller
public class HomePageController {

    @GetMapping(value = {"/","/home-page.do"})
    public String homePage(){
        return "index";
    }
}
