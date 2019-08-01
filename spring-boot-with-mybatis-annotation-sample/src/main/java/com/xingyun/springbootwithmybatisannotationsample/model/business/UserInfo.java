package com.xingyun.springbootwithmybatisannotationsample.model.business;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Component
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 7205678247939117273L;
    //用户Id
    private Long userInfoId;
    //用户名称
    private String userInfoName;
    //用户手机号
    private String userInfoMobile;
    //用户年龄
    private Integer userInfoAge;
    //用户性别
    private Boolean userInfoSex;
}
