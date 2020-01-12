# 0x01 前言

> 该仓库致力于提供Spring Boot 与各种技术的整合示例库源码,欢迎各位持续关注~

> - 推荐安装Github 源码浏览插件 [Octotree](https://www.octotree.io/)

> - 该系列源码视频教程后期我会放到我的微信公众号

# 0x02 Spring Boot 最佳实践专栏简介

> Spring Boot 无疑如今已经成为Java 后端开发的行业标准，学会Spring Boot
与各种技术集成是必学技能，该专栏是博主根据实战摸索出来的Spring Boot 2.x
与各种技术集成经验分享，后期会配上视频讲解，敬请期待。

> - 博客专栏首页 [Spring Boot 2.x 最佳实践手册](https://xingyun.blog.csdn.net/article/category/9284593)

| Spring Boot 与各种技术整合示例库列表|
|--|
| [1.Spring Boot 2.x 最佳实践之入门](https://xingyun.blog.csdn.net/article/details/101110483)|
| [2.Spring Boot 2.x 最佳实践之自定义Banner](https://xingyun.blog.csdn.net/article/details/88819151) |  
| [3.Spring Boot 2.x 最佳实践之自定义Properties](https://xingyun.blog.csdn.net/article/details/89408533)|
|[4. Spring Boot 2.x 最佳实践之lombok集成](https://xingyun.blog.csdn.net/article/details/100763122)|
|[5. Spring Boot 2.x 最佳实践之Logback集成](https://xingyun.blog.csdn.net/article/details/88884141)|
|[6. Spring Boot 2.x 最佳实践之 Apache Log4j2 集成](https://xingyun.blog.csdn.net/article/details/100856124)|
|[7. Spring Boot 2.x 最佳实践之 Spring Web MVC 集成](https://xingyun.blog.csdn.net/article/details/89413333)|
|[8. Spring Boot 2.x 最佳实践之静态资源处理](https://xingyun.blog.csdn.net/article/details/92772523)|
|[9. Spring Boot 2.x 最佳实践之Thymeleaf集成](https://xingyun.blog.csdn.net/article/details/89422513)|
|[10.Spring Boot 2.x 最佳实践之JSP集成](https://xingyun.blog.csdn.net/article/details/89413877)|
|[11. Spring Boot 2.x 最佳实践之Swagger集成](https://xingyun.blog.csdn.net/article/details/89420502)|
|[12. Spring Boot 2.x 最佳实践之MyBatis集成](https://xingyun.blog.csdn.net/article/details/97929511)|
|[13. Spring Boot 2.x 最佳实践之Spring for Apache Kafka集成](https://xingyun.blog.csdn.net/article/details/88974967)|
|[14. Spring Boot 2.x 最佳实践之 Spring Data JPA集成](https://xingyun.blog.csdn.net/article/details/101632155)|
|[15. Spring Boot 2.x 最佳实践之 TinyMCE 集成](https://xingyun.blog.csdn.net/article/details/102492921)| 
|[16. Spring Boot 2.x 最佳实践之 Quartz 集成](https://xingyun.blog.csdn.net/article/details/103067196)|
|[17. Spring Boot 2.x 最佳实践之 Spring Security 集成](https://xingyun.blog.csdn.net/article/details/100038318)|
|[18.Spring Boot 2.x 最佳实践之 Java Mail Sender集成](https://xingyun.blog.csdn.net/article/details/103074053)|
|[19. Spring Boot 2.x 最佳实践之 BootStrap V4集成](https://xingyun.blog.csdn.net/article/details/103735434)|
|[20. Spring Boot 2.x 最佳实践之Sonar 集成](https://xingyun.blog.csdn.net/article/details/103754754)|
|[21. Spring Boot 2.x最佳实践之 HTTPS 集成](https://xingyun.blog.csdn.net/article/details/103607879)|

未完待续，持续更新中。。。

---
> - 交流即分享，分享才能进步。
---
# 0x03 如何构建一个Spring Boot 项目

> 构建一个Spring Boot 项目最流行的有如下三种方式.

## 3.1 使用 Intellij Idea 构建项目

> [Intellij Idea](https://www.jetbrains.com/idea/) 是一款Java开发最强大最智能的IDE集成开发工具。

## 3.2 使用Spring Tools 4 for Eclipse(简称 STS)构建项目

> - Spring Tools 4 for Eclipse 是Spring 官方团队推出的Java开发集成IDE工具。

> - 对Spring完美支持,开源免费且支持start.spring.io网址构建项目

> - [Spring Tools 4 for Eclipse](https://spring.io/tools) 新版本,该版本不支持部署war到tomcat,Jetty 等外部容器中

> - [Spring Tools 3 for Eclipse](https://spring.io/tools3/sts/all) 旧版本,该版本支持部署war到tomcat,Jetty 等外部容器中


## 3.3 start.spring.io 在线构建项目

> 初始化一个Spring Boot 项目,可以使用Spring 官方团队提供的项目生成工具 [https://start.spring.io/](https://start.spring.io/)

# 0x04 如何安装打包运行一个Spring Boot 项目?

推荐使用我精心配制的[settings.xml](https://github.com/geekxingyun/SpringBootBestPracticesSample/blob/master/assets/share/settings.xml)

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

网络ID 星云,英文名fairy,真名赵庆峰,CSDN 博客专家,致力于后端技术分享，喜欢开源和交流技术。

Email: fairy_xingyun@hotmail.com

> 交流即分享，分享才能进步！ by 星云

# 关注与打赏

[星云CSDN博客](https://blog.csdn.net/hadues)

[星云GitHub](https://github.com/geekxingyun)

[星云微博](https://weibo.com/xingyunsky)

<div align="center"><img src="https://img-blog.csdnimg.cn/20191101135202539.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly94aW5neXVuLmJsb2cuY3Nkbi5uZXQ=,size_16,color_FFFFFF,t_70"/></div>
