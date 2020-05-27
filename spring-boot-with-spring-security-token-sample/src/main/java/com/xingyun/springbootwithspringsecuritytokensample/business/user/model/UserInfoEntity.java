package com.xingyun.springbootwithspringsecuritytokensample.business.user.model;

import javax.persistence.*;

/**
 * @author qing-feng.zhao
 */
@Table(name = "t_user_info")
@Entity
public class UserInfoEntity {
    /**
     * 主键
     * -GenerationType.AUTO主键由程序控制, 是默认选项 ,不设置就是这个
     * -GenerationType.IDENTITY 主键由数据库生成, 采用数据库自增长, Oracle不支持这种方式
     * -GenerationType.SEQUENCE 通过数据库的序列产生主键,Oracle支持,MYSQL不支持
     * -GenerationType.TABLE 提供特定的数据库产生主键, 该方式更有利于数据库的移植
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "uuid",length = 64)
    private Long uuid;

    @Column(name = "user_info_account")
    private String userInfoAccount;

    @Column(name = "user_info_password")
    private String userInfoPassword;

    @Column(name = "user_info_token")
    private String userInfoToken;
}
