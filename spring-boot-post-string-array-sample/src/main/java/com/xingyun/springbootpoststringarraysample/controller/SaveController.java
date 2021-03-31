package com.xingyun.springbootpoststringarraysample.controller;

import com.xingyun.springbootpoststringarraysample.model.VueElementAdminResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 * @description
 * @date 11/7/2019 10:41 PM
 */
@Slf4j
@RestController
public class SaveController {

    @PostMapping(value = "/save.do")
    public VueElementAdminResponse save(@RequestParam(value = "admin")String[] data){
        for (String item:data
             ) {
            log.info("接受到的数据:{}",item);
        }
        return VueElementAdminResponse.ok("提交成功",data);
    }
}
