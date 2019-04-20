package com.xingyun.springbootwithswaggersample.model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class User implements Serializable {

    private String username;

    //该字段是敏感字段，因此设置隐藏
    @ApiModelProperty(hidden = true)
    private String password;

    private String token;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
