package com.xingyun.springbootwithrabbitmqdirectpublishsubscribesample.service.impl;

import com.xingyun.springbootwithrabbitmqdirectpublishsubscribesample.common.constvalue.RabbitMqConstValues;
import com.xingyun.springbootwithrabbitmqdirectpublishsubscribesample.service.MyRabbitMqReceiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author qing-feng.zhao
 */
@Slf4j
@Service
public class MyRabbitMqQ1ReceiverImpl implements MyRabbitMqReceiver {
    /**
     * 监听orange路由key
     * 如果监听配置多个队列
     * @RabbitListener(queues = {RabbitMqConstValues.QUEUE_1,RabbitMqConstValues.QUEUE_2})
     * 如果需要指定连接工厂
     * @RabbitListener(queues = {RabbitMqConstValues.QUEUE_2},containerFactory="connectionFactory")
     * @param messageContent
     */
    @RabbitListener(queues = RabbitMqConstValues.QUEUE_1)
    @Override
    public void handleMessage(String messageContent) {
        log.info("Q1:receiveMessage={}",messageContent);
    }
}
