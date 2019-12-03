package com.xingyun.springbootwithspringsecuritysample.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qing-feng.zhao
 * @description 欢迎页面控制器
 * @date 2019/11/30 21:53
 */
@Controller
public class HelloPageController {
    /**
     * 拦截 /hello.do 请求
     * @return 返回 classpath:/templates/hello.html
     */
    @GetMapping(value = "/hello.do")
    public String helloPage(){
        return "hello";
    }
}