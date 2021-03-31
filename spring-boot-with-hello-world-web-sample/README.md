# 0x01 spring-boot-with-hello-world-web-sample

## 1.1 Getting Started

- clone project code repository:
```bash
git clone https://github.com/geekxingyun/spring-boot-best-practices-sample.git
```
- enter the current project folder:
```bash
cd ./spring-boot-best-practices-sample/spring-boot-with-hello-world-web-sample/
```
## 1.2 Building the Application
```bash
mvn clean package
```
## 1.3 Running the Application

- Enter the command in the same level directory of pom.xml:
```bash
java -jar ./target/spring-boot-with-hello-world-web-sample-0.0.1-SNAPSHOT.jar
```
- then open the website with chrome web browser as below:

[http://127.0.0.1:8080](http://127.0.0.1:8080/)

- you will see the message as below:

Hello World,Spring Boot!

## 1.5 Contributing

if you have some advice to me,please send email to fairy_xingyun@hotmail.com or request a issue on Github

# 0x02 QA 

## 2.1 how to change server port?

```bash
java -jar ./target/spring-boot-with-hello-world-web-sample-0.0.1-SNAPSHOT.jar --server.port=8080
```

## 2.2 how to change server context path?

```bash
java -jar ./target/spring-boot-with-hello-world-web-sample-0.0.1-SNAPSHOT.jar --server.port=8080 --server.servlet.context-path=/
```
## 2.3 How to convert the current maven project to gradle project?

It is very simple to automatically convert an existing Maven build to Gradle, just enter the following command
```bash
gradle init
```
#  0x03 Reference Article
- [Spring Boot 2.x 最佳实践之构建 Hello World web 应用程序](https://xingyun.blog.csdn.net/article/details/101110483)