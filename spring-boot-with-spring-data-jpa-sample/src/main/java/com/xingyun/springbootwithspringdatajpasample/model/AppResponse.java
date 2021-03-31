package com.xingyun.springbootwithspringdatajpasample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author 技术宅星云
 * @功能
 * @date 9/28/2019 10:27 PM
 */
@Getter
@Setter
@ToString
@Component
public class AppResponse {
    private Integer responseCode;
    private String responseMessage;
    private Object responseData;
}
