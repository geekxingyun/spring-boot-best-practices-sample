package com.xingyun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingTestController {

	private Logger logger= LoggerFactory.getLogger(LoggingTestController.class);
	
	@GetMapping(value="/log.do")
	public String loggingTestMethod() {
		logger.trace("this is debug message");
		logger.debug("this is debug message");
		logger.info("this is info message");
		logger.warn("this is warn message");
		logger.error("this is debug message");
		return "logback test success,please check logs";
	}
}
