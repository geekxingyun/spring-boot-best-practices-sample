package com.xingyun.springbootwithlog4j2sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 技术宅星云
 * @功能
 * @date 9/15/2019 3:44 PM
 */
@RestController
public class IndexController {
    @GetMapping(value = "/")
    public String index(){
        return "Spring Boot With Log4j2 Sample";
    }
}
