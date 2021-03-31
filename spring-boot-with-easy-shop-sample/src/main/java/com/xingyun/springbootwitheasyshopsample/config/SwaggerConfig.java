package com.xingyun.springbootwitheasyshopsample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
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
 * @author 技术宅星云
 * @功能
 * @date 9/23/2019 9:20 PM
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Autowired
    ServerProperties serverProperties;

    /**
     * 构建 api文档的详细信息函数
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Easy Shop App Restful API")
                .description("Easy Shop app restful api")
                .contact(new Contact("技术宅星云","https://xingyun.blog.csdn.net/","fairy_xingyun@hotmail.com"))
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
                .apis(RequestHandlerSelectors.basePackage("com.xingyun.springbootwitheasyshopsample.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
