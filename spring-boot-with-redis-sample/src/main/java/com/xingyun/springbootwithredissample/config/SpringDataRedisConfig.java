package com.xingyun.springbootwithredissample.config;

import com.xingyun.springbootwithredissample.service.MyRedisMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @author qing-feng.zhao
 */
@Slf4j
@Configuration
public class SpringDataRedisConfig {

//    @Bean
//    public LettuceConnectionFactory redisConnectionFactory() {
//        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("server", 6379));
//    }
//
//    /**
//     * Jedis
//     */
//    @Bean
//    public RedisConnectionFactory jedisConnectionFactory() {
//        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
//                .master("mymaster")
//                .sentinel("127.0.0.1", 26379)
//                .sentinel("127.0.0.1", 26380);
//        return new JedisConnectionFactory(sentinelConfig);
//    }
//
//    /**
//     * Lettuce
//     */
//    @Bean
//    public RedisConnectionFactory lettuceConnectionFactory() {
//        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
//                .master("mymaster")
//                .sentinel("127.0.0.1", 26379)
//                .sentinel("127.0.0.1", 26380);
//        return new LettuceConnectionFactory(sentinelConfig);
//    }

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //注册一个消息监听者
        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));

        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MyRedisMessageListener myRedisMessageListener) {
        //这里绑定的监听的方法
        return new MessageListenerAdapter(myRedisMessageListener, "receiveMessage");
    }

    @Bean
    MyRedisMessageListener receiver() {
        return new MyRedisMessageListener();
    }

    /**
     * 消息发送模版
     * @param connectionFactory
     * @return
     */
    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }
}
