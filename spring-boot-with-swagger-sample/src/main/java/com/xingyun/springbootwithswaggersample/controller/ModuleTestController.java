package com.xingyun.springbootwithswaggersample.controller;

import com.xingyun.springbootwithswaggersample.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api")
@Api(tags = "Module-Test-Controller", description = "项目模块二API")
@RestController
public class ModuleTestController {

    @Autowired
    User user;

    @ApiOperation(value="登录获取用户信息")
    //配置多个参数
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "登录账号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "登录密码", required = true, dataType = "String")
    })
    @PostMapping(value = "/login.do")
    public User loginMethod(@RequestParam(value = "username",required = false,defaultValue = "admin") String usernameArg,@RequestParam(value = "password",required = false,defaultValue = "root") String passwordArg){
        user.setUsername(usernameArg);
        user.setPassword(passwordArg);
        return user;
    }

    @ApiOperation(value="根据账号获取用户信息")
    //文档中配置单个参数
    @ApiImplicitParam(name = "username", value = "登录账号", required = true, dataType = "String")
    @GetMapping(value = "/user/{username}")
    public User groupOneTest(@PathVariable("username") String usernameArg){
        user.setUsername(usernameArg);
        user.setPassword("root");
        return user;
    }
}
