package com.xingyun.springbootwithspringsecuritytokensample.business.user.api;

import com.xingyun.springbootwithspringsecuritytokensample.business.user.service.UserInfoService;
import com.xingyun.springbootwithspringsecuritytokensample.model.AppResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public AppResponse addUser(){
        this.appResponse.setResponseCode(200);
        this.appResponse.setResponseMessage("创建用户成功");
        this.appResponse.setResponseData(null);
        return this.appResponse;
    }
}
