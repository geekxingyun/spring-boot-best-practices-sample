package com.xingyun.springbootwithrabbitmqproducerconsumersample.service.impl;

import com.xingyun.springbootwithrabbitmqproducerconsumersample.service.MyRabbitMqReceiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author qing-feng.zhao
 */
@Slf4j
@Service
public class MyRabbitMqReceiverImpl implements MyRabbitMqReceiver {
    /**
     *
     * @param messageContent
     */
    @RabbitListener(queues = "default-spring-boot-queue")
    @Override
    public void handleMessage(String messageContent) {
        log.info("receiveMessage={}",messageContent);
    }
}
