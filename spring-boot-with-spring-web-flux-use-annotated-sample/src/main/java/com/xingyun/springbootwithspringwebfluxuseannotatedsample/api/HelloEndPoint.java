package com.xingyun.springbootwithspringwebfluxuseannotatedsample.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 */
@RestController
public class HelloEndPoint {

    public static final String ECHO_HELLO_MESSAGE="Hello World, Spring!";

    @GetMapping(value = "/hello")
    public String hello(){
        return ECHO_HELLO_MESSAGE;
    }
}
