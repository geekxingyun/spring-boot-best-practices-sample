package com.xingyun.springbootwithrabbitmqdirectpublishsubscribesample;

import com.xingyun.springbootwithrabbitmqdirectpublishsubscribesample.common.enumvalue.RouteKeyEnums;
import com.xingyun.springbootwithrabbitmqdirectpublishsubscribesample.service.MyRabbitMqSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author qing-feng.zhao
 */
@Slf4j
@Component
public class AfterStartUpRunner implements CommandLineRunner {
    private final MyRabbitMqSender rabbitMqSender;

    public AfterStartUpRunner(MyRabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }

    @Override
    public void run(String... args) throws Exception {
        this.rabbitMqSender.sendMessage(RouteKeyEnums.ORANGE,"Hello,I am orange from rabbitMQ!");
        this.rabbitMqSender.sendMessage(RouteKeyEnums.BLANK,"Hello,I am black from rabbitMQ!");
        this.rabbitMqSender.sendMessage(RouteKeyEnums.GREEN,"Hello,I am green from rabbitMQ!");
    }
}
