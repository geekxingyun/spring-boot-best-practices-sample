package com.iwatiao.springbootwithsinglerediscacheopssample.service;

import java.util.Set;

/**
 * @author qing-feng.zhao
 */
public interface CacheOperationService {

    Set getKeys(Object pattern);

    Boolean expire(String key,long time);

    Long getExpire(String key);

    Boolean hasKey(String key);

    void del(String... key);

    Object get(String key);

    Boolean set(String key,Object value);
}
