package com.xingyun.springbootwithspringsecuritysample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/11/23 10:11
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {

    /**
     * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("App Restful API")
                .description("App restful api")
                .termsOfServiceUrl("https://xingyun.blog.csdn.net")
                .contact(new Contact("星云","https://xingyun.blog.csdn.net/","fairy_xingyun@hotmail.com"))
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("ApiOneGroupAPI")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xingyun.springbootwithspringsecuritysample.controller.api"))
                .paths(PathSelectors.any())
                .build();
    }
}
