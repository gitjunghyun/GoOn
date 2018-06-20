package com.goon.controller;

import org.springframework.stereotype.Controller;	
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MapController {

	// 메인 지도 화면
	@GetMapping("/map/main")
	public String main() {
		return "/map/main";
	}
	
//	// test
//	@GetMapping("/map/google")
//	public String googleee() {
//		return "/map/google";
//	}

//	// test
//	@GetMapping("/map/test")
//	public String maptest() {
//		return "/map/test";
//	}
//
//	// 설정한 경로 표시
//	@PostMapping("/map/result")
//	public String mapresult(String start, String destination, Model model) {
//		model.addAttribute("start", start);
//		model.addAttribute("destination", destination);
//		return "/map/result";
//	}
}
