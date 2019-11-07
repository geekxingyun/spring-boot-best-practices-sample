package com.xingyun.springbootpoststringarraysample.model;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author qing-feng.zhao
 * @description
 * @date 11/7/2019 10:42 PM
 */
@Data
@Component
public class AppResponse {
    private Integer responseCode;
    private String responseMessage;
    private Object object;
}
