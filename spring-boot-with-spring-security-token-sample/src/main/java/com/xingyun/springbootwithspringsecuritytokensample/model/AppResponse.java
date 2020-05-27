package com.xingyun.springbootwithspringsecuritytokensample.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
/**
 * @author qing-feng.zhao
 */
@Component
@Data
public class AppResponse implements Serializable {
    private static final long serialVersionUID = -5505769885729946052L;
    @ApiModelProperty(name = "responseCode",value = "响应码")
    private Integer responseCode;
    @ApiModelProperty(name = "responseMessage",value = "响应消息")
    private String responseMessage;
    @ApiModelProperty(name = "responseData",value = "响应数据")
    private Object responseData;
}
