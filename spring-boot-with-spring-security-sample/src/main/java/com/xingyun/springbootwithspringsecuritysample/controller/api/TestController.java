package com.xingyun.springbootwithspringsecuritysample.controller.api;

import com.xingyun.springbootwithspringsecuritysample.model.vo.AppResponse;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 * @description 测试API 控制器
 * @date 2019/12/3 20:15
 */
@RequestMapping(value = "/api/v1")
@Api(tags = "系统测试API")
@RestController
public class TestController {

    private final AppResponse appResponse;

    public TestController(AppResponse appResponse) {
        this.appResponse = appResponse;
    }

    @GetMapping(value = "/test.do")
    public AppResponse test(){
        appResponse.setResponseCode(200);
        appResponse.setResponseMessage("请求成功");
        appResponse.setResponseData(null);
        return appResponse;
    }
}
