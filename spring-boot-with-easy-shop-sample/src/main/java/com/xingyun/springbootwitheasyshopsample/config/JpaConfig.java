package com.xingyun.springbootwitheasyshopsample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author 星云
 * @功能
 * @date 9/23/2019 8:43 PM
 */
@EnableJpaRepositories(basePackages = "com.xingyun.springbootwitheasyshopsample.dao.repository")
@Configuration
public class JpaConfig {
}
