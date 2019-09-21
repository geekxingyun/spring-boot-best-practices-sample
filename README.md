# 0x01 前言

> 大家好,我是该仓库的维护者星云,该仓库致力于提供Spring Boot 与各种技术的整合示例库源码,欢迎各位持续关注~

# 0x02 Spring Boot 与各种技术整合示例库列表

> - 推荐安装Github 源码浏览插件 [Octotree](https://www.octotree.io/)
> - 该系列源码讲解推荐看我的博客专栏[Spring Boot 2.x 最佳实践手册](https://xingyun.blog.csdn.net/article/category/9284593)

|项目名称|博文讲解|
|---|---|
|[spring-boot-with-customize-banner-sample](https://github.com/geekxingyun/SpringBootBestPracticesSample/tree/master/spring-boot-with-customize-banner-sample)|[1.Spring Boot 2.x最佳实践之自定义Banner](https://blog.csdn.net/hadues/article/details/88819151)|
|[spring-boot-with-slf4j-logback-sample](https://github.com/geekxingyun/SpringBootBestPracticesSample/tree/master/spring-boot-with-slf4j-logback-sample)|[2. Spring Boot 2.x 最佳实践之日志使用SLF4J+Logback](https://blog.csdn.net/hadues/article/details/88884141)|
|[spring-boot-with-configuration-processor-sample](https://github.com/geekxingyun/SpringBootBestPracticesSample/tree/master/spring-boot-with-configuration-processor-sample)|[3. Spring Boot 2.x 最佳实践之自定义属性](https://xingyun.blog.csdn.net/article/details/89408533)|
|[spring-boot-with-web-sample](https://github.com/geekxingyun/SpringBootBestPracticesSample/tree/master/spring-boot-with-web-sample)|[4. Spring Boot 2.x 最佳实践之 Web 模块集成](https://xingyun.blog.csdn.net/article/details/89413333)|
|[spring-boot-with-thymeleaf-sample](https://github.com/geekxingyun/SpringBootBestPracticesSample/tree/master/spring-boot-with-thymeleaf-sample)|[5. Spring Boot 2.x 最佳实践之Thymeleaf集成](https://xingyun.blog.csdn.net/article/details/89422513)|
|[spring-boot-with-jsp-sample](https://github.com/geekxingyun/SpringBootBestPracticesSample/tree/master/spring-boot-with-jsp-sample)|[6.Spring Boot 2.x 最佳实践之JSP集成](https://xingyun.blog.csdn.net/article/details/89413877)|
|[spring-boot-with-swagger-sample](https://github.com/geekxingyun/SpringBootBestPracticesSample/tree/master/spring-boot-with-swagger-sample)|[7. Spring Boot 2.x 最佳实践之Swagger集成](https://xingyun.blog.csdn.net/article/details/89420502)|
|[spring-boot-with-spring-kafka-sample](https://github.com/geekxingyun/SpringBootBestPracticesSample/tree/master/spring-boot-with-spring-kafka-sample)|[8. Spring Boot 2.x最佳实践之Spring for Apache Kafka集成](https://blog.csdn.net/hadues/article/details/88974967)|
|- |[9. Spring Boot 2.x 最佳实践之静态资源拦截](https://xingyun.blog.csdn.net/article/details/92772523)|
|[spring-boot-with-mybatis-sample](https://github.com/geekxingyun/SpringBootBestPracticesSample/tree/master/spring-boot-with-mybatis-sample)|[10. Spring Boot 2.x 最佳实践之MyBatis集成](https://xingyun.blog.csdn.net/article/details/97929511)

---
# 0x03 如何构建一个Spring Boot 项目

> 构建一个Spring Boot 项目最流行的有如下三种方式.

## 3.1 使用 Intellij Idea 构建项目

> [Intellij Idea](https://www.jetbrains.com/idea/) 是一款Java开发最强大最智能的IDE集成开发工具。

## 3.2 使用Spring Tools 4 for Eclipse(简称 STS)构建项目

> - Spring Tools 4 for Eclipse 是Spring 官方团队推出的Java开发集成IDE工具。

> - 对Spring完美支持,开源免费且支持start.spring.io网址构建项目

> - [Spring Tools 4 for Eclipse](https://spring.io/tools3/sts/all) 新版本,该版本不支持部署war到tomcat,Jetty 等外部容器中

> - [Spring Tools 3 for Eclipse](https://spring.io/tools3/sts/all) 旧版本,该版本支持部署war到tomcat,Jetty 等外部容器中


## 3.3 start.spring.io 在线构建项目

> 初始化一个Spring Boot 项目,推荐使用Spring 官方团队提供的项目生成工具 [https://start.spring.io/](https://start.spring.io/)

# 0x04 如何安装打包运行一个Spring Boot 项目?

推荐使用我精心配制的[settings.xml](https://github.com/geekxingyun/SpringBootBestPracticesSample/blob/master/resources/share/settings.xml)

## 4.1 maven 安装依赖

pom.xml 根目录下运行
```
mvn clean install
```
## 4.2 maven 打包

pom.xml根目录下执行
```
mvn clean package
```
> 命令含义:首先清理target文件夹中所有内容,然后打包成*.jar或者*.war输出到target根目录

### 4.3 maven 运行

pom.xml根目录下执行
```
java -jar your-app.jar
```
> 命令含义: 运行一个*.jar
 
 ### 4.4 jar剖析
 
 解压该jar文件可以看到
 
> - BOOT-INF\classes 存放编译后的所有Java源码
> - BOOT-INF\lib 项目依赖的Jar包
> - org\springframework\boot\loader Spring Boot 启动时需要的类

---
# 关于我

> 交流即分享，分享才能进步！ by 星云


[星云CSDN博客](https://blog.csdn.net/hadues)

[星云GitHub](https://github.com/geekxingyun)

[星云微博](https://weibo.com/xingyunsky)

# 关注与赞赏

<div align="center">
 <a href="https://github.com/geekxingyun/SpringBootBestPracticesSample/blob/master/resources/images/follow-me-and-award-me.png">
 <img src="https://github.com/geekxingyun/SpringBootBestPracticesSample/blob/master/resources/images/follow-me-and-award-me.png">
 </img>
  </a>
</div>

# 联系我

Email: fairy_xingyun@hotmail.com
