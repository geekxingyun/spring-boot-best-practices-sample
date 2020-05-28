package com.xingyun.springbootwithspringsecuritytokensample.business.user.service;

import com.xingyun.springbootwithspringsecuritytokensample.business.user.model.UserInfoEntity;
import com.xingyun.springbootwithspringsecuritytokensample.business.user.model.UserInfoLogin;

import java.util.List;
import java.util.Optional;

/**
 * @author qing-feng.zhao
 */
public interface UserInfoService {
    /**
     * 验证Token
     * @param token
     * @return
     */
    Optional<UserInfoEntity> verificationToken(String token);

    /**
     * 保存用户信息
     * @param userInfoEntity
     */
    Boolean saveUserInfo(UserInfoEntity userInfoEntity);

    /**
     * 登陆
     * @return
     */
    Optional<UserInfoEntity> login(UserInfoLogin userInfoLogin);

    List<UserInfoEntity> findAllUserInfo();
}
