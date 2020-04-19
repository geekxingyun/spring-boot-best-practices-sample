package com.xingyun.springbootwithswaggersample.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qing-feng.zhao
 */
@Controller
public class ReadApiController {

    @GetMapping(value = "/read-api.do")
    public String readApi(){
        return "swagger-api";
    }
}
