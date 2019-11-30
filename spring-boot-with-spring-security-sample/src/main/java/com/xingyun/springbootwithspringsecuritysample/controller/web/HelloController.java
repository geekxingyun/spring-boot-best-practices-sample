package com.xingyun.springbootwithspringsecuritysample.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/11/30 21:53
 */
@Controller
public class HelloController {

    @GetMapping(value = "/hello")
    public String helloPage(){
        return "hello";
    }
}
