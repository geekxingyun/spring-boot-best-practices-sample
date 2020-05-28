package com.xingyun.springbootwithspringsecuritytokensample.business.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qing-feng.zhao
 */
@Data
public class UserInfoQuery {
    @ApiModelProperty(name = "uuid",value = "用户唯一Id")
    private Long uuid;
    @ApiModelProperty(name = "userInfoAccount",value = "用户登陆账号",example = "admin")
    private String userInfoAccount;
    @ApiModelProperty(name = "userInfoPassword",value ="用户登陆密码")
    private String userInfoPassword;
    @ApiModelProperty(name = "userInfoToken",value = "用户Token")
    private String userInfoToken;
}
