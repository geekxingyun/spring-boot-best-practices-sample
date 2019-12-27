package com.xingyun.springbootwithbootstrapv4sample.controller.api;

import com.xingyun.springbootwithbootstrapv4sample.model.vo.AppResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/12/27 19:02
 */
@RestController
public class MessageController {

    final AppResponseVO appResponseVO;

    public MessageController(AppResponseVO appResponseVO) {
        this.appResponseVO = appResponseVO;
    }

    @ApiOperation(value = "显示测试消息API")
    @GetMapping(value = "/message.do")
    public AppResponseVO showMessage(){
        appResponseVO.setAppResponseCode(200);
        appResponseVO.setAppResponseMessage("Hello World!");
        appResponseVO.setAppResponseData(null);
        return appResponseVO;
    }
}
