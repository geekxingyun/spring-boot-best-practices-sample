package com.xingyun.springbootwithmybatisxmlsample.config;

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
 * @author 星云
 * @description
 * @date 2019/5/11 19:59
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig{

    @Autowired
    ServerProperties serverProperties;

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("http://");
        stringBuffer.append(serverProperties.getAddress());
        stringBuffer.append(":");
        stringBuffer.append(serverProperties.getPort());
        stringBuffer.append("/");
        stringBuffer.append(serverProperties.getServlet().getContextPath());

        return new ApiInfoBuilder()
                .title("Mybatis Spring Boot Starter Restful API")
                .description("Mybatis Spring Boot Starter restful api")
                .termsOfServiceUrl(stringBuffer.toString())
                .contact(new Contact("星云", "https://xingyun.blog.csdn.net/", "fairy_xingyun@hotmail.com"))
                .version("1.0")
                .build();
    }

    /**
     * API分组一
     **/
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("RestFulAPIGroup")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xingyun.springbootwithmybatisxmlsample.controller.api"))
                .paths(PathSelectors.any())
                .build();
    }
}
