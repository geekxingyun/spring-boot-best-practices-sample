package com.xingyun.springbootwithspringdatajpasample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 星云
 * @功能
 * @date 9/28/2019 8:19 PM
 */
@RestController
public class HomeController {

    @GetMapping(value = "/")
    public String home(){
        return "Hello World,Spring Boot With Spring Data JPA";
    }
}
