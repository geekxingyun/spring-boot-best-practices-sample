package com.xingyun.springbootwithswaggersample.controller.api;

import com.xingyun.springbootwithswaggersample.model.AppResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author qing-feng.zhao
 */
@ApiIgnore
@RequestMapping(value = "/api/v1/")
@RestController
public class TestEndPoint {

    private final AppResponse appResponse;

    public TestEndPoint(AppResponse appResponse) {
        this.appResponse = appResponse;
    }

    @ApiIgnore
    @GetMapping(value = "/test-1.do")
    public AppResponse test1(){
        this.appResponse.setResponseCode(200);
        this.appResponse.setResponseMessage("测试一成功");
        this.appResponse.setResponseBusiness(null);
        return this.appResponse;
    }

    @GetMapping(value = "/test-2.do")
    public AppResponse test2(){
        this.appResponse.setResponseCode(200);
        this.appResponse.setResponseMessage("测试一成功");
        this.appResponse.setResponseBusiness(null);
        return this.appResponse;
    }
}
