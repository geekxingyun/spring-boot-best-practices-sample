package com.xingyun.springbootwithspringsecuritysample.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qing-feng.zhao
 * @description 登录页面控制器
 * @date 2019/12/2 23:05
 */
@Slf4j
@Controller
public class LoginPageController {
    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping(value = "/jumpLoginPageOrCheckLogin.do")
    public String loginPage(){
        log.info("welcome to visit login page controller");
        return "customize-login";
    }
}
