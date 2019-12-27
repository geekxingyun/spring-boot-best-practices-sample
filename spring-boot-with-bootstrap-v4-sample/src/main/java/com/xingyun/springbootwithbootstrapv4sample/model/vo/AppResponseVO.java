package com.xingyun.springbootwithbootstrapv4sample.model.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/12/27 19:03
 */
@Component
@Data
public class AppResponseVO {
    private Integer appResponseCode;
    private String appResponseMessage;
    private Object appResponseData;
}
