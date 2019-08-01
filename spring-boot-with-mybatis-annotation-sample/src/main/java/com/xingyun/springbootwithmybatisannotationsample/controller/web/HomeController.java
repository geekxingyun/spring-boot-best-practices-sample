package com.xingyun.springbootwithmybatisannotationsample.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String home(){
        return "index";
    }
}
