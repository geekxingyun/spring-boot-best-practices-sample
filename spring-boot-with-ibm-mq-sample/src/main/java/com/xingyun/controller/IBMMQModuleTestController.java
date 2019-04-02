package com.xingyun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xingyun.properties.IBMMQProperties;

@RestController
public class IBMMQModuleTestController {
	
    private Logger logger=LoggerFactory.getLogger(IBMMQModuleTestController.class);
    
    private static String testMessage = "this is an test message";
    
    @Autowired 
    private IBMMQProperties iBMMQProperties;
    
    @Autowired 
    private JmsOperations jmsOperations;
    
	@GetMapping(value="/ibmmq.do")
	public String test() {
		
		logger.debug("-----------send message to IBM MQ　start-------------");
	    try {
			jmsOperations.convertAndSend(iBMMQProperties.getQueueName(),testMessage); 
			logger.debug("-----------send message to IBM MQ　end-------------");
			return "send message to IBM MQ finished";
		} catch (JmsException e) {
			// TODO Auto-generated catch block
			logger.error("-----------send message to IBM MQ　end-------------");
			return "send message to IBM MQ fail"+e.toString();
		}
	}

}
