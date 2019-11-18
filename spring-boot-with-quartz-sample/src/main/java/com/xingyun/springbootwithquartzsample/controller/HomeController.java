package com.xingyun.springbootwithquartzsample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 * @功能 首页访问
 */
@RestController
public class HomeController {

    @GetMapping(value = "/")
    public String home(){
        return "Hello world";
    }
}
