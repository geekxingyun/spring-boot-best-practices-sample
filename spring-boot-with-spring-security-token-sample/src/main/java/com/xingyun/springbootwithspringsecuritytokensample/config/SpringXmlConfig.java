package com.xingyun.springbootwithspringsecuritytokensample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 引入外部的XML
 * @author qing-feng.zhao
 */
@ImportResource(locations = {
        "classpath:spring-config/spring-interceptor-config.xml",
        "classpath:spring-config/spring-other-config.xml",
})
@Configuration
public class SpringXmlConfig {
}
