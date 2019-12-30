package com.xingyun.springbootwithhttpssample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author qing-feng.zhao
 * @description 静态资源处理
 * @date 2019/11/23 10:06
 */
@Configuration
public class StaticResourceConfig extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //默认静态资源处理
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/public/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/resources/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/");
        //自定义框架资源处理
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static");
    }
}
