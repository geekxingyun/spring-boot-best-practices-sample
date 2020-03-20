package com.xingyun.springbootwithconfigurationprocessorsample.customize.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 自定义属性
 * @author qing-feng.zhao
 * */
@Data
@ConfigurationProperties(prefix="com.xingyun.customize")
public class MyCustomProperties {
    /**
     * 对应的属性就是 com.xingyun.customize.server-address
     */
    private String serverAddress;
    /**
     * 对应的属性就是 com.xingyun.customize.port
     */
    private String port;
    /**
     * 对应属性就是 com.xingyun.customize.username
     */
    private String username;
    /**
     * 对应属性就是 com.xingyun.customize.password
     */
    private String password;
}
