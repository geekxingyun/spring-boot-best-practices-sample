package com.xingyun.springbootwithrabbitmqdirectpublishsubscribesample.config;

import com.xingyun.springbootwithrabbitmqdirectpublishsubscribesample.common.constvalue.RabbitMqConstValues;
import com.xingyun.springbootwithrabbitmqdirectpublishsubscribesample.common.enumvalue.RouteKeyEnums;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qing-feng.zhao
 */
@Configuration
public class MyRabbitMQConfig {
    /**
     * 创建一个队列Q1
     * @return
     */
    @Bean
    Queue queue1() {
        return new Queue(RabbitMqConstValues.QUEUE_1, false);
    }
    /**
     * 创建一个队列Q2
     * @return
     */
    @Bean
    Queue queue2() {
        return new Queue(RabbitMqConstValues.QUEUE_2, false);
    }
    /**
     * 配置 direct 类型的 exchange
     * @param rabbitTemplate
     * @return
     */
    @Bean
    DirectExchange directExchange(RabbitTemplate rabbitTemplate){
        return new DirectExchange(rabbitTemplate.getExchange());
    }
    /**
     * 将orange 路由发送给Q1队列
     * @param queue1
     * @param directExchange
     * @return
     */
    @Bean
    Binding binding1(Queue queue1,DirectExchange directExchange) {
        return BindingBuilder.bind(queue1).to(directExchange).with(RouteKeyEnums.ORANGE.getRouteKey());
    }

    /**
     * 将black 路由发送给Q1队列
     * @param queue2
     * @param directExchange
     * @return
     */
    @Bean
    Binding binding2(Queue queue2, DirectExchange directExchange) {
        return BindingBuilder.bind(queue2).to(directExchange).with(RouteKeyEnums.BLANK.getRouteKey());
    }

    /**
     * 将green 路由发送给Q2队列
     * @param queue2
     * @param directExchange
     * @return
     */
    @Bean
    Binding binding3(Queue queue2, DirectExchange directExchange) {
        return BindingBuilder.bind(queue2).to(directExchange).with(RouteKeyEnums.GREEN.getRouteKey());
    }

    /**
     * 配置监听有两种方式,
     * 一种是通过 @RabbitListener 注解,这种依赖于自动配置,会自动创建一个连接工厂
     * 一种是通过 Java Config 显式指定,需要手动指定连接工厂
     */
    //////////////////////////////////////Java Config 显式指定手动配置方法如下///////////////////////////////////////////////////
    /**
     * 自动配置会注册一个连接工厂,如果需要也可以手动指定一个连接工厂
     * 连接工厂
     * fixed the issue as below
     * Shutdown Signal: channel error; protocol method:
     * #method<channel.close>(reply-code=406, reply-text=PRECONDITION_FAILED -
     * inequivalent arg 'durable' for queue 'spring-boot-queue' in vhost '/':
     * received 'false' but current is 'true', class-id=50, method-id=10)
     * @param rabbitProperties
     * @return
     */
//    @Bean
//    public ConnectionFactory connectionFactory(RabbitProperties rabbitProperties) {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        connectionFactory.setHost(rabbitProperties.getHost());
//        connectionFactory.setVirtualHost(rabbitProperties.getVirtualHost());
//        connectionFactory.setCacheMode(CachingConnectionFactory.CacheMode.CHANNEL);
//        connectionFactory.setUsername(rabbitProperties.getUsername());
//        connectionFactory.setPassword(rabbitProperties.getPassword());
//        return connectionFactory;
//    }
//
//    /**
//     * 监听适配器
//     * @param myRabbitMqReceiver
//     * @return
//     */
//    @Bean
//    MessageListenerAdapter listenerAdapter1(MyRabbitMqQ1ReceiverImpl myRabbitMqReceiver) {
//        return new MessageListenerAdapter(myRabbitMqReceiver, "handleMessage");
//    }
//    /**
//     * 指定监听方法
//     * @param myRabbitMqReceiver
//     * @return
//     */
//    @Bean
//    MessageListenerAdapter listenerAdapter2(MyRabbitMqQ2ReceiverImpl myRabbitMqReceiver) {
//        // 默认监听方法
//        return new MessageListenerAdapter(myRabbitMqReceiver, "handleMessage");
//    }
//
//    @Bean
//    DirectMessageListenerContainer directMessageListenerContainer1(ConnectionFactory connectionFactory,
//                                                                  MessageListenerAdapter listenerAdapter1){
//        DirectMessageListenerContainer directMessageListenerContainer=new DirectMessageListenerContainer();
//        directMessageListenerContainer.setConnectionFactory(connectionFactory);
//        directMessageListenerContainer.setQueueNames(RabbitMqConstValues.QUEUE_1);
//        directMessageListenerContainer.setMessageListener(listenerAdapter1);
//        return directMessageListenerContainer;
//    }
//
//    @Bean
//    DirectMessageListenerContainer directMessageListenerContainer2(ConnectionFactory connectionFactory,
//                                                                  MessageListenerAdapter listenerAdapter2){
//        DirectMessageListenerContainer directMessageListenerContainer=new DirectMessageListenerContainer();
//        directMessageListenerContainer.setConnectionFactory(connectionFactory);
//        directMessageListenerContainer.setQueueNames(RabbitMqConstValues.QUEUE_2);
//        directMessageListenerContainer.setMessageListener(listenerAdapter2);
//        return directMessageListenerContainer;
//    }
}