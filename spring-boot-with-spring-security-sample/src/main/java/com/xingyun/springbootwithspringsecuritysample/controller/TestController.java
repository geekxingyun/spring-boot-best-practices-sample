package com.xingyun.springbootwithspringsecuritysample.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/11/21 12:37
 */
@RestController
public class TestController {

    @GetMapping(value = "/test.do")
    @ApiOperation(value="测试API")
    public String test(){
        return "test success";
    }
}
