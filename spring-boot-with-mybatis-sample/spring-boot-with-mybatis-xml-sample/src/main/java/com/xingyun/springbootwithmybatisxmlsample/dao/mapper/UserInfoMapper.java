package com.xingyun.springbootwithmybatisxmlsample.dao.mapper;

import com.xingyun.springbootwithmybatisxmlsample.model.business.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserInfoMapper {

    int insertUserInfo(UserInfo userInfo);

    int deleteUserInfoByUserInfoId(Long userInfoId);

    int updateUserInfo(UserInfo userInfo);

    UserInfo selectUserInfoByUserInfoId(Long userInfoId);

    List<UserInfo> selectAllUserInfo();

    List<UserInfo> selectAllUserInfoByCondition(Map<String,Object> queryMap);
}