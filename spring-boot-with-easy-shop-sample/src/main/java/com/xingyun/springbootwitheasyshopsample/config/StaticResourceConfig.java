package com.xingyun.springbootwitheasyshopsample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author 技术宅星云
 * @功能
 * @date 9/23/2019 9:25 PM
 */
@Configuration
public class StaticResourceConfig extends WebMvcConfigurationSupport{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //默认静态资源处理
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //Swagger 静态资源处理
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/csrf/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
