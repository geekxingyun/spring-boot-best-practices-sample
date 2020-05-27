package com.xingyun.springbootwithspringsecuritytokensample.business.user.service;

import com.xingyun.springbootwithspringsecuritytokensample.business.user.model.UserInfoEntity;

import java.util.Optional;

/**
 * @author qing-feng.zhao
 */
public interface UserInfoService {
    /**
     * 验证TokenId
     * @param token
     * @return
     */
    Optional<UserInfoEntity> verificationToken(String token);
}
