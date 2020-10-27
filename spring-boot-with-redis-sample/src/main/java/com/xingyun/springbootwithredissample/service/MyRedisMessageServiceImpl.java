package com.xingyun.springbootwithredissample.service;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author qing-feng.zhao
 */
@Slf4j
public class MyRedisMessageServiceImpl implements MyRedisMessageService{

    private AtomicInteger counter = new AtomicInteger();

    /**
     * Config 类中会注册绑定这个方法
     *   return new MessageListenerAdapter(myRedisMessageListener, "receiveMessage");
     * @param message
     */
    @Override
    public void receiveMessage(String message) {
        log.info("Received <" + message + ">");
        counter.incrementAndGet();
    }

    @Override
    public int getCount() {
        return counter.get();
    }
}
