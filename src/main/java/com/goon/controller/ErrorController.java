package com.goon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
	
	//에러
	@GetMapping("/error")
	public String allerror() {
		return "/error";
	}
}
