package com.xingyun.springbootwithjavamailsendersample.service;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/12/21 19:28
 */
public interface UserService {

    /**
     * 注册邮件
     * @param subject
     * @param content
     * @param toUserEmailArray
     */
    void registerEmail(String subject,String content,String[] toUserEmailArray);
}
