package com.xingyun.springbootwithquartzsample.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;

/**
 * @author qing-feng.zhao
 * @功能
 */
@Slf4j
public class HelloJob implements Job {

    @Autowired
    private ServerProperties serverProperties;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Hello Job execute start...");
        log.info("Hello World Quartz at {}",System.nanoTime());
        log.info("端口号"+serverProperties.getPort());
        log.info("Hello Job execute end...");
    }
}
