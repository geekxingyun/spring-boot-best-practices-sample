package com.xingyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 需要一个应用引导类,引导类的作用是让Spring Boot 框架启动并初始化应用.
 * @SpringBootApplication 该注解告诉Spring 容器,使用该类作为所有Bean源，通过该起点构建应用上下文
 * @SpringBootApplication 继承自 @ComponentScan 和 @EnableAutoConfiguration
 * 系统启动后会对该类所属目录下的包进行扫描并根据Spring Boot 的自动配置机制进行配置
 * 因此该类必须放在项目的根包中,否则可能部分配置可能不会被扫描到.
 * 如果特殊情况不能放到根包,可以使用@ComponentScan显示指定包名,配置扫描包的位置如:@ComponentScan("com.xingyun.**")
 * 多个包名可以使用@ComponentScan("com.xingyun.**,com.swallow.**")
 * @author qing-feng.zhao
 */
@SpringBootApplication
public class SpringBootWithCustomizeBannerSampleApplication {

	public static void main(String[] args) {
		//SpringApplication.run方法会构建一个Spring容器,并且返回一个ApplicationContext对象,也就是项目的上下文
		SpringApplication.run(SpringBootWithCustomizeBannerSampleApplication.class, args);

	}
}
