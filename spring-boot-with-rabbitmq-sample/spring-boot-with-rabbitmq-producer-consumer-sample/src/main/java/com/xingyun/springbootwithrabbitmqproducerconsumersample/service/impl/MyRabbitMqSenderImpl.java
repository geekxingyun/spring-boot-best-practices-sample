package com.xingyun.springbootwithrabbitmqproducerconsumersample.service.impl;

import com.xingyun.springbootwithrabbitmqproducerconsumersample.service.MyRabbitMqSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 通用消息发送
 * @author qing-feng.zhao
 */
@Slf4j
@Service
public class MyRabbitMqSenderImpl implements MyRabbitMqSender {
    /**
     * 获取默认队列
     */
    @Value(value = "${spring.rabbitmq.template.default-receive-queue}")
    public String defaultReceiveQueue;

    private final RabbitTemplate rabbitTemplate;
    public MyRabbitMqSenderImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessage(String sendMessageContent) {
        // 发送消息
        this.rabbitTemplate.convertAndSend(defaultReceiveQueue,sendMessageContent);
    }
}
