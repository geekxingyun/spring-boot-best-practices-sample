package com.xingyun.springbootwithcookiehttpssample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author 技术宅星云
 * @功能
 * @date 10/8/2019 7:49 PM
 */
@Slf4j
@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String loginPage(HttpServletRequest request, HttpServletResponse response){
        String value=UUID.randomUUID().toString().replace("-","");
        Cookie cookie=new Cookie("key",value);
        //设置为true HTTP请求将无法获取Cookie
        cookie.setSecure(true);
        response.addCookie(cookie);
        return "login";
    }
}
