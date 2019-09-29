package com.xingyun.springbootwitheasyshopsample.service.user;

import com.xingyun.springbootwitheasyshopsample.model.User;
import com.xingyun.springbootwitheasyshopsample.model.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author 星云
 * @功能
 * @date 9/22/2019 11:26 AM
 */
public interface UserService {
    /**
     * 获取用户分页数据
     * @param pageable 分页参数
     * @return 分页数据
     */
    Page<User> getPage(Pageable pageable);

    List<User> showAllUser();

    /**
     * 加载指定的用户信息
     * @param id 用户主键
     * @return 指定的用户信息
     */
    User load(Long id);

    /**
     * 一般使用DTO 作为前后端分离的数据传输
     * 保存/更新用户
     * @param user UserDto,Data Transfer Object,数据传输对象，简称DTO 只包含数据属性不包含业务逻辑
     * @return
     */
    User save(UserDto user);

    /**
     * 删除指定的用户
     * @param id 所要删除的用户主键
     */
    void delete(Long id);

}
