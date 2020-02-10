package com.xingyun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 等价于 @Controller + 方法上加@ResponseBody
 * 默认请求控制器
 * @author qing-feng.zhao
 */
@RestController
public class HomeController {
	/**
	 * 当拦截到访问 http://127.0.0.1/8080 请求的时候执行这个方法
	 * @return 返回字符串
	 */
	@GetMapping(value="/")
	public String homePage() {
		return "Hello World";
	}
}
