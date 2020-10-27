package com.xingyun.springbootwithredissample.service;

/**
 * @author qing-feng.zhao
 */
public interface MyRedisMessageService {
    void receiveMessage(String message);
    int getCount();
}
