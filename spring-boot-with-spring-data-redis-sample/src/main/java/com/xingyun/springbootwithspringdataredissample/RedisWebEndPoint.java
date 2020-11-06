package com.xingyun.springbootwithspringdataredissample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author qing-feng.zhao
 */
@Slf4j
@RestController
public class RedisWebEndPoint {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping(value = "/put-value.do")
    public String helloWorld(){
        redisTemplate.opsForZSet().add("zSetValue","A",1);
        redisTemplate.opsForZSet().add("zSetValue","B",3);
        redisTemplate.opsForZSet().add("zSetValue","C",2);
        redisTemplate.opsForZSet().add("zSetValue","D",5);
        return "put value";
    }

    @GetMapping(value = "/get-value.do")
    public String getValue(){
        Set zSetValue = redisTemplate.opsForZSet().range("zSetValue",0,-1);
        log.info("通过range(K key, long start, long end)方法获取指定区间的元素:{}",zSetValue);
        return "get value";
    }
}
