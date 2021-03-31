package com.xingyun.springbootwitheasyshopsample.model.dto;

import com.xingyun.springbootwitheasyshopsample.model.UserInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author 技术宅星云
 * @功能
 * @date 9/22/2019 11:32 AM
 */
@Getter
@Setter
@ToString
@Component
public class UserDto {


    public UserDto(UserInfo userInfo){
        this.id= userInfo.getId();
        this.nickName= userInfo.getNickName();
        this.avatar= userInfo.getAvatar();
    }
    public UserDto(){}

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
