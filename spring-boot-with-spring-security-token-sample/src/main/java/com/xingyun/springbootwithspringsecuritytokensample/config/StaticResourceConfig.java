package com.xingyun.springbootwithspringsecuritytokensample.config;

import com.xingyun.springbootwithspringsecuritytokensample.interceptor.MyTokenAuthorityInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author qing-feng.zhao
 * @description 静态资源处理
 * @date 2019/11/23 10:06
 */
@Component
@Configuration
public class StaticResourceConfig extends WebMvcConfigurationSupport {
    /**
     * 添加自定义拦截器
     */
    private final MyTokenAuthorityInterceptor myTokenAuthorityInterceptor;
    public StaticResourceConfig(MyTokenAuthorityInterceptor myTokenAuthorityInterceptor) {
        this.myTokenAuthorityInterceptor = myTokenAuthorityInterceptor;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myTokenAuthorityInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-ui.html/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/v2/**")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/actuator/**")
                .excludePathPatterns("/csrf/**")
                .excludePathPatterns("/home-page.do")
                .excludePathPatterns("/toLoginPage.do")
                .excludePathPatterns("/read-api-page.do")
                .excludePathPatterns("/csrf/**")
                .excludePathPatterns("/")
                .order(1);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //自定义框架资源处理
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //Swagger 静态资源处理
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/csrf/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
