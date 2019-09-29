package com.xingyun.springbootwitheasyshopsample.model.dto;

import com.xingyun.springbootwitheasyshopsample.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author 星云
 * @功能
 * @date 9/22/2019 11:32 AM
 */
@Getter
@Setter
@ToString
@Component
public class UserDto {


    public UserDto(User user){
        this.id=user.getId();
        this.nickName=user.getNickName();
        this.avatar=user.getAvatar();
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
