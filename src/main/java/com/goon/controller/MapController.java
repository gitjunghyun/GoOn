package com.goon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MapController {

	// 지도 표시
	@GetMapping("/map/main")
	public String map() {
		return "/map/main";
	}

	// 설정한 경로 표시
	@PostMapping("/map/route")
	public String maproute(String stLat, String stLng, String deLat, String deLng, Model model) {
		model.addAttribute("stLat", stLat);
		model.addAttribute("stLng", stLng);
		model.addAttribute("deLat", deLat);
		model.addAttribute("deLng", deLng);
		return "/map/route";
	}
}
