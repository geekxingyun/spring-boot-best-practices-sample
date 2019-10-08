package com.xingyun.springbootwithcookiehttpssample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 星云
 * @功能
 * @date 10/8/2019 7:52 PM
 */
@Slf4j
@Controller
public class LoginController {

    @GetMapping(value = "/login.do")
    public String doLogin(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "username")String username, @RequestParam(value = "password")String password){
        log.info(username);
        log.info(password);
        Cookie[] cookies=request.getCookies();
        if(null!=cookies){
            for (Cookie cookie:cookies
                 ) {
                log.info(cookie.getValue());
            }
            return "success";
        }else{
            log.info("cookie is null");
            return "fail";
        }
    }
}
