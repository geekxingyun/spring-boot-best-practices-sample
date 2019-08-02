package com.xingyun.springbootwithmybatisxmlsample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Component
public class AppResponse implements Serializable {
    private static final long serialVersionUID = 87358125982078357L;
    //响应返回码
    private Integer responseCode;
    //响应返回消息
    private String responseMessage;
    //响应返回数据
    private Object responseData;
}
