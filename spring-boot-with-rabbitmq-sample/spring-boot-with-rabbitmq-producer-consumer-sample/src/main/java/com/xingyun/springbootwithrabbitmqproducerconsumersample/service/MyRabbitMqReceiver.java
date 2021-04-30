package com.xingyun.springbootwithrabbitmqproducerconsumersample.service;

/**
 * @author qing-feng.zhao
 */
public interface MyRabbitMqReceiver {
    /**
     * RabbitMQ 默认监听方法就是handleMessage
     * @param messageContent
     */
    void handleMessage(String messageContent);
}
