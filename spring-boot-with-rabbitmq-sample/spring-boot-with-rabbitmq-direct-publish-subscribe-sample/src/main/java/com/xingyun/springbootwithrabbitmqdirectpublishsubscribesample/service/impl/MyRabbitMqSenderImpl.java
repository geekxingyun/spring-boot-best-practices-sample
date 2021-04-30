package com.xingyun.springbootwithrabbitmqdirectpublishsubscribesample.service.impl;

import com.xingyun.springbootwithrabbitmqdirectpublishsubscribesample.common.enumvalue.RouteKeyEnums;
import com.xingyun.springbootwithrabbitmqdirectpublishsubscribesample.service.MyRabbitMqSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * 通用消息发送
 * @author qing-feng.zhao
 */
@Slf4j
@Service
public class MyRabbitMqSenderImpl implements MyRabbitMqSender {

    private final RabbitTemplate rabbitTemplate;

    public MyRabbitMqSenderImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessage(RouteKeyEnums routeKeyEnums, String sendMessageContent) {
        // 发送消息
        this.rabbitTemplate.convertAndSend(this.rabbitTemplate.getExchange(),routeKeyEnums.getRouteKey(),sendMessageContent);
    }
}
