package com.xingyun.springbootwithtinymcesample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 星云
 * @功能
 * @date 10/10/2019 10:59 PM
 */
@Controller
public class HomePageController {

    @GetMapping(value = "/")
    public String homePage(){
        return "index";
    }
}
