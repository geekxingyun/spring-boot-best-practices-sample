package com.xingyun.springbootwithmybatisxmlsample.model.business;

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
    private static final long serialVersionUID = 466317489683661466L;
    //用户Id
    private Long userInfoId;
    //用户账号
    private String userInfoAccount;
    //用户密码
    private String userInfoPassword;
    //用户年龄
    private Integer userInfoAge;
    //用户性别
    private Boolean userInfoSex;
}
