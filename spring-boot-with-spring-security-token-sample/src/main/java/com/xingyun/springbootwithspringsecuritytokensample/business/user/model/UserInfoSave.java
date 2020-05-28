package com.xingyun.springbootwithspringsecuritytokensample.business.user.model;

import lombok.Data;

/**
 * @author qing-feng.zhao
 */
@Data
public class UserInfoSave {
    private String userInfoAccount;
    private String userInfoPassword;
    private String userInfoToken;
}
