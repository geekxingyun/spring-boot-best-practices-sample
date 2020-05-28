package com.xingyun.springbootwithspringsecuritytokensample.util;

/**
 * @author qing-feng.zhao
 */
public class TokenTools {

    private TokenTools(){}

    public static final String getToken(){
        return String.valueOf(SnowFlakeUtils.nextId());
    }
}
