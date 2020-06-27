package com.xingyun.springbootwithspringdatajpasample.config;

import com.xingyun.springbootwithspringdatajpasample.dao.jpa.CustomerRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author 星云
 * @EnableJpaRepositories(basePackages = "com.xingyun.springbootwithspringdatajpasample.dao.jpa")
 * @功能
 * @date 10/1/2019 5:45 PM
 */
@EnableJpaRepositories(basePackageClasses = CustomerRepository.class)
@Configuration
public class SpringDataJpaConfig {}