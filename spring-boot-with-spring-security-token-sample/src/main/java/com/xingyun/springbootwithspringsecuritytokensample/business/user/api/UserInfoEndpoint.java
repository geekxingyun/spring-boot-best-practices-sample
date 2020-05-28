package com.xingyun.springbootwithspringsecuritytokensample.business.user.api;

import com.xingyun.springbootwithspringsecuritytokensample.business.user.model.UserInfoEntity;
import com.xingyun.springbootwithspringsecuritytokensample.business.user.model.UserInfoLogin;
import com.xingyun.springbootwithspringsecuritytokensample.business.user.model.UserInfoRegister;
import com.xingyun.springbootwithspringsecuritytokensample.business.user.service.UserInfoService;
import com.xingyun.springbootwithspringsecuritytokensample.model.AppResponse;
import com.xingyun.springbootwithspringsecuritytokensample.util.TokenTools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author qing-feng.zhao
 */
@Slf4j
@Api(value = "UserInfoEndpoint",tags = "用户管理相关API")
@RestController
public class UserInfoEndpoint {

    private final AppResponse appResponse;
    private final UserInfoService userInfoService;
    public UserInfoEndpoint(UserInfoService userInfoService, AppResponse appResponse) {
        this.userInfoService = userInfoService;
        this.appResponse = appResponse;
    }

    @ApiOperation(value = "用户注册",notes ="添加一个用户")
    @PostMapping(value = "/user/add-user.do")
    public AppResponse addUser(@ModelAttribute UserInfoRegister userInfoRegister){
        UserInfoEntity addedUserInfoEntity=new UserInfoEntity();
        BeanUtils.copyProperties(userInfoRegister,addedUserInfoEntity);
        Boolean registerResult=this.userInfoService.saveUserInfo(addedUserInfoEntity);
        if(registerResult){
            log.info("{}用户注册成功",userInfoRegister);
            this.appResponse.setResponseCode(200);
            this.appResponse.setResponseMessage("用户注册成功");
            this.appResponse.setResponseData(null);
        }else{
            log.info("{}用户注册失败",userInfoRegister);
            this.appResponse.setResponseCode(201);
            this.appResponse.setResponseMessage("该账号已注册,用户注册失败");
            this.appResponse.setResponseData(null);
        }
        return this.appResponse;
    }

    @ApiOperation(value = "用户登陆",notes ="输入账号密码登陆返回token")
    @PostMapping(value = "/user/login.do")
    public AppResponse login(@ModelAttribute UserInfoLogin userInfoLogin){
        Optional<UserInfoEntity> userInfoEntityOptional=this.userInfoService.login(userInfoLogin);
        if(userInfoEntityOptional.isPresent()){
            UserInfoEntity userInfoEntity=userInfoEntityOptional.get();
            String token=TokenTools.getToken();
            userInfoEntity.setUserInfoToken(token);
            this.userInfoService.saveUserInfo(userInfoEntity);
            log.info("用户登陆成功:{}",userInfoEntity.toString());
            this.appResponse.setResponseCode(200);
            this.appResponse.setResponseMessage("用户登陆成功");
            this.appResponse.setResponseData(userInfoEntity);
        }else{
            this.appResponse.setResponseCode(200);
            this.appResponse.setResponseMessage("账号或密码不对");
            this.appResponse.setResponseData(null);
        }
        return this.appResponse;
    }

    @ApiOperation(value = "查看所有用户",notes ="需要token权限访问的API")
    @GetMapping(value = "/user/show-user-list.do")
    public AppResponse showUserInfoList(@RequestParam(value = "token")String token){
        List<UserInfoEntity> userInfoEntityList=this.userInfoService.findAllUserInfo();
        this.appResponse.setResponseCode(200);
        this.appResponse.setResponseMessage("查看所用用户成功");
        this.appResponse.setResponseData(userInfoEntityList);
        return this.appResponse;
    }
}
