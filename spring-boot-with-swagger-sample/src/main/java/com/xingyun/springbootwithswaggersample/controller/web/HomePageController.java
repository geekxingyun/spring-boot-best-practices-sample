package com.xingyun.springbootwithswaggersample.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
public class HomePageController {

    /**
     * @ApiIgnore 该注解表示忽略,不会被Swagger扫描解析成API 文档
     * ***/
    @ApiIgnore
    @GetMapping(value = "/")
    public String homePage(){
        return "index";
    }
}
