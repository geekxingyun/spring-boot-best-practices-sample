package com.xingyun.springbootwithspringsecuritysample.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/12/2 23:05
 */
@Component
@Getter
@Setter
@ToString
public class AppResponse {
    /**
     * 返回响应码
     */
    @ApiModelProperty(name = "responseCode",value = "responseCode",example = "请求响应码")
    private Integer responseCode;
    /**
     * 返回响应消息
     */
    @ApiModelProperty(name = "responseMessage",value = "responseMessage",example = "请求响应成功")
    private String responseMessage;
    /**
     * 返回响应业务对象
     */
    private Object responseData;
}
