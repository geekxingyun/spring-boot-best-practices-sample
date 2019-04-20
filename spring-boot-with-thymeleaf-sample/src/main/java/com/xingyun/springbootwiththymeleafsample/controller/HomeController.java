package com.xingyun.springbootwiththymeleafsample.controller;

import com.xingyun.springbootwiththymeleafsample.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    //日志系统
    private Logger logger= LoggerFactory.getLogger(HomeController.class);

    @GetMapping(value = "/")
    public String homePage(Model model){
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping(value = "/submit.do")
    public String jumpAction(@ModelAttribute User user){
        logger.info("login user:{}",user.getUsername());
        logger.info("login password:{}",user.getPassword());
        return "result";
    }
}
