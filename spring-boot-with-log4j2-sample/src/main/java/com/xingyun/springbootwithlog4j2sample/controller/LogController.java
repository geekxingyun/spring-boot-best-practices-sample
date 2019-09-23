package com.xingyun.springbootwithlog4j2sample.controller;

import com.xingyun.springbootwithlog4j2sample.util.ThreadCustomLogger;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 星云
 * @功能
 * @date 9/15/2019 3:45 PM
 */
@Slf4j
@RestController
public class LogController {

    private static final org.slf4j.Logger LOGGER_SLF4J= LoggerFactory.getLogger(LogController.class);
    private static final Logger LOGGER_LOG4J2= LogManager.getLogger(LogController.class);
    private static Logger loggerCustom= null;

    @GetMapping(value = "/log.do")
    public String log(){

        //第一种日志使用SLF4J 日志门面调用
        LOGGER_SLF4J.debug("this is debug message with slf4j");
        LOGGER_SLF4J.info("this is info message with slf4j");
        LOGGER_SLF4J.warn("this is warn message with slf4j");
        LOGGER_SLF4J.error("this is error message with slf4j");

        //第二种方式使用log4j API 日志门面调用
        LOGGER_LOG4J2.debug("this is debug message with log4j2");
        LOGGER_LOG4J2.info("this is info message with log4j2");
        LOGGER_LOG4J2.warn("this is warn message with log4j2");
        LOGGER_LOG4J2.error("this is error message with log4j2");

        //第三种方式 配合lombok @Slf4j注解使用
        log.debug("this is debug message with lombok");
        log.info("this is  info message  with lombok");
        log.warn("this is  warn message with debug");
        log.error("this is error message with lombok");

        //第四种方式自定义线程日志
        if(null==loggerCustom){
            loggerCustom= ThreadCustomLogger.getLogger("myThread",LogController.class.getSimpleName());
        }
        loggerCustom.debug("this is custom debug message");
        loggerCustom.info("this is custom info message");
        loggerCustom.warn("this is custom warn message");
        loggerCustom.error("this is custom error message");
        return "log test finished,please check console message";
    }
}