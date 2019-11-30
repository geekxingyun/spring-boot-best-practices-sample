package com.xingyun.springbootwithspringsecuritysample.controller.api;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/11/21 12:37
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping(value = "/test.do")
    @ApiOperation(value="测试API")
    public String test(){
        return "test success";
    }

    @GetMapping(value = "/encryptPassword.do")
    @ApiOperation(value="密码加密API")
    @ApiImplicitParam(name ="password",value = "原始明文密码",example = "123456")
    public String encryptPassword(@RequestParam(value = "password")String password){
        log.info("原始明文密码是:{}",password);

        String encryptPassword=new BCryptPasswordEncoder().encode(password);
        log.info("原始明文密码是:{}",encryptPassword);
        return encryptPassword;
    }
}
