package com.xingyun.springbootwithmybatisannotationsample.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @MapperScan 开启这个注解,该包下的接口类可不写@Mapper注解
 */
@MapperScan(value = "com.xingyun.springbootwithmybatisannotationsample.dao.mapper")
@Configuration
public class MyBatisConfig {
}
