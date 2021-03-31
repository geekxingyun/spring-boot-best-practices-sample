package com.xingyun.springbootpoststringarraysample.model;

import com.xingyun.springbootpoststringarraysample.common.enums.HttpResponseCode;
import lombok.Data;

/**
 * @author qing-feng.zhao
 */
@Data
public class VueElementAdminResponse {
    private Integer code;
    private String message;
    private Object data;

    public static VueElementAdminResponse ok(String message,Object object) {
        VueElementAdminResponse httpResult = new VueElementAdminResponse();
        httpResult.setCode(HttpResponseCode.OK_SUCCESS.getCode());
        httpResult.setMessage(message);
        httpResult.setData(object);
        return httpResult;
    }

    public static VueElementAdminResponse invalidParam(String message,Object object) {
        VueElementAdminResponse httpResult = new VueElementAdminResponse();
        httpResult.setCode(HttpResponseCode.INVALID_REQUEST_PARAM.getCode());
        httpResult.setMessage(message);
        httpResult.setData(object);
        return httpResult;
    }

    public static VueElementAdminResponse noAccess() {
        VueElementAdminResponse httpResult = new VueElementAdminResponse();
        httpResult.setCode(HttpResponseCode.NO_ACCESS.getCode());
        httpResult.setMessage(HttpResponseCode.NO_ACCESS.getMessage());
        httpResult.setData(null);
        return httpResult;
    }

    public static VueElementAdminResponse invalidToken() {
        VueElementAdminResponse httpResult = new VueElementAdminResponse();
        httpResult.setCode(HttpResponseCode.INVALID_REQUEST_TOKEN.getCode());
        httpResult.setMessage(HttpResponseCode.INVALID_REQUEST_TOKEN.getMessage());
        httpResult.setData(null);
        return httpResult;
    }

    public static VueElementAdminResponse error(String msg,Object object) {
        VueElementAdminResponse httpResult = new VueElementAdminResponse();
        httpResult.setCode(HttpResponseCode.SERVER_DATA_EXCEPTION.getCode());
        httpResult.setMessage(msg);
        httpResult.setData(object);
        return httpResult;
    }
}
