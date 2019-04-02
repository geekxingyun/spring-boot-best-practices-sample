package com.xingyun.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.xingyun.properties.KafkaTopicCustomProperties;

@Service
public class MyKafkaProducer {
	
	private Logger logger=org.slf4j.LoggerFactory.getLogger(MyKafkaProducer.class);
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	/**
	 * 不可以使用静态关键字修饰
	 * **/
	@Autowired
	private KafkaTopicCustomProperties kafkaTopicCustomProperties;
	
	/******** method ***********************/
	/**
	 * 第一种用法:发送普通消息没有回执
	 */
	public void sendToKafkaNormalMessage(String message) {
		
		logger.info("sending message='{}' to topic='{}'", message,kafkaTopicCustomProperties.getTopicName());
		
		// 使用Kafka直接向指定的Topic(主题)发送消息
		kafkaTemplate.send(kafkaTopicCustomProperties.getTopicName(),message);
	}
	
	/**
	 * 第二种用法:发送标准消息没有回执
	 */
	public void sendToKafkaStandardMessage(String message) {
		
		logger.info("sending message='{}' to topic='{}'", message,kafkaTopicCustomProperties.getTopicName());
		
		//构造一个标准的消息进行发送
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(kafkaTopicCustomProperties.getTopicName(),message);

		kafkaTemplate.send(record);
		
	}
	
	/**
	 * 第三种用法:发送标准消息异步无阻塞
	 * **/
	public void sendToKafkaStandardMessageAsync(final String message) {
		
		// 构建待发送的消息
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(kafkaTopicCustomProperties.getTopicName(), message);

		// 尝试发送消息
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(record);

		// 发送消息回调
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			/**
			 * 发送成功回调方法
			 */
			@Override
			public void onSuccess(SendResult<String, String> sendResultMap) {
				// TODO Auto-generated method stub
				logger.debug("\r\n send message To Kafka Async success");
			}

			/**
			 * 发送失败回调方法
			 */
			@Override
			public void onFailure(Throwable throwable) {
				// TODO Auto-generated method stub
				logger.debug("\r\n send message To Kafka Async fail");
			}
		});
	}
	
	/**
	 * 第四种用法：发送标准消息同步有阻塞
	 */
	public void sendToKafkaStandardMessageSync(String message) {
		
		//构建发送消息
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(kafkaTopicCustomProperties.getTopicName(), message);
		try {
			// 使用模板发送消息
			kafkaTemplate.send(record).get(10,TimeUnit.SECONDS);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.error("InterruptedException:",e.toString());
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			logger.debug("ExecutionException:",e.toString());
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			logger.debug("TimeoutException:",e.toString());
		}
	}
	
}
