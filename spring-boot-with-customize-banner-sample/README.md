# Spring Boot with Customize Banner Sample

## 0x01 前言

>- 我是星云,该仓库致力于提供Spring Boot 与各种技术的整合的示例库。
>- 当前源码讲解Spring Boot 自定义Banner 部分的内容.

## 0x02 如何构建一个Spring Boot 项目
> 构建一个Spring Boot 项目最流行的有如下三种方式.
### 2.1.1 使用 Intellij Idea 构建项目
[Intellij Idea](https://www.jetbrains.com/idea/) 是一款Java开发最强大最智能的IDE集成开发工具。
#### 2.1.2 start.spring.io 在线构建项目
初始化一个Spring Boot 项目,推荐使用Spring 官方团队提供的项目生成工具
> [https://start.spring.io/](https://start.spring.io/)
### 2.1.3 使用Spring Tools 4 for Eclipse(简称 STS)构建项目

Spring Tools 4 for Eclipse 是Spring 官方团队推出的Java开发集成IDE工具。

对Spring完美支持,开源免费且支持start.spring.io网址构建项目

## 0x03 运行方法

### 3.1 maven 打包

pom.xml根目录下执行
```
mvn clean package
```
> 命令含义:首先清理target文件夹中所有内容,然后打包成*.jar或者*.war输出到target根目录

### 3.2 maven 运行

pom.xml根目录下执行
```
java -jar spring-boot-with-customize-banner-sample-0.0.1-SNAPSHOT.jar
```
> 命令含义: 运行一个*.jar
 
 ### 3.3 jar剖析
 
 解压该jar文件可以看到
 
> - BOOT-INF\classes 存放编译后的所有Java源码
> - BOOT-INF\lib 项目依赖的Jar包
> - org\springframework\boot\loader Spring Boot 启动时需要的类
 
## 0x04 源码讲解

关于当前项目的源码讲解请移步参考我的CSDN博文

[1. Spring Boot 2.x With Custom Banner](https://xingyun.blog.csdn.net/article/details/88819151)








