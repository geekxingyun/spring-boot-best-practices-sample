package com.xingyun.springbootwithswaggersample.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author qing-feng.zhao
 */
@Component
@Data
public class AppResponse {
    /**
     * 响应码
     */
    @ApiModelProperty(name = "responseCode",value = "",notes = "请求响应码")
    private Integer responseCode;
    /**
     * 响应消息
     */
    @ApiModelProperty(name = "responseMessage",value = "",notes = "请求响应消息")
    private String responseMessage;
    /**
     * 响应业务数据
     */
    @ApiModelProperty(name = "responseBusiness",value = "",notes = "请求响应业务数据")
    private Object responseBusiness;
}