package com.goon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
//	//뷰로 데이터 전달
//	@GetMapping("/test")
//	public String test(Model model) {
//		model.addAttribute("name", "이정현");
//		return "/test";
//	}

	//초기화면
	@GetMapping("/")
	public String index() {
		return "/index";
	}
}
