package com.xingyun.controller;

import com.xingyun.util.LogbackThreadLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * @author xingyun
 */
@RestController
public class LoggingTestController {

	private static Logger logger= LoggerFactory.getLogger(LoggingTestController.class);
	
	@GetMapping(value="/log.do")
	public String loggingTestMethod() {
		logger.debug("this is debug message");
		logger.info("this is info message");
		logger.warn("this is warn message");
		logger.error("this is debug message");
		return "logback test success,please check logs";
	}

	@GetMapping(value="/log-thread.do")
	public String loggingThreadTestMethod() {

		Logger logger=LogbackThreadLogger.getLogger("test",LoggingTestController.class.getSimpleName());
		logger.debug("this is thread debug message");
		logger.info("this is thread info message");
		logger.warn("this is thread warn message");
		logger.error("this is thread error message");
		return "logback test success,please check logs";
	}
}
