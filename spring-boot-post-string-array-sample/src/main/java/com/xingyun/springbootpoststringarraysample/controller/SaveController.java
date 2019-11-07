package com.xingyun.springbootpoststringarraysample.controller;

import com.xingyun.springbootpoststringarraysample.model.AppResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 * @description
 * @date 11/7/2019 10:41 PM
 */
@RestController
public class SaveController {

    @Autowired
    AppResponse appResponse;

    @PostMapping(value = "/save.do")
    public AppResponse save(@RequestParam(value = "admin")String[] data){
        appResponse.setResponseCode(200);
        appResponse.setResponseMessage("提交成功");
        appResponse.setObject(data);
        return appResponse;
    }
}
