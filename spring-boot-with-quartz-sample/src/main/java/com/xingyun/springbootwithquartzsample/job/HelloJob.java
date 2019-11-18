package com.xingyun.springbootwithquartzsample.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author qing-feng.zhao
 * @功能
 */
@Slf4j
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Hello Job execute start...");
        log.info("Hello World Quartz");
        log.info("Hello Job execute end...");
    }
}
