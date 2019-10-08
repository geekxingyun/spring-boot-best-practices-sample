package com.xingyun.springbootwithspringdatajpasample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


/**
 * @功能 用户实体类
 * @author 星云
 * @date 9/28/2019 8:01 PM
 */
@Getter
@Setter
@ToString
@Table(name = "T_CUSTOMER")
@Entity
public class Customer {

    /**
     * 主键Id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
