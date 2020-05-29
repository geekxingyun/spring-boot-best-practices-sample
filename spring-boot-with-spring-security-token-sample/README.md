# 项目介绍

这篇博文来总结下Spring Boot 2.x+ Spring Security+ 自定义拦截器实现带Token权限控制最佳实战攻略.

我们知道Java后端领域，Spring 官方团队提供了一个强大的网络安全框架——Spring Security.
但是我们的后端如今大多都是提供Restful API 给移动端提供接口，而Spring Security 默认对这种模式的支持不够友好。
当然它也支持，只是如果按照官方的那种操作手法极为复杂.
移动端需要带Token请求实现权限验证，因此如果按照之前的做法是使用自定义拦截器。
但是作为一个优秀的后端API来说，生成一个友好的API 文档极为重要。
经过实战发现，我们完全可以将自定义拦截器和Spring Security 强强联合实现上述后端开发需求。
————————————————
版权声明：本文为CSDN博主「技术宅星云」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：[https://xingyun.blog.csdn.net/article/details/106175075](https://xingyun.blog.csdn.net/article/details/106175075)
# Spring Security 默认登陆账号和密码
```
admin
123456
```

