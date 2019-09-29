package com.xingyun.springbootwitheasyshopsample.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author 星云
 * @功能
 * @date 9/26/2019 9:34 PM
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
