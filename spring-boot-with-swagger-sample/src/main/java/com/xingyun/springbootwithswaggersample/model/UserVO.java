package com.xingyun.springbootwithswaggersample.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserVO implements Serializable {
    /**
     * 账号
     */
    @ApiModelProperty(name = "username",value = "账号",example = "张三",dataType = "string")
    private String username;
    /**
     * 密码
     * 该字段是敏感字段，因此设置隐藏
     */
    @ApiModelProperty(name = "password",value = "密码",hidden = true,example = "123456",dataType = "string")
    private String password;
    /**
     * Token
     */
    @ApiModelProperty(name = "token",value = "Token",example = "abdeddfjlfkdjalfjal",dataType = "string")
    private String token;
}
