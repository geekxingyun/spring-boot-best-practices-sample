package com.xingyun.springbootwithrabbitmqproducerconsumersample.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qing-feng.zhao
 */
@Configuration
public class MyRabbitMQConfig {
    /**
     * 获取默认队列
     */
    @Value(value = "${spring.rabbitmq.template.default-receive-queue}")
    public String defaultReceiveQueue;
    /**
     * 创建一个队列Q1
     * @return
     */
    @Bean
    Queue queue() {
        return new Queue(defaultReceiveQueue, false);
    }
}