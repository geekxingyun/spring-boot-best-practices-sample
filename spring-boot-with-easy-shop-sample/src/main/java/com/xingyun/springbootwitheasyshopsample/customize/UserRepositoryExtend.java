package com.xingyun.springbootwitheasyshopsample.customize;

import com.xingyun.springbootwitheasyshopsample.model.UserInfo;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * @author 星云
 * @功能 Spring Data JPA 自定义扩展接口
 * @date 9/22/2019 11:17 AM
 */
@NoRepositoryBean
public interface UserRepositoryExtend {
    /**
     * 获取最
     * @param maxResult
     * @return
     */
    List<UserInfo> findTopUser(int maxResult);
}
