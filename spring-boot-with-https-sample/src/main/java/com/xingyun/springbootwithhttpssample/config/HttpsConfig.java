package com.xingyun.springbootwithhttpssample.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/12/15 10:34
 * https://www.cnblogs.com/garyyan/p/7600322.html
 */
@Configuration
public class HttpsConfig {

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        // HTTPS 连接器 监控80端口
        tomcatServletWebServerFactory.addAdditionalTomcatConnectors(http11NioConnector());
        // HTTP 连接器 监控8080端口
        tomcatServletWebServerFactory.addAdditionalTomcatConnectors(httpConnector());
        //AJP 连接器 监控8009端口
        tomcatServletWebServerFactory.addAdditionalTomcatConnectors(ajpConnector());
        return tomcatServletWebServerFactory;
    }


    /**
     * 拦截HTTP://127.0.0.1:80 端口的请求转发到443端口
     * 这种连接器有SSL证书
     * @return
     */
    @Bean
    public Connector http11NioConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        //Set the scheme that will be assigned to requests received through this connector
        //@param scheme The new scheme
        connector.setScheme("http");
        //Connector监听的http的端口号
        //Set the port number on which we listen for requests.
        // @param port The new port number
        connector.setPort(80);
        //Set the secure connection flag that will be assigned to requests received through this connector.
        //@param secure The new secure connection flag
        //if connector.setSecure(true),the http use the http and https use the https;else if connector.setSecure(false),the http redirect to https;
        connector.setSecure(false);
        //redirectPort The redirect port number (non-SSL to SSL)
        //监听到http的端口号后转向到的https的端口号
        connector.setRedirectPort(443);
        return connector;
    }


    /**
     * 拦截HTTP://127.0.0.1:8080 端口的请求转发到443端口
     * 这种连接器没有SSL证书
     * @return
     */
    @Bean
    public Connector httpConnector() {
        Connector connector = new Connector("HTTP/1.1");
        connector.setScheme("http");
        //Connector监听的http的端口号
        connector.setPort(8080);
        connector.setSecure(false);
        //监听到http的端口号后转向到的https的端口号
        connector.setRedirectPort(443);
        return connector;
    }

    /**
     * 拦截HTTP://127.0.0.1:8009 端口的请求转发到443端口
     * @return
     */
    @Bean
    public Connector ajpConnector() {
        Connector connector = new Connector("AJP/1.3");
        connector.setScheme("http");
        //Connector监听的http的端口号
        connector.setPort(8009);
        connector.setSecure(false);
        //监听到http的端口号后转向到的https的端口号
        connector.setRedirectPort(443);
        return connector;
    }
}
