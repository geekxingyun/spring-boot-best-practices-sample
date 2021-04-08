package com.xingyun.springbootwithlogback.controller;

import com.xingyun.springbootwithlogback.config.StaticPropertiesUtils;
import com.xingyun.springbootwithlogback.util.LogbackThreadLogger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 */
@Slf4j
@RestController
public class LoggingTestController {

	@GetMapping(value="/log.do")
	public String loggingTestMethod() {
		log.debug("this is debug message");
		log.info("this is info message");
		log.warn("this is warn message");
		log.error("this is debug message");
		return "logback test success,please check logs";
	}

	@GetMapping(value="/log-thread.do")
	public String loggingThreadTestMethod() {

		//日志将会保存在/opt/logs/spring-boot-with-logback-sample/customize-thread-log/test/LoggingTestController.log
		Logger logger=LogbackThreadLogger.getLogger("test",LoggingTestController.class.getSimpleName());
		logger.debug("this is thread debug message");
		logger.info("this is thread info message");
		logger.warn("this is thread warn message");
		logger.error("this is thread error message");
		return "logback test success,please check logs";
	}

	@GetMapping(value = "/test.do")
	public String loadStaticProperties(){
		String appName=StaticPropertiesUtils.getProperty("customized.logback-thread-logging-config.applicationName");
		String loggingFileBasePath=StaticPropertiesUtils.getProperty("customized.logback-thread-logging-config.loggingFileBasePath");
		String singleFileMaxSize=StaticPropertiesUtils.getProperty("customized.logback-thread-logging-config.singleFileMaxSize");
		log.info(appName);
		log.info(loggingFileBasePath);
		log.info(singleFileMaxSize);
		return "test success";
	}

}
