package com.xingyun.springbootwithmybatisannotationsample.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 默认情况下，MyBatis-Spring-Boot-Starter将搜索并处理标有@Mapper注释的接口类
 * @MapperScan 如果开启这个注解,该包下的接口类可不写@Mapper注解
 */
@MapperScan(value = "com.xingyun.springbootwithmybatisannotationsample.dao.mapper")
@Configuration
public class MyBatisConfig {}