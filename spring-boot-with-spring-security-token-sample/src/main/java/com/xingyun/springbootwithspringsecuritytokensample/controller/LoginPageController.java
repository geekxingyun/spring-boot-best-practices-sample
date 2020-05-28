package com.xingyun.springbootwithspringsecuritytokensample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qing-feng.zhao
 */
@Controller
public class LoginPageController {

    @GetMapping(value = "/toLoginPage.do")
    public String loginPage(){
        return "login/customize-login";
    }
}
