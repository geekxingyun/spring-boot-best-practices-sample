package com.xingyun.springbootwitheasyshopsample.model.dto;

import com.xingyun.springbootwitheasyshopsample.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 星云
 * @功能
 * @date 9/22/2019 11:32 AM
 */
@Getter
@Setter
@ToString
public class UserDto {

    public UserDto(User user){

    }
    public UserDto(){}

    /**
     * 用户数据库主键
     * @Id 用来注解数据库主键
     * @GeneratedValue 告诉JPA自动生成主键的值 默认情况下采取自动递增的方式
     * 也可以使用这种
     */
    private Long id;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户头像
     */
    private String avatar;
}
