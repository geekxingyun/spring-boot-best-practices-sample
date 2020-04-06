# use open jdk 8
FROM openjdk:8-jdk-alpine
# config var
ARG JAR_FILE=target/*.jar
# copy /target/*.jar
COPY ${JAR_FILE} app.jar
# execute command as java -jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]