package com.xingyun.springbootwithswaggersample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 官网: https://swagger.io/
 * **/
@EnableSwagger2
@Configuration
public class SwaggerConfig  extends WebMvcConfigurationSupport {

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger Test App Restful API")
                .description("swagger test app restful api")
                .termsOfServiceUrl("http://127.0.0.1:8080")
                .contact(new Contact("星云","https://xingyun.blog.csdn.net/column/info/33374","fairy_xingyun@hotmail.com"))
                .version("1.0")
                .build();
    }

    /**
     * API分组一
     * **/
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("SwaggerGroupOneAPI")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xingyun"))
                .paths(PathSelectors.any())
                .build();
    }

//    /**
//     * API分组二
//     * **/
//    @Bean
//    public Docket createHomeInfoGroup2RestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .groupName("SwaggerGroupTwoAPI")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.xingyun"))
//                .paths(PathSelectors.any())
//                .build();
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //Swagger 静态资源处理
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
