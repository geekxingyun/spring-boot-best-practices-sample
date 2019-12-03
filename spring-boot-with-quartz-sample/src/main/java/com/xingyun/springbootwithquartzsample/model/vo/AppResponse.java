package com.xingyun.springbootwithquartzsample.model.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/12/2 23:05
 */
@Component
@Data
public class AppResponse {
    /**
     * 返回响应码
     */
    private Integer responseCode;
    /**
     * 返回响应消息
     */
    private String responseMessage;
    /**
     * 返回响应业务对象
     */
    private Object responseData;
}