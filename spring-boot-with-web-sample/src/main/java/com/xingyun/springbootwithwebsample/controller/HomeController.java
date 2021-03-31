package com.xingyun.springbootwithwebsample.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author 技术宅星云
 */
@RestController
public class HomeController {

    /**
     * 最基础的拦截/ 返回字符串
     * @return
     */
    @GetMapping(value = "/")
    public String homePage(){
        return "Hello Home Page";
    }

    /**
     * 同时拦截多个URL
     * @return
     */
    @GetMapping(value = {"/hi.do","/hello.do"})
    public String helloPage(){
        return "Hello Page";
    }

    /**
     * 组合注解
     * @RequestMapping(value = "/test.do",method = RequestMethod.GET)
     * @GetMapping(value = "/test.do")组合注解，等价于上面这种写法
     * @return
     */
    @GetMapping(value = "/test.do")
    public String testPage(){
      return "Hello Test get Page";
    }

    /**
     * @RequestMapping(value = "/test2.do",method = RequestMethod.POST)
     * @PostMapping(value = "/test2.do")组合注解，等价于上面这种写法
     * @return
     */
    @PostMapping(value = "/test2.do")
    public String test2Page(){
      return "Hello Test post Page";
    }

    /**
     * 传统风格带参数的URL
     * 访问http://127.0.0.1:8080/url/b?id=18
     * @param uid
     * @return
     */
    @GetMapping(value = "/url/b")
    public String urlWithQuestion(@RequestParam(value = "id",required = false,defaultValue = "0") Integer uid) {
        return "Hello URL -----/url/b?id=" + uid;
    }

    /**
     * 访问http://127.0.0.1:8080/url/c.do
     * @param uid
     * @return
     */
    @PostMapping(value = "/url/c.do")
    public String urlWithQuestionPost(@RequestParam(value = "id",required = false,defaultValue = "0") Integer uid){
        return "Hello URL -----/url/c.do post:"+uid;
    }
    /**
     * Restful 风格带参数的URL
     * 访问http://127.0.0.1:8080/url/a/18
     * @param uid
     * @return
     */
    @GetMapping(value = "/url/a/{id}")
    public String urlWithParams(@PathVariable("id") Integer uid){
        return "Hello URL -----url/a/***------id="+uid;
    }
}
