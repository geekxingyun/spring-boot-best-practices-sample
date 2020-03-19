package com.xingyun.springbootwithdockersample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 */
@RestController
public class HomeController {

    @GetMapping(value = "/")
    public String home(){
        return "Hello,Spring Boot With Docker";
    }
}

