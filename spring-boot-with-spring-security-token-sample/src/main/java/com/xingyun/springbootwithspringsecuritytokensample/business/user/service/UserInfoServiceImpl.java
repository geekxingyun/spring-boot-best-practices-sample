package com.xingyun.springbootwithspringsecuritytokensample.business.user.service;

import com.xingyun.springbootwithspringsecuritytokensample.business.user.dao.jpa.UserInfoJpaRepository;
import com.xingyun.springbootwithspringsecuritytokensample.business.user.model.UserInfoEntity;
import com.xingyun.springbootwithspringsecuritytokensample.business.user.model.UserInfoLogin;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
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

    @Override
    public UserInfoEntity saveUserInfo(UserInfoEntity userInfoEntity) {
        return this.userInfoJpaRepository.save(userInfoEntity);
    }

    @Override
    public Optional<UserInfoEntity> login(UserInfoLogin userInfoLogin) {
        UserInfoEntity loginUserInfoEntity=new UserInfoEntity();
        BeanUtils.copyProperties(userInfoLogin,loginUserInfoEntity);
        Example<UserInfoEntity> userInfoEntityExample= Example.of(loginUserInfoEntity);
        return this.userInfoJpaRepository.findOne(userInfoEntityExample);
    }
}
