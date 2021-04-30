package com.xingyun.springbootwithrabbitmqdirectpublishsubscribesample.service;

import com.xingyun.springbootwithrabbitmqdirectpublishsubscribesample.common.enumvalue.RouteKeyEnums;

/**
 * @author qing-feng.zhao
 */
public interface MyRabbitMqSender {
    void sendMessage(RouteKeyEnums routeKeyEnums,String sendMessageContent);
}
