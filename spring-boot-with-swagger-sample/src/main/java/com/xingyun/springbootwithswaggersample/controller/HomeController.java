package com.xingyun.springbootwithswaggersample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class HomeController {

    /**
     * @ApiIgnore 该注解表示忽略,不会被Swagger扫描解析成API 文档
     * ***/
    @ApiIgnore
    @GetMapping(value = "/")
    public String homePage(){
        return "Hello World";
    }

}
