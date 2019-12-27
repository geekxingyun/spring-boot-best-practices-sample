package com.xingyun.springbootwithbootstrapv4sample.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/12/27 18:49
 */
@Controller
public class LoginPageController {

    @GetMapping(value = "/login.do")
    public String loginPage(){
        return "customize-login";
    }
}
