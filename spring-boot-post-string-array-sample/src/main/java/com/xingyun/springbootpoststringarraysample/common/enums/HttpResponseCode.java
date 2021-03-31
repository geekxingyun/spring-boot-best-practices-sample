package com.xingyun.springbootpoststringarraysample.common.enums;

import lombok.Getter;

public enum HttpResponseCode {
    OK_SUCCESS(200,"请求成功"),
    INVALID_REQUEST_PARAM(401,"客户端请求参数出错"),
    NO_ACCESS(403,"无权限访问"),
    INVALID_REQUEST_TOKEN(514,"无效的Token"),
    SERVER_DATA_EXCEPTION(500,"数据异常");
    @Getter
    private Integer code;
    @Getter
    private String message;

    HttpResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
