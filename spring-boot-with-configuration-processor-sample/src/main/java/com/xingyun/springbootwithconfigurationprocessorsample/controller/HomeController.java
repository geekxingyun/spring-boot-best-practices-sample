package com.xingyun.springbootwithconfigurationprocessorsample.controller;

import com.xingyun.springbootwithconfigurationprocessorsample.customize.properties.MyCustomProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 */
@Slf4j
@RestController
public class HomeController {

    /**
     * Spring 今后推荐使用构造方法注入
     */
    public final MyCustomProperties myCustomProperties;
    public HomeController(MyCustomProperties myCustomProperties) {
        this.myCustomProperties = myCustomProperties;
    }

    /**
     * 拦截首页 / 请求
     * @return
     */
    @GetMapping(value = "/")
    public String homePage(){
        return "Hello World";
    }

    /**
     * 测试自定义属性调用 值得注意的是只能实例方法调用,静态方法不可调用
     * @return
     */
    @GetMapping(value = "/test.do")
    public String testCustomProperties(){
        log.debug("自定义属性测试使用开始");
        log.debug("server address:{}",myCustomProperties.getServerAddress());
        log.debug("port:{}",myCustomProperties.getPort());
        log.debug("username:{}",myCustomProperties.getUsername());
        log.debug("password:{}",myCustomProperties.getPassword());
        log.debug("自定义属性测试使用结束");
        return "test success,please check log from console";
    }
}
