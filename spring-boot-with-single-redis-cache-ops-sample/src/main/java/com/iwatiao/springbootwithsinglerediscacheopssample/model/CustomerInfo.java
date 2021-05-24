package com.iwatiao.springbootwithsinglerediscacheopssample.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qing-feng.zhao
 */
@Data
public class CustomerInfo implements Serializable {
    private String uid;
    private String devId;
    private String token;
    private String nickName;
}
