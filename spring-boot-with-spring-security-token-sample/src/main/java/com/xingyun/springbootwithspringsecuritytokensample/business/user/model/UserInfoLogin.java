package com.xingyun.springbootwithspringsecuritytokensample.business.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qing-feng.zhao
 */
@Data
public class UserInfoLogin {
    @ApiModelProperty(name = "userInfoAccount",value = "用户登陆账号",example = "admin")
    private String userInfoAccount;
    @ApiModelProperty(name = "user_info_password",value ="用户登陆密码",example = "123456")
    private String userInfoPassword;
}
