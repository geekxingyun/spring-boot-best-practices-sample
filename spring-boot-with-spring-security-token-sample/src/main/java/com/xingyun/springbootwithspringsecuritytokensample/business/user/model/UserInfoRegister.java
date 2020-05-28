package com.xingyun.springbootwithspringsecuritytokensample.business.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qing-feng.zhao
 */
@Data
public class UserInfoRegister {
    @ApiModelProperty(name = "userInfoAccount",value = "注册一个账号",example = "admin")
    private String userInfoAccount;
    @ApiModelProperty(name = "userInfoPassword",value ="注册一个密码",example = "123456")
    private String userInfoPassword;
}
