package com.xingyun.springbootwithhttpssample.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/12/19 12:24
 */
@Controller
public class HomePageController {
    @GetMapping(value = "/")
    public String homePage(){
      return "index";
    }
}
