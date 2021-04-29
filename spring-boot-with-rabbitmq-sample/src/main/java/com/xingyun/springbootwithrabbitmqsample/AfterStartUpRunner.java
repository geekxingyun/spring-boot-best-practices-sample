package com.xingyun.springbootwithrabbitmqsample;

import com.xingyun.springbootwithrabbitmqsample.config.MyRabbitMQConfig;
import com.xingyun.springbootwithrabbitmqsample.service.MyRabbitMqReceiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 程序启动后执行
 * @author qing-feng.zhao
 */
@Slf4j
@Component
public class AfterStartUpRunner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final MyRabbitMqReceiver myRabbitMqReceiver;

    public AfterStartUpRunner(RabbitTemplate rabbitTemplate, MyRabbitMqReceiver myRabbitMqReceiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.myRabbitMqReceiver = myRabbitMqReceiver;
    }

    @Override
    public void run(String... args) throws Exception {
        // 发送消息 只要匹配到foo.bar.* 的都可以发送
        this.rabbitTemplate.convertAndSend(rabbitTemplate.getExchange(),"foo.bar.baz","Hello From RabbitMQ");
        // 休眠10000毫秒
        this.myRabbitMqReceiver.getCountDownLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}
