package com.xingyun.springbootwithspringsecuritysample.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qing-feng.zhao
 * @description 系统首页页面控制器
 * @date 2019/11/30 21:44
 */
@Controller
public class HomePageController {
    /**
     * 系统首页
     * @return 返回 classpath:/templates/home.html
     */
    @GetMapping(value = {"/","/home"})
    public String homePage(){
        return "home";
    }
}
