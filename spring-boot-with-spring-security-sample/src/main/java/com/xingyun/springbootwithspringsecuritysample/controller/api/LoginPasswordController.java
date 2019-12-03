package com.xingyun.springbootwithspringsecuritysample.controller.api;

import com.xingyun.springbootwithspringsecuritysample.model.vo.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 * @description 登录密码加密密文生成服务
 * @date 2019/12/3 0:11
 */
@RequestMapping(value = "/api/v1")
@Api(tags = "登录密码加密密文生成服务")
@Slf4j
@RestController
public class LoginPasswordController {

    /**
     * Spring 建议使用构造方法注入
     */
    private final AppResponse appResponse;

    public LoginPasswordController(AppResponse appResponse) {
        this.appResponse = appResponse;
    }

    @GetMapping(value = "/encryptPassword.do")
    @ApiOperation(value="密码加密API")
    @ApiImplicitParam(name ="originPassword",value = "原始明文密码",example = "123456")
    public AppResponse encryptPassword(@RequestParam(value = "originPassword")String originPassword){

        log.info("原始明文密码是:{}",originPassword);
        String encryptPassword;
        try {
            encryptPassword = new BCryptPasswordEncoder().encode(originPassword);
            log.info("加密后密码是:{}",encryptPassword);
            appResponse.setResponseCode(200);
            appResponse.setResponseMessage("密码加密成功");
            appResponse.setResponseData(encryptPassword);
        } catch (Exception e) {
            log.error("{}明文密码加密出错:",originPassword,e);
            appResponse.setResponseCode(500);
            appResponse.setResponseMessage("密码加密失败");
            appResponse.setResponseData(e);
        }
        return appResponse;
    }
}
