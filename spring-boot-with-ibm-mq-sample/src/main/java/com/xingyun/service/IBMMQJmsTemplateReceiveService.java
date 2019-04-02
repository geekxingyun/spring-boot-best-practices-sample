package com.xingyun.service;


import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

import com.xingyun.properties.IBMMQProperties;

@Service
public class IBMMQJmsTemplateReceiveService extends MessageListenerAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(IBMMQJmsTemplateReceiveService.class);
	@Autowired
	JmsOperations jmsOperations;
	
	@Autowired
	IBMMQProperties iBMMQProperties;

	@JmsListener(destination = "${com.xingyun.ibm.mq.queue-name}")
	public void receive(Message message){
			 String result=message.toString();
			 logger.debug("\r\nIBM MQ receive a message:\r\n"+result);
	}
}
