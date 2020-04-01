package com.xingyun.springbootwithredissample.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qing-feng.zhao
 */
@Controller
public class HomePageController {

    @GetMapping(value = "/")
    public String home(){
        return "index";
    }
}
