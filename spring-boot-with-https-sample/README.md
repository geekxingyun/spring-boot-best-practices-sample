
博文讲解：[Spring Boot 2.x最佳实践之 HTTPS 集成](https://xingyun.blog.csdn.net/article/details/103607879)

博文目录
```
1. HTTPS 科普篇
1.1 什么是HTTP?
1.2 什么是HTTPS？
1.3 HTTP 和HTTPS 的区别
1.4 HTTPS 工作流程
2. 获取数字证书
2.1 购买的数字证书和自签名的数字证书的区别
2.2 购买免费的试用证书
2.3 自己动手做一个证书
2.3.1 什么是OpenSSL?
2.3.2 获取Open SSL
2.3.2.1 方法一：Github 下载源码编译安装
2.3.2.2 方法一：Windows下载编译好的Open SSL(亲测)
2.3.3 确定OpenSSL 的版本
2.3.2 创建秘钥
2.3.2.1 什么是秘钥？
2.3.2.2 生成RSA 秘钥（推荐）
2.3.3 创建一个证书
2.3.4 创建自签名可用的测试证书
2.3.5 安装证书(非必须)
2.3.6 秘钥和证书格式转换
2.3.6.1 PEM和DER转换
2.3.6.2 PKCS＃12（PFX）转换
2.3.6.3 PKCS＃7转换
3. Spring Boot 最佳实践之HTTPS 集成
3.1 添加依赖
3.2 配置properties
3.2.1 application.properties
3.2.2 application-dev.properties
3.2.3 application-prod.properties
3.3 配置静态资源处理
3.4 Spring Security 配置
3.5 Https 相关配置
3.6 配置页面控制器
3.7 配置页面
4. 源码下载
5. 参考资料
```