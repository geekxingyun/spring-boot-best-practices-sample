package com.xingyun.springbootwitheasyshopsample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Getter  注解生成Getter
 * @Setter  注解生成Setter
 * @ToString 注解生成ToString()
 * @Entity 该注解会对该类进行映射，必须有一个空的构造方法 JPA 通过空的构造方法实例化对象，并在数据库库中的值赋值给所构建的示例
 * @Table(name = "T_USER") 更改数据库表映射规则 自定义实体类映射到数据库具体哪张表上 默认User会映射为user,loginName会映射为login_name
 * @Column 更改字段映射规则,一般很少用到,默认映射规则满足不了才需要使用该注解自定义字段映射关系
 * @author 星云
 * @功能 用户表
 * @date 9/22/2019 9:32 AM
 */

@Getter
@Setter
@ToString
@Table(name = "T_USER")
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = -2587419559293211354L;

    /**
     * 用户数据库主键
     * @Id 用来注解数据库主键
     * @GeneratedValue 告诉JPA自动生成主键的值 默认情况下采取自动递增的方式
     * 也可以使用这种
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 用户昵称
     */
    @Column(name = "NIKE_NAME")
    private String nickName;
    /**
     * 用户头像
     */
    private String avatar;
}
