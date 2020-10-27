package com.xingyun.springbootwithredissample.controller.api;

import com.xingyun.springbootwithredissample.service.MyRedisMessageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 */
@Slf4j
@RestController
public class RedisMessageReceiverController {

    private final StringRedisTemplate stringRedisTemplate;
    private final MyRedisMessageServiceImpl myRedisMessageServiceImpl;

    public RedisMessageReceiverController(MyRedisMessageServiceImpl myRedisMessageServiceImpl, StringRedisTemplate stringRedisTemplate) {
        this.myRedisMessageServiceImpl = myRedisMessageServiceImpl;
        this.stringRedisTemplate=stringRedisTemplate;
    }

    @GetMapping(value = "/send-redis-message.do")
    public String sendMessage(){

        log.info("Sending message...");
        //使用模版发送消息
        this.stringRedisTemplate.convertAndSend("chat", "Hello from Redis!");

        return "send message success";
    }

    @GetMapping(value = "/find-redis-message.do")
    public String findMessage(){
        log.info("Finding message...");
        //获取监听到的消息总数
        if(myRedisMessageServiceImpl.getCount()>0){
            log.info("find message {} count", myRedisMessageServiceImpl.getCount());
        }else{
            log.info("have no found any message from redis");
        }
        return "find message success";
    }
}
