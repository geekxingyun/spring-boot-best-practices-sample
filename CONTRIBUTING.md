This document describes how to build the open source project from the command line and how to import the Spring Framework projects into an IDE.

## 1.1 Before You Start

To build you will need [Git](https://help.github.com/set-up-git-redirect) and [JDK 8 update 60 or later](https://www.oracle.com/technetwork/java/javase/downloads/index.html). Be sure that your JAVA_HOME environment variable points to the jdk1.8.0 folder extracted from the JDK download.

## 1.2 Get the Source Code

```bash
git clone https://github.com/geekxingyun/spring-boot-best-practices-sample.git
```

## 1.3 go into a project fodler which have a pom.xml

run the command as below:
```bash
mvn clean package
```

