package com.xingyun.springbootwithjavamailsendersample.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/12/21 20:04
 */
@Slf4j
@Controller
public class HomePageController {
    @GetMapping(value = {"/","/index.do"})
    public String homePage(){
        return "index";
    }
}
