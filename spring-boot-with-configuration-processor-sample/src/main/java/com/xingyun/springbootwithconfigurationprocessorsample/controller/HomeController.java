package com.xingyun.springbootwithconfigurationprocessorsample.controller;

import com.xingyun.springbootwithconfigurationprocessorsample.properties.MyCustomProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xingyun
 */
@RestController
public class HomeController {

    Logger logger= LoggerFactory.getLogger(HomeController.class);

    @GetMapping(value = "/")
    public String homePage(){
        return "Hello World";
    }

    @Autowired
    public MyCustomProperties myCustomProperties;

    @GetMapping(value = "/test.do")
    public String testCustomProperties(){
        logger.debug("自定义属性测试使用开始");
        logger.debug("server address:{}",myCustomProperties.getServerAddress());
        logger.debug("port:{}",myCustomProperties.getPort());
        logger.debug("username:{}",myCustomProperties.getUsername());
        logger.debug("password:{}",myCustomProperties.getPassword());
        logger.debug("自定义属性测试使用结束");
        return "test success";
    }
}
