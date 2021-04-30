package com.xingyun.springbootwithrabbitmqtopicpublishsubscribesample.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author qing-feng.zhao
 */
@Slf4j
@Component
public class MyRabbitMqSender {

    private final RabbitTemplate rabbitTemplate;
    private final MyRabbitMqReceiver myRabbitMqReceiver;


    public MyRabbitMqSender(RabbitTemplate rabbitTemplate, MyRabbitMqReceiver myRabbitMqReceiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.myRabbitMqReceiver = myRabbitMqReceiver;
    }

    public void sendMessage(){

        // 发送消息 只要匹配到foo.bar.* 的都可以发送
        this.rabbitTemplate.convertAndSend(rabbitTemplate.getExchange(),"foo.bar.baz","Hello From RabbitMQ");
        // 休眠10000毫秒
        try {
            this.myRabbitMqReceiver.getCountDownLatch().await(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
           log.error("线程被打断异常",e);
        }
    }
}
