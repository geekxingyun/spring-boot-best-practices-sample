package com.xingyun.springbootwithspringsecuritysample.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/11/30 21:44
 */
@Controller
public class HomePageController {

    @GetMapping(value = "/")
    public String homePage(){
        return "home";
    }
}
