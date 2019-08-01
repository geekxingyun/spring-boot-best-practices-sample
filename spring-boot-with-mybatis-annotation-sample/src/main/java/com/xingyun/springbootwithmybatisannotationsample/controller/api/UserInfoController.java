package com.xingyun.springbootwithmybatisannotationsample.controller.api;

import com.xingyun.springbootwithmybatisannotationsample.model.AppResponse;
import com.xingyun.springbootwithmybatisannotationsample.model.business.UserInfo;
import com.xingyun.springbootwithmybatisannotationsample.service.IUserInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserInfoController {

    @Autowired
    AppResponse appResponse;

    @Autowired
    IUserInfo userInfoService;

    @Autowired
    UserInfo userInfo;

    @ApiOperation(value="添加一个用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userInfoName", value = "用户名称", defaultValue = "星云",required = true, dataType = "String"),
            @ApiImplicitParam(name = "userInfoMobile", value = "用户手机号",defaultValue = "18317792386",required = true, dataType = "String"),
            @ApiImplicitParam(name = "userInfoAge",value = "年龄",defaultValue="27",dataType = "Integer",dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "userInfoSex", value = "用户性别",defaultValue = "true",required = true, dataType = "Boolean"),
    })
    @PostMapping(value = "/userInfo")
    public AppResponse addUserInfo(
                @RequestParam(value = "userInfoName")String userInfoName,
                @RequestParam(value = "userInfoMobile")String userInfoMobile,
                @RequestParam(value = "userInfoAge")Integer userInfoAge,
                @RequestParam(value = "userInfoSex")Boolean userInfoSex){

        userInfo.setUserInfoName(userInfoName);
        userInfo.setUserInfoMobile(userInfoMobile);
        userInfo.setUserInfoAge(userInfoAge);
        userInfo.setUserInfoSex(userInfoSex);

        Integer effectLineCount=Integer.valueOf(0);
        try {
            effectLineCount=userInfoService.addUserInfo(userInfo);
        } catch (Exception e) {
            log.error("插入用户信息出错",e);
            appResponse.setResponseCode(500);
            appResponse.setResponseMessage("用户插入失败");
            appResponse.setResponseData(null);
            return appResponse;
        }

        if(0!=effectLineCount){
            appResponse.setResponseCode(200);
            appResponse.setResponseMessage("用户插入成功");
            appResponse.setResponseData(null);
            return appResponse;
        }else{
            appResponse.setResponseCode(500);
            appResponse.setResponseMessage("用户插入失败");
            appResponse.setResponseData(null);
            return appResponse;
        }
    }


    @ApiOperation(value="删除一个用户信息")
    @ApiImplicitParam(name = "userInfoId",required = true, defaultValue = "1",dataType = "Long",example = "1")
    @DeleteMapping(value = "/userInfo/{userInfoId}")
    public AppResponse removedUserInfo(@PathVariable(value = "userInfoId")Long userInfoId){

        int resultCode=0;
        try {
            resultCode=userInfoService.removedUserInfoByUserInfoId(userInfoId);
        } catch (Exception e) {
            log.error("删除用户信息出错",e);
            appResponse.setResponseCode(500);
            appResponse.setResponseMessage("用户删除失败");
            appResponse.setResponseData(null);
            return appResponse;
        }
        if(0!=resultCode){
            appResponse.setResponseCode(200);
            appResponse.setResponseMessage("用户删除成功");
            appResponse.setResponseData(null);
            return appResponse;
        }else{
            appResponse.setResponseCode(500);
            appResponse.setResponseMessage("用户删除失败");
            appResponse.setResponseData(null);
            return appResponse;
        }
    }

    @ApiOperation(value="修改一个用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userInfoId", value = "用户Id", defaultValue = "2",required = true, dataType = "Long",example = "2"),
            @ApiImplicitParam(name = "userInfoName", value = "用户名称", defaultValue = "星云",required = true, dataType = "String"),
            @ApiImplicitParam(name = "userInfoMobile", value = "用户手机号",defaultValue = "18317792386",required = true, dataType = "String"),
            @ApiImplicitParam(name = "userInfoAge",value = "年龄",defaultValue="27",dataType = "Integer",dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "userInfoSex", value = "用户性别",defaultValue = "true",required = true, dataType = "Boolean"),
    })
    @PutMapping(value = "/userInfo")
    public AppResponse modifyUserInfo(
                                  @RequestParam(value = "userInfoId")Long userInfoId,
                                  @RequestParam(value = "userInfoName")String userInfoName,
                                  @RequestParam(value = "userInfoMobile")String userInfoMobile,
                                  @RequestParam(value = "userInfoAge")Integer userInfoAge,
                                  @RequestParam(value = "userInfoSex")Boolean userInfoSex
    ){

        userInfo.setUserInfoId(userInfoId);
        userInfo.setUserInfoName(userInfoName);
        userInfo.setUserInfoMobile(userInfoMobile);
        userInfo.setUserInfoAge(userInfoAge);
        userInfo.setUserInfoSex(userInfoSex);

        UserInfo findUserInfo=null;
        try {
            findUserInfo=userInfoService.findUserInfoByUserInfoId(userInfoId);
        } catch (Exception e) {
            log.error("根据用户Id查询用户出错",e);
        }
        if(null==findUserInfo){
            appResponse.setResponseCode(200);
            appResponse.setResponseMessage("用户ID不正确,不存在当前用户");
            appResponse.setResponseData(null);
            return appResponse;
        }else{
            Integer resultCode= Integer.valueOf(0);
            try {
                resultCode=userInfoService.modifyUserInfo(userInfo);
            } catch (Exception e) {
                log.error("修改用户信息出错",e);
                appResponse.setResponseCode(500);
                appResponse.setResponseMessage("查询用户信息出错");
                appResponse.setResponseData(null);
                return appResponse;
            }
            if(resultCode!=0){
                appResponse.setResponseCode(200);
                appResponse.setResponseMessage("修改用户信息成功");
                appResponse.setResponseData(null);
                return appResponse;
            }else{
                appResponse.setResponseCode(500);
                appResponse.setResponseMessage("修改用户信息失败");
                appResponse.setResponseData(null);
                return appResponse;
            }
        }
    }

    @ApiOperation(value="查看某一用户信息")
    @ApiImplicitParam(name = "userInfoId",required = true, dataType = "Long",example = "1")
    @GetMapping(value = "/userInfo/{userInfoId}")
    public AppResponse findUserInfoByUserInfoId(@PathVariable(value = "userInfoId")Long userInfoId){
        UserInfo findUserInfo= null;
        try {
            findUserInfo = userInfoService.findUserInfoByUserInfoId(userInfoId);
        } catch (Exception e) {
            log.error("获取用户信息出错",e);
            appResponse.setResponseCode(201);
            appResponse.setResponseMessage("查询用户信息出错");
            appResponse.setResponseData(null);
        }
        if(null!=findUserInfo){
            appResponse.setResponseCode(200);
            appResponse.setResponseMessage("获取用户信息成功");
            appResponse.setResponseData(findUserInfo);
        }else{
            appResponse.setResponseCode(201);
            appResponse.setResponseMessage("未找到该用户");
            appResponse.setResponseData(null);
        }
        return appResponse;
    }

    @ApiOperation(value="查看所有用户信息")
    @GetMapping(value = "/userInfo")
    public AppResponse findAllUserInfo(){
        List<UserInfo> userInfoList;
        try {
            userInfoList=userInfoService.findAllUserInfo();
        } catch (Exception e) {
            log.error("获取所有用户信息出错:",e);
            appResponse.setResponseCode(500);
            appResponse.setResponseMessage("查看所有用户信息出错");
            appResponse.setResponseData(null);
            return appResponse;
        }
        if(null!=userInfoList&&userInfoList.size()>0){
            appResponse.setResponseCode(200);
            appResponse.setResponseMessage("查看所有用户信息成功");
            appResponse.setResponseData(userInfoList);
            return appResponse;
        }else{
            appResponse.setResponseCode(201);
            appResponse.setResponseMessage("未找到相关用户信息");
            appResponse.setResponseData(null);
            return appResponse;
        }
    }
}
