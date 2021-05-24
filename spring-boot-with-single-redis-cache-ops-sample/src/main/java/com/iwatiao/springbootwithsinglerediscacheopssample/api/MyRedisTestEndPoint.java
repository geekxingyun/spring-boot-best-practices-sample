package com.iwatiao.springbootwithsinglerediscacheopssample.api;

import com.iwatiao.springbootwithsinglerediscacheopssample.service.CacheOperationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 */
@RestController
public class MyRedisTestEndPoint {

    private final CacheOperationService cacheOperationService;

    public MyRedisTestEndPoint(CacheOperationService cacheOperationService) {
        this.cacheOperationService = cacheOperationService;
    }

    @GetMapping(value = "/put-redis-key.do")
    public String putRedisKey(@RequestParam(name = "contentValue",defaultValue = "Hello World",required = false) String contentValue){
        this.cacheOperationService.set("hi",contentValue);
        return "存放成功";
    }

    @GetMapping(value = "/get-redis-key.do")
    public String getRedisKey(@RequestParam(name = "key",defaultValue = "hi",required = false) String key){
        String contentValue=(String)this.cacheOperationService.get("hi");
        return "获取成功:"+contentValue;
    }
}
