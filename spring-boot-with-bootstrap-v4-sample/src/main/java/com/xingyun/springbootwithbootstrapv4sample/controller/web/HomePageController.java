package com.xingyun.springbootwithbootstrapv4sample.controller.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/12/27 18:48
 */
@Slf4j
@Controller
public class HomePageController {

    @GetMapping(value = "/")
    public String indexPage(){
        return "index";
    }
}
