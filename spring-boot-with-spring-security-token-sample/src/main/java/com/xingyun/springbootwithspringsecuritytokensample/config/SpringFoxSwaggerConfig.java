package com.xingyun.springbootwithspringsecuritytokensample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* @Profile 注解表示只在dev和test环境生效,uat 环境不生效
* @author qing-feng.zhao
* @description
* @date 2020/2/5 9:31
*/
@EnableSwagger2
@Configuration
public class SpringFoxSwaggerConfig {

   @Bean
   public ApiInfo apiInfo() {
       return new ApiInfoBuilder()
               .title("当前系统API")
               .description("当前系统API")
               .termsOfServiceUrl("http://www.521geek.com")
               .contact(new Contact("技术宅星云","https://xingyun.blog.csdn.net","fairy_xingyun@hotmail.com"))
               .version("1.0")
               .build();
   }

   @Bean
   public Docket createRestApi(ApiInfo apiInfo) {
       return new Docket(DocumentationType.SWAGGER_2)
               .apiInfo(apiInfo)
               .groupName("SwaggerGroupOneAPI")
               .select()
               .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
               .paths(PathSelectors.any())
               .build();
   }
}
