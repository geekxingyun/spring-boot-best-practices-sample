package com.xingyun.springbootpoststringarraysample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qing-feng.zhao
 * @description
 * @date 11/7/2019 10:39 PM
 */
@Controller
public class HomPageController {

    @GetMapping(value = "/")
    public String homePage(){
        return "index";
    }
}
