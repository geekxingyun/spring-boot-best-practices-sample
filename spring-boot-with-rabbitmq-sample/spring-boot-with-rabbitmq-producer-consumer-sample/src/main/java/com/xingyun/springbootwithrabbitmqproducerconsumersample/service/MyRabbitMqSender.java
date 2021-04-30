package com.xingyun.springbootwithrabbitmqproducerconsumersample.service;
/**
 * @author qing-feng.zhao
 */
public interface MyRabbitMqSender {
    void sendMessage(String sendMessageContent);
}
