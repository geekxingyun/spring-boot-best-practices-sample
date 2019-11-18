## 1. 什么是Quartz?

Quartz Scheduler 是一个完全用Java编写的定时任务执行框架。

它除了有基础功能的免费开源版本，也有拥有高级功能的企业版本 Where。

Quartz 官网:[http://www.quartz-scheduler.org/](http://www.quartz-scheduler.org/)

## 2.下载Quartz

[点击下载Quartz](http://www.quartz-scheduler.org/downloads/)

- 下载完成后解压到任意位置

## 3. 安装Quartz

- 如果想使用Quartz 的基础功能，需要添加
```
quartz-2.3.0-SNAPSHOT.jar
quartz-jobs-2.3.0-SNAPSHOT.jar
```
- 如果想使用Quartz的所有功能需要把这些jar都添加到ClassPath中
```
c3p0-0.9.5.2.jar
list.txt
log4j-1.2.16.jar
quartz-2.3.0-SNAPSHOT.jar
quartz-jobs-2.3.0-SNAPSHOT.jar
slf4j-api-1.7.7.jar
slf4j-log4j12-1.7.7.jar
```
- 如果构建一个web应用程序，quartz.properties 应该放到WEB-INF/classes 文件夹下。
## 4. 配置Quartz
quartz.properties
```
org.quartz.scheduler.instanceName = MyScheduler
org.quartz.threadPool.threadCount = 3
org.quartz.jobStore.class = org.quartz.simpl.RAMJobStore
```

|属性名称| 解释  |
|--|--|
| org.quartz.scheduler.instanceName | 任务调度器名称 |
|org.quartz.threadPool.threadCount| 线程池使用线程的数量,这是线程池中的3个线程，这意味着最多可以同时运行3个作业。|
|org.quartz.jobStore.class|Quartz的所有数据（例如作业和触发器的详细信息）都保存在内存中（而不是数据库中）。 即使您有数据库并希望将其与Quartz一起使用，我建议您在通过使用数据库打开全新维度之前，让Quartz与RamJobStore一起使用。|


## 开始写一个Demo

