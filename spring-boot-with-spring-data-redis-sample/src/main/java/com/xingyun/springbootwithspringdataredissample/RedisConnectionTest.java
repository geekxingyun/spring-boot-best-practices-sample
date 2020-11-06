package com.xingyun.springbootwithspringdataredissample;

import redis.clients.jedis.Jedis;

/**
 * @author qing-feng.zhao
 */
public class RedisConnectionTest {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("47.92.124.207", 6379);
       // jedis.auth("123456");
        jedis.set("wxf", "我很强");
        String value=jedis.get("wxf");
        System.out.println(value);
        //释放资源
        jedis.close();
    }
}
