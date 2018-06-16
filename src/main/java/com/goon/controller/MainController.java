package com.goon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	// 테스트
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("name", "이정현");
		return "/test";
	}

	// 메인화면
	@GetMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "/index";
		} else {
			return "/map/test"; //////////////////////////// 여기 작업필요!
		}
	}

	// 탑승객 로그인
	@GetMapping("/passenger/loginform")
	public String psg_login() {
		return "/passenger/login";
	}

	// 운전자 로그인
	@GetMapping("/driver/loginform")
	public String dri_login() {
		return "/driver/login";
	}
}
