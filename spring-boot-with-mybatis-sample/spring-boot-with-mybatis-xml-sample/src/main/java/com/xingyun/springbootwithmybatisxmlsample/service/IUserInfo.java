package com.xingyun.springbootwithmybatisxmlsample.service;

import com.xingyun.springbootwithmybatisxmlsample.model.business.UserInfo;

import java.util.List;
import java.util.Map;

public interface IUserInfo {

    /**
     * 添加一个用户信息
     * @param userInfo
     * @return
     */
    int addUserInfo(UserInfo userInfo);

    /**
     * 删除一个用户信息
     * @param userInfoId
     * @return
     */
    int removedUserInfoByUserInfoId(Long userInfoId);

    /**
     * 修改一个用户信息
     * @param userInfo
     * @return
     */
    int modifyUserInfo(UserInfo userInfo);

    /**
     * 查找一个用户信息
     * @param userInfoId
     * @return
     */
    UserInfo findUserInfoByUserInfoId(Long userInfoId);

    /**
     * 查找所有用户信息
     * @return
     */
    List<UserInfo> findAllUserInfo();

    /**
     * 根据条件查询用户信息
     * @param queryMap
     * @return
     */
    List<UserInfo> findAllUserInfoByCondition(Map<String,Object> queryMap);
}
