package com.xingyun.springbootwithquartzsample.factory;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/12/3 21:47
 */
@Component
public class MyQuartzJobFactory extends AdaptableJobFactory {

    /**
     * 构造方法注入 避免循环依赖或处理特殊依赖执行顺序
     */
    private final AutowireCapableBeanFactory capableBeanFactory;

    public MyQuartzJobFactory(AutowireCapableBeanFactory capableBeanFactory) {
        this.capableBeanFactory = capableBeanFactory;
    }

    @Override
    protected Object createJobInstance(TriggerFiredBundle triggerFiredBundle) throws Exception {
        //调用父类的方法
        Object jobInstance = super.createJobInstance(triggerFiredBundle);
        //依赖注入
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
