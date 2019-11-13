package com.xingyun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 默认请求页面控制器
 * @author qing-feng.zhao
 */
@RestController
public class HomeController {

	@GetMapping(value="/")
	public String homePage() {
		return "Hello World";
	}
}
