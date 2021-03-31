package com.xingyun.springbootwithbootstrapv4sample.config;

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
 * @date 2019/12/27 18:58
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger Test App Restful API")
                .description("swagger test app restful api")
                .termsOfServiceUrl("https://www.521geek.com")
                .contact(new Contact("技术宅星云","https://xingyun.blog.csdn.net/column/info/33374","fairy_xingyun@hotmail.com"))
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
                .apis(RequestHandlerSelectors.basePackage("com.xingyun.springbootwithbootstrapv4sample.controller.api"))
                .paths(PathSelectors.any())
                .build();
    }
}
