package com.xingyun.springbootwithdockersample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 注解解释为Spring MVC 控制器
 * @author qing-feng.zhao
 */
@RestController
public class HomeController {

    /**
     * @GetMapping(value = "/") 拦截 / 请求交给Spring MVC 处理
     * @return
     */
    @GetMapping(value = "/")
    public String home(){
        return "Hello,Spring Boot 2 With Docker";
    }
}