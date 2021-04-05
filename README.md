# Spring Boot  2.x 最佳实践专栏简介

## 1.1 为什么写这个专栏？

> - Spring的出现简化了Java企业级应用的开发,凭着最初的IOC依赖注入容器和注解,以及灵活的对象依赖配置方式，经过多年的发展,已经成为功能丰富，生态完整的企业应用开发全栈框架。但是针对这些功能和子系统，我们往往要在xml中配置很多内容，一不小心很容易配置错误。 
> -  Spring团队意识到这个问题后，为了摆脱繁琐的XML配置，就推出了Spring Boot.
> -  Spring Boot 使用自动配置技术，可以做到零配置XML文件，当然如果想用XML配置Bean,Spring Boot 也保持了兼容。
> -  **Spring Boot 无疑如今已经成为Java 后端开发的行业标准，学会Spring Boot与各种技术集成是必学技能。**
> - **本专栏后期会考虑加入视频讲解，敬请期待。**
## 1.2 Spring Boot 2.x 最佳实践专栏简介
 **本专栏致力于打造 Spring Boot 与各种技术最佳实践整合的示例库**
>  - 专栏首页：[Spring Boot  2.x 最佳实践专栏](https://xingyun.blog.csdn.net/category_9284593.html)
>  - 专栏简介：[Spring Boot 2.x 最佳实践专栏简介](https://xingyun.blog.csdn.net/article/details/103041834) 
> -  代码仓库：[spring-boot-best-practices-sample](https://github.com/geekxingyun/spring-boot-best-practices-sample)

## 1.3 学习环境搭建

> -  [Maven](https://xingyun.blog.csdn.net/article/details/91415197) 
> - [JDK 8 update 60 +](https://www.oracle.com/technetwork/java/javase/downloads/index.html).
> - [Octotree](https://www.octotree.io/)
> - [Intellij Idea 介绍,安装与更新中文教程](https://xingyun.blog.csdn.net/article/details/104191661)
> - [Intellij Idea 常用经典定制配置](https://xingyun.blog.csdn.net/article/details/104154430)
## 1.4 博文更新列表
 <table>
        <th>博文更新列表</th>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/101110483" target="_blank">1.Spring Boot 2.x 最佳实践之构建 Hello World web 应用程序 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/88819151" target="_blank">2.Spring Boot 2.x 最佳实践之自定义Banner </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/89408533" target="_blank">3.Spring Boot 2.x 最佳实践之自定义Properties </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/100763122" target="_blank">4. Spring Boot 2.x 最佳实践之lombok集成 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/88884141" target="_blank">5. Spring Boot 2.x 最佳实践之Logback集成 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/100856124" target="_blank">6. Spring Boot 2.x 最佳实践之 Apache Log4j2 集成 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/89413333" target="_blank">7. Spring Boot 2.x 最佳实践之 Spring Web MVC 集成 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/92772523" target="_blank">8. Spring Boot 2.x 最佳实践之静态资源处理 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/89422513" target="_blank">9. Spring Boot 2.x 最佳实践之Thymeleaf集成 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/89413877" target="_blank">10.Spring Boot 2.x 最佳实践之JSP集成 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/89420502" target="_blank">11. Spring Boot 2.x 最佳实践之Swagger集成 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/97929511" target="_blank">12. Spring Boot 2.x 最佳实践之MyBatis集成 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/88974967" target="_blank">13. Spring Boot 2.x 最佳实践之Spring for Apache Kafka集成 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/101632155" target="_blank">14. Spring Boot 2.x 最佳实践之 Spring Data JPA集成 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/102492921" target="_blank">15. Spring Boot 2.x 最佳实践之 TinyMCE 集成 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/103067196" target="_blank">16. Spring Boot 2.x 最佳实践之 Quartz 集成 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/100038318" target="_blank">17. Spring Boot 2.x 最佳实践之 Spring Security 集成 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/103074053" target="_blank">18.Spring Boot 2.x 最佳实践之 Java Mail Sender集成 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/103735434" target="_blank">19. Spring Boot 2.x 最佳实践之 BootStrap V4集成 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/103754754" target="_blank">20. Spring Boot 2.x 最佳实践之Sonar 集成 </a></td></a>
        </tr>
        <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/103607879" target="_blank">21. Spring Boot 2.x最佳实践之 HTTPS 集成 </a></td></a>
        </tr>
           <tr align="left">
            <td><a href="https://xingyun.blog.csdn.net/article/details/105241114" target="_blank">22. Spring Boot 2.x 最佳实践之 Redis 集成 </a></td></a>
        </tr>
        <tr align="left">
        <td><a href="https://xingyun.blog.csdn.net/article/details/105337148" target="_blank">23. Spring Boot 2.x 最佳实践之技术发展趋势分析</td>
        </tr>
             <tr align="left">
        <td><a href="https://xingyun.blog.csdn.net/article/details/104969021" target="_blank">24. Spring Boot 2.x最佳实践之Docker 集成</td>
        </tr>
       <tr align="left">
        <td><a href="https://xingyun.blog.csdn.net/article/details/106175075" target="_blank">25. Spring Boot 2.x 最佳实践之 Spring Security+ Swagger+自定义拦截器Token权限校验</td>
        </tr>
  <tr align="left">
        <td><a href="https://xingyun.blog.csdn.net/article/details/112480340" target="_blank">26. Spring Boot 2.x 最佳实践之过滤器集成的四种方法</td>
        </tr>
  <tr align="left">
        <td><a href="https://xingyun.blog.csdn.net/article/details/112479248" target="_blank">27. SpringBoot2.x 最佳实践之拦截器集成</td>
        </tr>
        <tr align="left">
        <td><a href="https://xingyun.blog.csdn.net/article/details/113273376" target="_blank">28. SpringBoot2.x 最佳实践之Jenkins集成</td>
        </tr>
        <tr align="left">
        <td><a href="https://xingyun.blog.csdn.net/article/details/115437952" target="_blank">29. Spring Boot 2.x 最佳实践之 Spring Web Flux 集成
</td>
        </tr>
</table>
    
未完待续，持续更新中。。。

## 1.5 专栏公告
|专栏源码分类| 专栏源码博文列表| 专栏简介|
|--|--|--|
|  [Spring Boot 2.x 最佳实践专栏源码](https://github.com/geekxingyun/spring-boot-best-practices-sample) | [Spring  Boot 2.x 最佳实践专栏](https://xingyun.blog.csdn.net/category_9284593.html)  |[Spring Boot 2.x 最佳实践专栏简介](https://xingyun.blog.csdn.net/article/details/103041834)|
|  [微服务架构开发实战专栏源码](https://github.com/geekxingyun/spring-cloud-best-practices-sample)| [微服务架构开发实战专栏](https://xingyun.blog.csdn.net/category_9814450.html)|[微服务架构开发实战专栏简介](https://xingyun.blog.csdn.net/article/details/105055185)|

> - 本专栏是付费专栏, 专栏文章与视频教程后期会全部同步, 前几篇博文提供免费试读，其他内容请付费支持。
> - **订阅博主任意付费专栏，享有该博主全部专栏一年阅读权限**
> - 本专栏为虚拟产品，一经付款概不退款，敬请谅解。
> - 不愿意付费看博文讲解的可以**关注公众号免费看视频教程**或**免费加入我的知识星球向我提问**。
> - 我是技术宅星云，交流即分享，分享才能进步。
> - 如果有任何疑问或建议，可以私信或发我邮箱 `fairy_xingyun@hotmail.com` 
> - **付费成功如有需要，可私信我拉你入微信群，提供永久有效的Java后端技术问答咨询服务。**

本篇完～
