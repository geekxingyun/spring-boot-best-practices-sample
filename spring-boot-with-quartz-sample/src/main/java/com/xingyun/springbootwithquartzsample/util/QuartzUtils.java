package com.xingyun.springbootwithquartzsample.util;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author qing-feng.zhao
 * @功能 Quartz定时任务执行框架代码封装
 */
@Slf4j
@Component
public class QuartzUtils{

    private final Scheduler schedulerPlus;

    public QuartzUtils(Scheduler schedulerPlus) {
        this.schedulerPlus = schedulerPlus;
    }

    /**
     * @Description: 添加一个定时任务
     * @param jobName 任务名
     * @param jobGroupName  任务组名
     * @param triggerName 触发器名
     * @param triggerGroupName 触发器组名
     * @param jobClass  任务
     * @param cron   时间设置，参考quartz说明文档
     */
    public void addJob(String jobName, String jobGroupName,
                       String triggerName, String triggerGroupName, Class jobClass, String cron) {
        try {
            // 任务名，任务组，任务执行类
            JobDetail jobDetail= JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();

            // 触发器
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            // 触发器名,触发器组
            triggerBuilder.withIdentity(triggerName, triggerGroupName);
            //触发器启动
            triggerBuilder.startNow();
            // 触发器时间设定
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
            // 创建Trigger对象
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();

            // 调度容器设置JobDetail和Trigger
            schedulerPlus.scheduleJob(jobDetail, trigger);

            //如果没有关闭
            if (!schedulerPlus.isShutdown()) {
                //启动定时任务调度程序
                schedulerPlus.start();
            }
        } catch (Exception e) {
            log.error("添加定时任务失败"+e.toString());
            throw new RuntimeException(e);
        }
    }

    public void addJobSimple(String jobName, String jobGroupName,
                             String triggerName, String triggerGroupName, Class jobClass, Date endDate,Integer intervalInSeconds) {
        try {
            //创建一个jobDetail的实例，将该实例与HelloJob Class绑定
            JobDetail jobDetail = JobBuilder.newJob(jobClass)
                    .withIdentity(jobName,jobGroupName)
                    .build();
            //创建一个Trigger触发器的实例，定义该job立即执行，并且每2秒执行一次，一直执行
            SimpleTrigger trigger = TriggerBuilder.
                    newTrigger()
                    //触发器名称
                    .withIdentity(triggerName,triggerGroupName)
                    //从现在起
                    .startNow()
                    //截止日期
                    .endAt(endDate).
                            withSchedule(
                                    //简单的任务调度
                                    SimpleScheduleBuilder.simpleSchedule()
                                            //每隔多少秒执行一次
                                            .withIntervalInSeconds(intervalInSeconds)
                                            //永久循环
                                            .repeatForever())
                    .build();

            //告诉Quartz 要什么时候触发执行我们的任务
            schedulerPlus.scheduleJob(jobDetail,trigger);
            //开始启动
            schedulerPlus.start();
        } catch (SchedulerException e) {
            log.error(e.getMessage(),e);
        }
    }

    /**
     * @Description: 修改一个任务的触发时间
     * @param jobName
     * @param jobGroupName
     * @param triggerName 触发器名
     * @param triggerGroupName 触发器组名
     * @param cron   时间设置，参考quartz说明文档
     */
    public void modifyJobTime(String jobName,String jobGroupName, String triggerName, String triggerGroupName, String cron) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            CronTrigger trigger = (CronTrigger) schedulerPlus.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }

            String oldTime = trigger.getCronExpression();
            System.out.println("旧时间是:"+oldTime);
            if (!oldTime.equalsIgnoreCase(cron)) {
                log.info("监听旧时间:"+oldTime+"新时间:"+cron+"时间替换");
                /** 方式一 ：调用 rescheduleJob 开始 */
                // 触发器
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组
                triggerBuilder.withIdentity(triggerName, triggerGroupName);
                triggerBuilder.startNow();
                // 触发器时间设定
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
                // 创建Trigger对象
                trigger = (CronTrigger) triggerBuilder.build();
                // 方式一 ：修改一个任务的触发时间
                schedulerPlus.rescheduleJob(triggerKey, trigger);
                /** 方式一 ：调用 rescheduleJob 结束 */

                /** 方式二：先删除，然后在创建一个新的Job  */
                //JobDetail jobDetail = scheduler.getJobDetail(JobKey.jobKey(jobName, jobGroupName));
                //Class<? extends Job> jobClass = jobDetail.getJobClass();
                //removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
                //addJob(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, cron);
                /** 方式二 ：先删除，然后在创建一个新的Job */
            }else{
                log.info("监听旧时间:"+oldTime+"新时间:"+cron+"保持时间");
            }
        } catch (Exception e) {
            log.error("修改定时任务失败"+e.toString());
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description: 移除一个任务
     *
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     */
    public void removeJob(String jobName, String jobGroupName,
                          String triggerName, String triggerGroupName) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            // 停止触发器
            schedulerPlus.pauseTrigger(triggerKey);
            // 移除触发器
            schedulerPlus.unscheduleJob(triggerKey);
            // 删除任务
            schedulerPlus.deleteJob(JobKey.jobKey(jobName, jobGroupName));
        } catch (Exception e) {
            log.error("移除定时任务失败"+e.toString());
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description 启动所有定时任务
     */
    public void startJobs() {
        try {
            schedulerPlus.start();
        } catch (Exception e) {
            log.error("启动所有定时任务失败"+e.toString());
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description 关闭所有定时任务
     */
    public void shutdownJobs() {
        try {
            if (!schedulerPlus.isShutdown()) {
                schedulerPlus.shutdown();
            }
        } catch (Exception e) {
            log.error("关闭所有定时任务失败"+e.toString());
            throw new RuntimeException(e);
        }
    }
}
