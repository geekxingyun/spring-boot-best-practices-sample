package com.xingyun.springbootwithmybatisannotationsample.dao.mapper;

import com.xingyun.springbootwithmybatisannotationsample.model.business.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserInfoMapper {

    @Insert(value = "INSERT INTO t_user_info (USER_INFO_ACCOUNT,USER_INFO_PASSWORD,USER_INFO_AGE,USER_INFO_SEX)VALUES(#{userInfoAccount},#{userInfoPassword},#{userInfoAge},#{userInfoSex})")
    int insertUserInfo(UserInfo userInfo);

    @Delete(value = "DELETE FROM t_user_info WHERE USER_INFO_ID= #{userInfoId}")
    int deleteUserInfoByUserInfoId(@Param("userInfoId")Long userInfoId);

    //注解中动态SQL用法示例
    @Update(value = "<script>        UPDATE t_user_info\n" +
            "        <set>\n" +
            "            <if test=\"userInfoAccount!=null\">\n" +
            "                USER_INFO_ACCOUNT= #{userInfoAccount},\n" +
            "            </if>\n" +
            "            <if test=\"userInfoPassword!=null\">\n" +
            "                USER_INFO_PASSWORD= #{userInfoPassword},\n" +
            "            </if>\n" +
            "            <if test=\"userInfoAge!=null\">\n" +
            "                USER_INFO_AGE= #{userInfoAge},\n" +
            "            </if>\n" +
            "            <if test=\"userInfoSex!=null\">\n" +
            "                USER_INFO_SEX= #{userInfoSex},\n" +
            "            </if>\n" +
            "        </set>\n" +
            "        WHERE USER_INFO_ID= #{userInfoId}</script>")
    int updateUserInfo(UserInfo userInfo);

    @Select(value = "SELECT * FROM t_user_info WHERE USER_INFO_ID=#{userInfoId}")
    @Results({
            @Result(property = "userInfoId", column = "USER_INFO_ID", javaType = Long.class),
            @Result(property = "userInfoAccount", column = "USER_INFO_ACCOUNT", javaType = String.class),
            @Result(property = "userInfoPassword", column = "USER_INFO_PASSWORD", javaType = String.class),
            @Result(property = "userInfoAge", column = "USER_INFO_AGE", javaType = Integer.class),
            @Result(property = "userInfoSex", column = "USER_INFO_SEX", javaType = Boolean.class),
    })
    UserInfo selectUserInfoByUserInfoId(@Param("userInfoId")Long userInfoId);

    @Select(value = "SELECT USER_INFO_ID,USER_INFO_ACCOUNT,USER_INFO_PASSWORD,USER_INFO_AGE,USER_INFO_SEX FROM t_user_info")
    @Results({
            @Result(property = "userInfoId", column = "USER_INFO_ID", javaType = Long.class),
            @Result(property = "userInfoAccount", column = "USER_INFO_ACCOUNT", javaType = String.class),
            @Result(property = "userInfoPassword", column = "USER_INFO_PASSWORD", javaType = String.class),
            @Result(property = "userInfoAge", column = "USER_INFO_AGE", javaType = Integer.class),
            @Result(property = "userInfoSex", column = "USER_INFO_SEX", javaType = Boolean.class),
    })
    List<UserInfo> selectAllUserInfo();

    @Select(value = "<script>  SELECT\n" +
            "        USER_INFO_ID,USER_INFO_ACCOUNT,USER_INFO_PASSWORD,USER_INFO_AGE,USER_INFO_SEX\n" +
            "        FROM t_user_info\n" +
            "        <where>\n" +
            "            <if test=\"userInfoAccount!=null and ''!=userInfoAccount\">\n" +
            "                AND USER_INFO_ACCOUNT = #{userInfoAccount}\n" +
            "            </if>\n" +
            "            <if test=\"null!=userInfoPassword and ''!=userInfoPassword \">\n" +
            "                AND USER_INFO_PASSWORD= #{userInfoPassword}\n" +
            "            </if>\n" +
            "            <if test=\"null!=userInfoAge and 0!=userInfoAge \">\n" +
            "                AND USER_INFO_AGE= #{userInfoAge}\n" +
            "            </if>\n" +
            "            <if test=\"null!=userInfoSex \">\n" +
            "                AND USER_INFO_SEX= #{userInfoSex}\n" +
            "            </if>\n" +
            "            <if test=\"null!=userInfoId and 0L!=userInfoId \">\n" +
            "                AND USER_INFO_ID= #{userInfoId}\n" +
            "            </if>\n" +
            "        </where></script>")
    @Results({
            @Result(property = "userInfoId", column = "USER_INFO_ID", javaType = Long.class),
            @Result(property = "userInfoAccount", column = "USER_INFO_ACCOUNT", javaType = String.class),
            @Result(property = "userInfoPassword", column = "USER_INFO_PASSWORD", javaType = String.class),
            @Result(property = "userInfoAge", column = "USER_INFO_AGE", javaType = Integer.class),
            @Result(property = "userInfoSex", column = "USER_INFO_SEX", javaType = Boolean.class),
    })
    List<UserInfo> selectAllUserInfoByCondition(Map<String,Object> queryMap);
}
