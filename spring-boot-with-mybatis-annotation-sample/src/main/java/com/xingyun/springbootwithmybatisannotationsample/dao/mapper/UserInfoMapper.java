package com.xingyun.springbootwithmybatisannotationsample.dao.mapper;

import com.xingyun.springbootwithmybatisannotationsample.model.business.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Insert(value = "INSERT INTO t_user_info (USER_INFO_NAME,USER_INFO_MOBILE,USER_INFO_AGE,USER_INFO_SEX)VALUES(#{userInfoName},#{userInfoMobile},#{userInfoAge},#{userInfoSex})")
    int insertUserInfo(UserInfo userInfo);

    @Delete(value = "DELETE FROM t_user_info WHERE USER_INFO_ID= #{userInfoId}")
    int deleteUserInfoByUserInfoId(@Param("userInfoId")Long userInfoId);

    @Update(value = "UPDATE t_user_info SET USER_INFO_NAME= #{userInfoName},USER_INFO_MOBILE= #{userInfoMobile},USER_INFO_AGE= #{userInfoAge},USER_INFO_SEX= #{userInfoSex} WHERE USER_INFO_ID= #{userInfoId}")
    int updateUserInfo(UserInfo userInfo);

    @Select(value = "SELECT * FROM t_user_info WHERE USER_INFO_ID=#{userInfoId}")
    @Results({
            @Result(property = "userInfoId", column = "USER_INFO_ID", javaType = Long.class),
            @Result(property = "userInfoName", column = "USER_INFO_NAME", javaType = String.class),
            @Result(property = "userInfoMobile", column = "USER_INFO_MOBILE", javaType = String.class),
            @Result(property = "userInfoAge", column = "USER_INFO_AGE", javaType = Integer.class),
            @Result(property = "userInfoSex", column = "USER_INFO_SEX", javaType = Boolean.class),
    })
    UserInfo selectUserInfoByUserInfoId(@Param("userInfoId")Long userInfoId);

    @Select(value = "SELECT * FROM t_user_info")
    @Results({
            @Result(property = "userInfoId", column = "USER_INFO_ID", javaType = Long.class),
            @Result(property = "userInfoName", column = "USER_INFO_NAME", javaType = String.class),
            @Result(property = "userInfoMobile", column = "USER_INFO_MOBILE", javaType = String.class),
            @Result(property = "userInfoAge", column = "USER_INFO_AGE", javaType = Integer.class),
            @Result(property = "userInfoSex", column = "USER_INFO_SEX", javaType = Boolean.class),
    })
    List<UserInfo> selectAllUserInfo();
}
