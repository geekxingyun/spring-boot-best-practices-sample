package com.iwatiao.springbootwithsinglerediscacheopssample.service;

import com.iwatiao.springbootwithsinglerediscacheopssample.model.CustomerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author qing-feng.zhao
 */
@Slf4j
public class CustomerInfoServiceImpl implements CustomerInfoService{

    public static final String USER_UID_PREFIX="user:uid:";

    private static final long INVALID_TIME=60*4;

    @Autowired
    CacheOperationService cacheOperationService;

    @Override
    public CustomerInfo saveCustomerInfo(CustomerInfo customerInfo) {
        String key=USER_UID_PREFIX+ customerInfo.getUid();
        log.info("customer :",customerInfo);
        this.cacheOperationService.set(key,customerInfo);
        return customerInfo;
    }

    @Override
    public CustomerInfo getCustomerInfo(long id) {
        String key=USER_UID_PREFIX+id;
        CustomerInfo value= (CustomerInfo) cacheOperationService.get(key);
        if(null==value){
            // 如果缓存中没有就从数据库中取
            // 比如mySQL
            // 并且保存到缓存
        }
        return value;
    }

    @Override
    public void deleteCustomerInfo(long id) {
        // 从缓存删除
        String key=USER_UID_PREFIX+id;
        this.cacheOperationService.del(key);
        // 从数据库删除
    }
}
