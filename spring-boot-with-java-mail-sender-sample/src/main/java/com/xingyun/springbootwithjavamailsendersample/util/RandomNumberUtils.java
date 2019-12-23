package com.xingyun.springbootwithjavamailsendersample.util;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/12/22 19:57
 */
public final class RandomNumberUtils {

    public static int getRandomNumber(){
        return (int)((Math.random()*9+1)*100000);
    }
}
