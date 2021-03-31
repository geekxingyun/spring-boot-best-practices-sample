package com.xingyun.springbootwithspringdatajpasample.config;

import com.xingyun.springbootwithspringdatajpasample.dao.jpa.CustomerRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author 技术宅星云
 * 这里一共有三种做法：
 * 方法一：
 * 在CustomerJpaRepository接口类上使用@Repository 注解,Spring Boot 会自动扫描这个注解并为其注入实现类
 * 缺点: 这种当项目中只有Spring Data JPA 的时候没有问题,但是如果Spring Data JPA 和Spring Data Redis 同时存在的时候会出现冲突问题。
 * 方法二：
 * 配置类中添加: @EnableJpaRepositories(basePackages = "com.xingyun.springbootwithspringdatajpasample.dao.jpa")
 * 缺点:这种方式需要手动写类的全名,如果文件夹移动,改动比较大，不推荐
 * 方法三:
 * 配置类中添加如下注解:
 * @EnableJpaRepositories(basePackageClasses = {
 *         CustomerRepository.class
 * }
 * )
 * 缺点:需要手动在这个类中进行配置
 * 优点:但是由于使用的是类的反射而不是扫描包方式,速度会相对来说快点,另外支持Spring Data JPA 和Spring Data Redis 同时存在时候也不会冲突。
 * @功能
 * @date 10/1/2019 5:45 PM
 */
@EnableJpaRepositories(basePackageClasses = {
        CustomerRepository.class
}
)
@Configuration
public class SpringDataJpaConfig{}