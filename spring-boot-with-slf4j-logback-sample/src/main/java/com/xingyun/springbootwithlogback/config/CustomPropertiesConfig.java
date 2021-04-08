package com.xingyun.springbootwithlogback.config;

import com.xingyun.springbootwithlogback.customized.LogbackThreadLoggingProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @EnableConfigurationProperties 激活自定义属性扫描文件,多个自定义配置文件以逗号隔开配置
 * @Configuration 注解表明是一个Spring 配置类
 * @author qing-feng.zhao
 * */
@EnableConfigurationProperties({
        LogbackThreadLoggingProperties.class
})
@Configuration
public class CustomPropertiesConfig {
}
