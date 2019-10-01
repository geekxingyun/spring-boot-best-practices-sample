package com.xingyun.springbootwitheasyshopsample.controller;

import com.xingyun.springbootwitheasyshopsample.model.dto.AppResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author 星云
 * @功能
 * @date 9/29/2019 8:14 AM
 */
@ApiIgnore
@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String home(){

        return "index";
    }
}
