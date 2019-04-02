package com.xingyun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xingyun.service.MyKafkaProducer;


@RestController
public class KafkaProducerTestController {

	private static Logger logger=LoggerFactory.getLogger(KafkaProducerTestController.class);
		
	@Autowired
	MyKafkaProducer myKafkaProducer;
	
	@GetMapping(value="/kafka/send/{message}")
	public String send(@PathVariable("message") String message) {
	
		logger.debug("send message:{}",message);
		
		//第一种用法
		myKafkaProducer.sendToKafkaNormalMessage(message);
//		//第二种用法
//		myKafkaProducer.sendToKafkaStandardMessage(message);
//		//第三种用法
//		myKafkaProducer.sendToKafkaStandardMessageAsync(message);
//		//第四种用法
//		myKafkaProducer.sendToKafkaStandardMessageSync(message);
		
		return "send message to kafka finished";
	}
}
