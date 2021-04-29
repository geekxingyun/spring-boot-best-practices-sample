package com.xingyun.springbootwithrabbitmqsample.config;

import com.xingyun.springbootwithrabbitmqsample.service.MyRabbitMqReceiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qing-feng.zhao
 */
@Configuration
public class MyRabbitMQConfig {

    @Value(value = "${spring.rabbitmq.template.default-receive-queue}")
    public String defaultReceiveQueue;

    /**
     * 队列
     * @return
     */
    @Bean
    Queue queue() {
        return new Queue(defaultReceiveQueue, false);
    }

    /**
     * 交换路由
     * @param rabbitTemplate
     * @return
     */
    @Bean
    TopicExchange exchange(RabbitTemplate rabbitTemplate) {
        return new TopicExchange(rabbitTemplate.getExchange());
    }

    /**
     * 绑定
     * @param queue
     * @param exchange
     * @param rabbitTemplate
     * @return
     */
    @Bean
    Binding binding(Queue queue, TopicExchange exchange, RabbitTemplate rabbitTemplate) {
        return BindingBuilder.bind(queue).to(exchange).with(rabbitTemplate.getRoutingKey());
    }

    /**
     * 连接工厂
     * fixed the issue as below
     * Shutdown Signal: channel error; protocol method:
     * #method<channel.close>(reply-code=406, reply-text=PRECONDITION_FAILED -
     * inequivalent arg 'durable' for queue 'spring-boot-queue' in vhost '/':
     * received 'false' but current is 'true', class-id=50, method-id=10)
     * @param rabbitProperties
     * @return
     */
    @Bean
    public ConnectionFactory connectionFactory(RabbitProperties rabbitProperties) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(rabbitProperties.getHost());
        connectionFactory.setVirtualHost(rabbitProperties.getVirtualHost());
        connectionFactory.setCacheMode(CachingConnectionFactory.CacheMode.CONNECTION);
        connectionFactory.setUsername(rabbitProperties.getUsername());
        connectionFactory.setPassword(rabbitProperties.getPassword());
        return connectionFactory;
    }

    /**
     * 监听适配器
     * @param myRabbitMqReceiver
     * @return
     */
    @Bean
    MessageListenerAdapter listenerAdapter(MyRabbitMqReceiver myRabbitMqReceiver) {
        return new MessageListenerAdapter(myRabbitMqReceiver, "receiveMessage");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(defaultReceiveQueue);
        container.setMessageListener(listenerAdapter);
        return container;
    }
}
