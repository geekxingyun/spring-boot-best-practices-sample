package com.xingyun.springbootwithswaggersample.controller.api;

import com.xingyun.springbootwithswaggersample.model.AppResponse;
import com.xingyun.springbootwithswaggersample.model.UserQuery;
import com.xingyun.springbootwithswaggersample.model.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/v1")
@Api(value = "UserEndPoint", tags = "用户管理相关API")
@RestController
public class UserEndPoint {
    /**
     * 尽可能使用构造方法注入避免依赖注入空指针
     */
    private final AppResponse appResponse;

    public UserEndPoint(AppResponse appResponse) {
        this.appResponse = appResponse;
    }

    /**
     * 配置单个参数
     * @param usernameArg
     * @return
     */
    @ApiOperation(value="根据账号获取用户信息")
    @ApiImplicitParam(name = "username", value = "登录账号", required = true, dataType = "String")
    @GetMapping(value = "/user/{username}")
    public AppResponse groupOneTest(@PathVariable("username") String usernameArg){
        UserVO userVO=new UserVO();
        userVO.setUsername(usernameArg);
        userVO.setPassword("root");
        return this.appResponse;
    }

    /**
     * 配置多个参数
     * @param usernameArg
     * @param passwordArg
     * @return
     */
    @ApiOperation(value = "登录获取用户信息",notes ="获取当前用户登陆账号",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "登录账号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "登录密码", required = true, dataType = "String")
    })
    @PostMapping(value = "/user/login.do")
    public AppResponse loginMethod(@RequestParam(value = "username",required = false,defaultValue = "admin") String usernameArg,
                              @RequestParam(value = "password",required = false,defaultValue = "root") String passwordArg){
        UserVO userVO=new UserVO();
        userVO.setUsername(usernameArg);
        userVO.setPassword(passwordArg);
        this.appResponse.setResponseCode(200);
        this.appResponse.setResponseMessage("登陆成功");
        this.appResponse.setResponseBusiness(userVO);
        return this.appResponse;
    }

    /**
     * 当参数超过3个参数的时候推荐使用这种方式
     * @param userQuery
     * @return
     */
    @ApiOperation(value = "验证当前用户登陆账号",notes ="验证当前用户登陆账号",httpMethod = "GET")
    @PostMapping(value = "/user/check.do")
    public AppResponse checkMethod(@ModelAttribute UserQuery userQuery){
        this.appResponse.setResponseCode(200);
        this.appResponse.setResponseMessage("检查成功");
        this.appResponse.setResponseBusiness(userQuery);
        return this.appResponse;
    }
}
