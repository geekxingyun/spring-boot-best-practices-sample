package com.xingyun.springbootwithmybatisxmlsample.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(value = "com.xingyun.springbootwithmybatisxmlsample.dao.mapper")
@Configuration
public class MyBatisConfig {
}
