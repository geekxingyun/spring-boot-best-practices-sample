package com.iwatiao.springbootwithsinglerediscacheopssample;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author qing-feng.zhao
 */
@SpringBootTest
public class RedisConnectionTest {

    private static final Integer REDIS_PORT=6379;
    private static final Integer REDIS_DATE_BASE_INDEX=0;
    private static final String REDIS_SERVER_IP_ADDRESS="192.168.159.9";
    private static final String REDIS_USER_PASSWORD="123456";

    @Test
    public void testRedisConnect(){

        // 初始化Redis Client
        RedisClient redisClient = this.initRedisClient();
        // 连接Redis
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        // 异步操作命令
        RedisCommands<String, String> syncCommands = connection.sync();

        // 测试存放一个字符串
        syncCommands.set("hi", "Hello, Redis!");

        // 获取存入的字符串
        String message=syncCommands.get("hi");

        // 打印获取到的字符串
        System.out.println("get message="+message);

        // 关闭Redis 连接
        connection.close();
        // 关闭客户端
        redisClient.shutdown();
    }

    private RedisClient initRedisClient(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("redis://");
        stringBuilder.append(REDIS_USER_PASSWORD);
        stringBuilder.append("@");
        stringBuilder.append(REDIS_SERVER_IP_ADDRESS);
        stringBuilder.append(":");
        stringBuilder.append(REDIS_PORT);
        stringBuilder.append("/");
        stringBuilder.append(REDIS_DATE_BASE_INDEX);
        System.out.println(stringBuilder.toString());
        return RedisClient.create(stringBuilder.toString());
    }
}
