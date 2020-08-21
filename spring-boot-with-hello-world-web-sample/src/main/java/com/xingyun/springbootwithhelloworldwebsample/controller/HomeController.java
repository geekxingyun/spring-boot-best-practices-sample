package com.xingyun.springbootwithhelloworldwebsample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 * @description 首页控制器
 * @date 2020/1/18 15:54
 */
@RestController
public class HomeController {

    @GetMapping(value = "/")
    public String home(){
        return "Hello World,Spring Boot!";
    }
}