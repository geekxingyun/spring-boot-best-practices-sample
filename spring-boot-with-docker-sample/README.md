# 1. how to use docker with spring boot 2.x?

## 1.1 Build Image file

To build image file that you can use Dockerfile and docker command or use google jib plugin.

### 1.1.1 Use Dockerfile and Docker Command to build image file

#### 1.1.1.1 Write Dockerfile

Dockerfile
```bash
# use open jdk 8
FROM openjdk:8-jdk-alpine
# config var
ARG JAR_FILE=target/*.jar
# copy /target/*.jar
COPY ${JAR_FILE} app.jar
# execute command as java -jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
FROM : 相当于java 代码中的import 命令，引
```

if you are using maven ,please type these command as below:
```bash
docker build -t fairyxingyun/spring-boot-2-with-docker-sample .
```
if you are using gradle,please type these command as below:
```bash
docker build --build-arg JAR_FILE=build/libs/*.jar -t fairyxingyun/spring-boot-2-with-docker-sample .
```


#### 1.1.1.2 Use Google Jib Plugin

##### 1.1.1.2.1 only build  

- if you are using maven,please type command as below:
```bash
./mvnw compile jib:dockerBuild -Dimage=fairyxingyun/spring-boot-2-with-docker-sample
```
- if you are using gradle,please type command as below:
```
./gradlew jibDockerBuild --image=fairyxingyun/spring-boot-2-with-docker-sample
```
##### 1.1.1.2.2 build and push to DockerHub

- if you are using maven,please type command as below:
```bash
./mvnw compile jib:build -Dimage=fairyxingyun/spring-boot-2-with-docker-sample
```
- if you are using gradle,please type command as below:
```
./gradlew jib --image=fairyxingyun/spring-boot-2-with-docker-sample
```
## 1.2 Run Image File

if you want to run your image,please type command as below:

```bash
docker run -p 8080:8080 -t fairyxingyun/spring-boot-2-with-docker-sample
```
More detail ,please visit the article as below:

[Spring Boot 2.x 最佳实践之Docker 集成](https://xingyun.blog.csdn.net/article/details/104969021)