package com.iwatiao.springbootwithsinglerediscacheopssample.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author qing-feng.zhao
 */
@Slf4j
@Service
public class CacheOperationServiceImpl implements CacheOperationService{

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 取得指定格式的所有的key键
     * @param pattern
     * @return
     */
    @Override
    public Set getKeys(Object pattern) {
        try {
            return this.redisTemplate.keys(pattern);
        } catch (Exception e) {
           log.error("取得指定格式的所有的key键出错",e);
           return null;
        }
    }

    /**
     * 指定缓存失效的时间
     * @param key key键
     * @param time 时间(秒)
     * @return
     */
    @Override
    public Boolean expire(String key, long time) {
        try {
            if(time>0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
           log.error("指定缓存失效的时间",e);
           return false;
        }
    }

    /**
     * 根据key获取过期的时间
     * @param key 不能为空
     * @return 时间秒，返回0 表示永久有效
     */
    @Override
    public Long getExpire(String key) {
        return this.redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     * @param key
     * @return true 存在 false 不存在
     */
    @Override
    public Boolean hasKey(String key) {
        try {
            return this.redisTemplate.hasKey(key);
        } catch (Exception e) {
            log.error("判断key是否存在",e);
            return false;
        }
    }

    /**
     * 删除缓存
     * @param key 可以传一个值或者多个
     * return 删除的个数
     */
    @Override
    public void del(String... key) {
        if(null!=key&& key.length>0){
            if(key.length == 1){
                this.redisTemplate.delete(key[0]);
            }else{
                this.redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }

    }

    //////////////////////RedisTemplate操作String字符串///////////////////////////

    /**
     * 获取String
     * @param key 键
     * @return 值
     */
    @Override
    public Object get(String key) {
        return null==key?null:this.redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置String
     * @param key 键
     * @param value 值
     * @return true 成功 false 失败
     */
    @Override
    public Boolean set(String key, Object value) {
        try {
            // 操作字符串
            this.redisTemplate.opsForValue().set(key,value);
            return true;
        } catch (Exception e) {
            log.error("设置String出错",e);
           return false;
        }
    }
}
