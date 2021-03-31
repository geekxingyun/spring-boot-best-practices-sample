package com.xingyun.springbootwithspringdatajpasample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


/**
 * @功能 用户实体类
 * @author 技术宅星云
 * @date 9/28/2019 8:01 PM
 */
@Getter
@Setter
@ToString
@Table(name = "T_CUSTOMER")
@Entity
public class Customer {

    /**
     * -GenerationType.AUTO主键由程序控制, 是默认选项 ,不设置就是这个
     * -GenerationType.IDENTITY 主键由数据库生成, 采用数据库自增长, Oracle不支持这种方式
     * -GenerationType.SEQUENCE 通过数据库的序列产生主键,Oracle支持,MYSQL不支持
     * -GenerationType.TABLE 提供特定的数据库产生主键, 该方式更有利于数据库的移植
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * 姓
     */
    @Column(nullable = false)
    private String firstName;
    /**
     * 名
     */
    @Column(nullable = false)
    private String lastName;

    protected Customer() {}
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
