package com.xingyun.springbootwithmybatisxmlsample.service;

import com.xingyun.springbootwithmybatisxmlsample.dao.mapper.UserInfoMapper;
import com.xingyun.springbootwithmybatisxmlsample.model.business.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserInfoImpl implements IUserInfo {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public int addUserInfo(UserInfo userInfo) {
        return userInfoMapper.insertUserInfo(userInfo);
    }

    @Override
    public int removedUserInfoByUserInfoId(Long userInfoId) {
        return userInfoMapper.deleteUserInfoByUserInfoId(userInfoId);
    }

    @Override
    public int modifyUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateUserInfo(userInfo);
    }

    @Override
    public UserInfo findUserInfoByUserInfoId(Long userInfoId) {
        return userInfoMapper.selectUserInfoByUserInfoId(userInfoId);
    }

    @Override
    public List<UserInfo> findAllUserInfo() {
        return userInfoMapper.selectAllUserInfo();
    }

    @Override
    public List<UserInfo> findAllUserInfoByCondition(Map<String, Object> queryMap) {
        return userInfoMapper.selectAllUserInfoByCondition(queryMap);
    }
}
