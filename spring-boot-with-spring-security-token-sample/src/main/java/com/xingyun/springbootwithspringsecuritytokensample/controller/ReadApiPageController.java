package com.xingyun.springbootwithspringsecuritytokensample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qing-feng.zhao
 */
@Controller
public class ReadApiPageController {
    /**
     * 带注销登陆功能的Swagger API
     * @return
     */
    @GetMapping(value = "/read-api-page.do")
    public String readApi(){
        return "api/swagger-api";
    }
}
