//package com.xingyun.springbootwithspringdataredissample.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * @author qing-feng.zhao
// */
//@Configuration
//public class RedisConfig {
//
//    @Bean
//    public LettuceConnectionFactory redisConnectionFactory() {
//        RedisStandaloneConfiguration redisStandaloneConfiguration=new RedisStandaloneConfiguration();
//        redisStandaloneConfiguration.setHostName("47.92.124.207");
//        redisStandaloneConfiguration.setPort(6379);
//        //redisStandaloneConfiguration.setPassword("Ke4f14aEE0f112F0");
//        LettuceConnectionFactory lettuceConnectionFactory=new LettuceConnectionFactory(redisStandaloneConfiguration);
//        lettuceConnectionFactory.afterPropertiesSet();
//        return lettuceConnectionFactory;
//    }
//
//    @Bean
//    public RedisTemplate<String,Object> redisTemplate()
//    {
//        RedisTemplate<String,Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory());
//        template.setKeySerializer(new StringRedisSerializer());
//        return template;
//    }
//}
