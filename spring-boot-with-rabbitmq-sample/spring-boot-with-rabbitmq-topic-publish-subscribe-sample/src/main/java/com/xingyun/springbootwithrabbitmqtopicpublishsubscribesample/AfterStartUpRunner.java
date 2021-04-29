package com.xingyun.springbootwithrabbitmqtopicpublishsubscribesample;

import com.xingyun.springbootwithrabbitmqtopicpublishsubscribesample.service.MyRabbitMqSender;
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
        this.rabbitMqSender.sendMessage();
    }
}
