package com.xingyun.springbootwithspringsecuritytokensample.business.user.model;

import lombok.Data;

/**
 * @author qing-feng.zhao
 */
@Data
public class UserInfoQuery {
    private Long uuid;
    private String userInfoAccount;
    private String userInfoPassword;
    private String userInfoToken;
}
