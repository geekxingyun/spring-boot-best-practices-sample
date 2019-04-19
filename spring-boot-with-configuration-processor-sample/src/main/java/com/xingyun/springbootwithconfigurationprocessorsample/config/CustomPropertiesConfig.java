package com.xingyun.springbootwithconfigurationprocessorsample.config;

import com.xingyun.springbootwithconfigurationprocessorsample.properties.MyCustomProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 激活自定义属性扫描文件
 * 多个自定义配置文件以逗号隔开配置
 * */
@EnableConfigurationProperties({
        MyCustomProperties.class
})
/**
 * 注解表明是一个Spring 配置类
 * */
@Configuration
public class CustomPropertiesConfig {
}
