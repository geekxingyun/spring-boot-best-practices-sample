package com.xingyun.springbootwithlogback.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 */
@RestController
public class HomeController {

	@GetMapping(value="/")
	public String homePage() {
		return "Welcome to use Logging Test Application";
	}
}
