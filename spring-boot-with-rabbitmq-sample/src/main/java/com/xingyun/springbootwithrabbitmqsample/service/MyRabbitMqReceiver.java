package com.xingyun.springbootwithrabbitmqsample.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @author qing-feng.zhao
 */
@Slf4j
@Component
public class MyRabbitMqReceiver {

    private CountDownLatch countDownLatch=new CountDownLatch(1);

    @RabbitListener
    public void receiveMessage(String message){
        log.info("Received < {} >",message);
        countDownLatch.countDown();
    }

    public CountDownLatch getCountDownLatch(){
        return countDownLatch;
    }
}
