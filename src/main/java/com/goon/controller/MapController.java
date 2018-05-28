package com.goon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

	// 지도 표시
	@GetMapping("/map/main")
	public String map() {
		return "/map/main";
	}

	// 지도 표시
	@GetMapping("/map/marker")
	public String marker() {
		return "/map/marker";
	}

	// 지도 표시
	@GetMapping("/map/infowindow")
	public String infowindow() {
		return "/map/infowindow";
	}
}
