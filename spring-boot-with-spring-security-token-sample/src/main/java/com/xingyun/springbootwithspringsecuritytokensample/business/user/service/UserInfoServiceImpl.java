package com.xingyun.springbootwithspringsecuritytokensample.business.user.service;

import com.xingyun.springbootwithspringsecuritytokensample.business.user.dao.jpa.UserInfoJpaRepository;
import com.xingyun.springbootwithspringsecuritytokensample.business.user.model.UserInfoEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author qing-feng.zhao
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

    private final UserInfoJpaRepository userInfoJpaRepository;
    public UserInfoServiceImpl(UserInfoJpaRepository userInfoJpaRepository) {
        this.userInfoJpaRepository = userInfoJpaRepository;
    }

    @Override
    public Optional<UserInfoEntity> verificationToken(String token) {
        return this.userInfoJpaRepository.findByUserInfoToken(token);
    }
}
