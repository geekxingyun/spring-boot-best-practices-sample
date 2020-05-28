package com.xingyun.springbootwithspringsecuritytokensample.business.user.api;

import com.xingyun.springbootwithspringsecuritytokensample.business.user.model.UserInfoEntity;
import com.xingyun.springbootwithspringsecuritytokensample.business.user.model.UserInfoLogin;
import com.xingyun.springbootwithspringsecuritytokensample.business.user.model.UserInfoQuery;
import com.xingyun.springbootwithspringsecuritytokensample.business.user.service.UserInfoService;
import com.xingyun.springbootwithspringsecuritytokensample.model.AppResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author qing-feng.zhao
 */
@RestController
public class UserInfoEndpoint {

    private final AppResponse appResponse;
    private final UserInfoService userInfoService;
    public UserInfoEndpoint(UserInfoService userInfoService, AppResponse appResponse) {
        this.userInfoService = userInfoService;
        this.appResponse = appResponse;
    }

    @PostMapping(value = "/user/add-user.do")
    public AppResponse addUser(@ModelAttribute UserInfoQuery userInfoQuery){
        UserInfoEntity addedUserInfoEntity=new UserInfoEntity();
        BeanUtils.copyProperties(userInfoQuery,addedUserInfoEntity);
        UserInfoEntity saveUserInfoEntity=this.userInfoService.saveUserInfo(addedUserInfoEntity);
        this.appResponse.setResponseCode(200);
        this.appResponse.setResponseMessage("用户添加成功");
        this.appResponse.setResponseData(saveUserInfoEntity);
        return this.appResponse;
    }

    @PostMapping(value = "/user/login.do")
    public AppResponse login(@ModelAttribute UserInfoLogin userInfoLogin){
        Optional<UserInfoEntity> userInfoEntityOptional=this.userInfoService.login(userInfoLogin);
        if(userInfoEntityOptional.isPresent()){
            UserInfoEntity userInfoEntity=userInfoEntityOptional.get();
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
}
