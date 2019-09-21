package com.xingyun.springbootwithconfigurationprocessorsample.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 自定义属性前缀
 * @author xingyun
 * */
@ConfigurationProperties(prefix="com.xingyun.custom")
public class MyCustomProperties {
    /**
     * 对应的属性就是 com.xingyun.custom.server-address
     */
    private String serverAddress;
    /**
     * 对应的属性就是 com.xingyun.custom.port
     */
    private String port;
    /**
     * 对应属性就是 com.xingyun.custom.username
     */
    private String username;
    /**
     * 对应属性就是 com.xingyun.custom.password
     */
    private String password;

    /**
     * Getter and Setter
     * @return
     */
    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
