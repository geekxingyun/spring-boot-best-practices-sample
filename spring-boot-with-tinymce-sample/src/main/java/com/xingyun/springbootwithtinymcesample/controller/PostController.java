package com.xingyun.springbootwithtinymcesample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 星云
 * @功能
 * @date 10/10/2019 11:15 PM
 */
@Slf4j
@Controller
public class PostController {

    @PostMapping(value = "/post.do")
    public String post(@RequestParam(value = "myTextArea")String myTextArea){
        log.info(myTextArea);
        return "success";
    }
}
