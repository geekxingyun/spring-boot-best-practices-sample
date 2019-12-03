package com.xingyun.springbootwithquartzsample.controller.api;

import com.xingyun.springbootwithquartzsample.model.vo.AppResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 * @功能 首页访问
 */
@RestController
public class HomeController {
    /**
     * 构造方法注入
     */
    private final AppResponse appResponse;

    public HomeController(AppResponse appResponse){
        this.appResponse=appResponse;
    }

    @GetMapping(value = "/")
    public AppResponse home(){
        appResponse.setResponseCode(200);
        appResponse.setResponseMessage("Hello World");
        appResponse.setResponseData(null);
        return appResponse;
    }
}
