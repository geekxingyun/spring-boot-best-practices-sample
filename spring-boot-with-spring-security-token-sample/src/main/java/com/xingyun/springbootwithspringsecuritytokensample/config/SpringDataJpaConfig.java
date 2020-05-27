package com.xingyun.springbootwithspringsecuritytokensample.config;

import com.xingyun.springbootwithspringsecuritytokensample.business.user.dao.jpa.UserInfoJpaRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author qing-feng.zhao
 */
@EnableJpaRepositories(basePackageClasses = {
        UserInfoJpaRepository.class
})
@Configuration
public class SpringDataJpaConfig {
}
