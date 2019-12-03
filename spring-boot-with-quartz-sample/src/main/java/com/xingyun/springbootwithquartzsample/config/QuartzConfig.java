package com.xingyun.springbootwithquartzsample.config;

import com.xingyun.springbootwithquartzsample.factory.MyQuartzJobFactory;
import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author qing-feng.zhao
 * @description Quartz 配置类
 * @date 2019/12/3 21:45
 */
@Configuration
public class QuartzConfig {
    /**
     * 构造方法注入
     */
    private final MyQuartzJobFactory myQuartzJobFactory;

    /**
     * 类的方法初始化顺序
     * 1. 首先初始化构造方法
     * 2. 初始化其他实例方法
     *
     * @param myQuartzJobFactory
     */
    public QuartzConfig(MyQuartzJobFactory myQuartzJobFactory) {
        this.myQuartzJobFactory = myQuartzJobFactory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        //初始化一个工厂
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        //重写覆盖掉以前的任务
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        //注入自定义Quartz工厂
        schedulerFactoryBean.setJobFactory(myQuartzJobFactory);
        return schedulerFactoryBean;
    }

    /**
     * 默认的Scheduler 不支持@Autowired
     * 这个是增强版本,支持@Autowired依赖注入
     */
    @Bean
    public Scheduler schedulerPlus(){
        return  schedulerFactoryBean().getScheduler();
    }
}
