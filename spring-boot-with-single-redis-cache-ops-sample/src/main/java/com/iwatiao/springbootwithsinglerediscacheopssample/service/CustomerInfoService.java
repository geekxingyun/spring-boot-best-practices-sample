package com.iwatiao.springbootwithsinglerediscacheopssample.service;

import com.iwatiao.springbootwithsinglerediscacheopssample.model.CustomerInfo;

/**
 * @author qing-feng.zhao
 */
public interface CustomerInfoService {
    /**
     * 创建/修改用户信息
     * @param customerInfo
     * @return
     */
    CustomerInfo saveCustomerInfo(final CustomerInfo customerInfo);
    /**
     * 获取用户信息
     * @param id
     * @return
     */
    CustomerInfo getCustomerInfo(long id);
    /**
     * 删除用户信息
     * @param id
     */
    void deleteCustomerInfo(long id);
}
