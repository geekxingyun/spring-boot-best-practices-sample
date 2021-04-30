package com.xingyun.springbootwithrabbitmqdirectpublishsubscribesample.common.enumvalue;

import lombok.Getter;

/**
 * @author qing-feng.zhao
 */
public enum RouteKeyEnums {
    ORANGE("orange"),
    BLANK("black"),
    GREEN("green");
    @Getter
    private String routeKey;

    RouteKeyEnums(String routeKey){
        this.routeKey=routeKey;
    }
}
