package com.xingyun.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;

import com.xingyun.properties.IBMMQProperties;

@Service
public class IBMMQJmsTemplateSenderService {
	
	private Logger logger=LoggerFactory.getLogger(IBMMQJmsTemplateSenderService.class);
	
	@Autowired
	public JmsOperations jmsOperations;
	
	@Autowired
	public IBMMQProperties iBMMQProperties;

	public void doProcessor(String message) {
		logger.debug("\r\n发送一条消息到IBM MQ,消息内容为:\r\n{}",message);
		jmsOperations.convertAndSend(iBMMQProperties.getQueueName(),message);
	}

}
