package com.xingyun.springbootwithquartzsample.controller.api;

import com.xingyun.springbootwithquartzsample.job.HelloJob;
import com.xingyun.springbootwithquartzsample.util.QuartzUtils;
import com.xingyun.springbootwithquartzsample.util.SmartDateUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author qing-feng.zhao
 * @功能
 */
@Slf4j
@RestController
public class LearningSchedulerController {

    private final QuartzUtils quartzUtils;

    public LearningSchedulerController(QuartzUtils quartzUtils) {
        this.quartzUtils = quartzUtils;
    }

    /**
     * 最基础的没有任务的调度程序
     * @return
     */
    @GetMapping(value = "/basicSample.do")
    public String basicSample(){
        try {
            //从工厂里取出来一个定时任务调度程序实例
            Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();

            //开启定时任务调度程序
            scheduler.start();

            //停止定时任务调度程序
            scheduler.shutdown();
        } catch (SchedulerException e) {
            log.error(e.getMessage(),e);
        }
        return "quartz basic sample without job";
    }

    /**
     * 官方标准示例
     * @return
     */
    @GetMapping(value = "/basicOfficialJobSample.do")
    public String basicJobOfficialSample(){
        try {
            //从工厂里取出来一个定时任务调度实例
            Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();

            //定义一个任务
            // define the job and tie it to our HelloJob class
            JobDetail job = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .build();

            //定时一个任务触发器
            // Trigger the job to run now, and then repeat every 40 seconds
            Trigger trigger = newTrigger()
                    //任务触发器名称
                    .withIdentity("trigger1", "group1")
                    //立即开始
                    .startNow()
                    //加你单的定时任务调度器
                    .withSchedule(simpleSchedule()
                            //每四十秒执行一次
                            .withIntervalInSeconds(40)
                            //一直循环
                            .repeatForever())
                    .build();

            //告诉Quartz 使用我们的触发器要执行的任务
            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);
            //开启定时任务调度
            scheduler.start();
        } catch (SchedulerException e) {
            log.error(e.getMessage(),e);
        }
        return "quartz basic job official sample";
    }

    /**
     * 我们定时任务从当前时间立即开始执行
     * 当定时任务到2018-11-06 16:56:22 之前停止任务调度
     * 也就是说 endAt 的含义是 当执行到 2018-11-06 16:56:20 时发现到达我们设置的终点值，此时终止任务调度。
     * 而不是恰好等于2018-11-06 16:56:22
     * @return
     */
    @GetMapping(value = "/job1.do")
    public String usageJob(){
        try {

            //从工厂里取出来一个定时任务调度程序实例
            Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();

            //创建一个jobDetail的实例，将该实例与HelloJob Class绑定
            JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("myJob","myGroup")
                    .build();
            //创建一个Trigger触发器的实例，定义该job立即执行，并且每2秒执行一次，一直执行
            SimpleTrigger trigger = TriggerBuilder.
                    newTrigger()
                    //触发器名称
                    .withIdentity("myTrigger","myGroup")
                    //从现在起
                    .startNow()
                    //截止日期
                    .endAt(SmartDateUtils.strToDateLong("2019-11-14 16:10:22")).
                    withSchedule(
                            //简单的任务调度
                            SimpleScheduleBuilder.simpleSchedule()
                                    //每隔两秒执行一次
                                    .withIntervalInSeconds(2)
                                    //永久循环
                                    .repeatForever())
                    .build();

            //告诉Quartz 要什么时候触发执行我们的任务
            scheduler.scheduleJob(jobDetail,trigger);
            //开始启动
            scheduler.start();
        } catch (SchedulerException e) {
            log.error(e.getMessage(),e);
        }
        return "Quartz Job Sample 1";
    }

    @GetMapping(value = "/job2.do")
    public String usageJob2(){
        try {

            //从工厂里取出来一个定时任务调度程序实例
            Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
            //创建一个jobDetail的实例，将该实例与HelloJob Class绑定
            JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("myJob","myGroup")
                    .build();
            //创建一个Trigger触发器的实例，定义该job立即执行，并且每2秒执行一次，一直执行
            SimpleTrigger trigger = TriggerBuilder.
                    newTrigger()
                    //触发器名称
                    .withIdentity("myTrigger","myGroup")
                    //从现在起
                    .startNow()
                    //截止日期
                    .endAt(SmartDateUtils.strToDateLong("2019-11-11 24:00:00"))
                    .withSchedule(
                                    //简单的任务调度
                                    SimpleScheduleBuilder.simpleSchedule()
                                            //每隔1秒执行一次
                                            .withIntervalInSeconds(1)
                                            //只重复一次
                                            .withRepeatCount(1)
                    )
                    .build();
            //告诉Quartz 要什么时候触发执行我们的任务
            scheduler.scheduleJob(jobDetail,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            log.error(e.getMessage(),e);
        }
        return "Quartz Job Sample 2";
    }


    /**
     * 最佳实践
     * 每天下午两点半不见不散
     */
    public static final StringBuffer JOB_EXECUTE_TIME = new StringBuffer("0 30 14 * * ?");
    @GetMapping(value = "/job3.do")
    public String jobSample3(){

        quartzUtils.addJob("myJobName","myJobGroupName","triggerName","triggerGroupName",HelloJob.class,JOB_EXECUTE_TIME.toString());

        return "Quartz Job Sample 3";
    }
}
