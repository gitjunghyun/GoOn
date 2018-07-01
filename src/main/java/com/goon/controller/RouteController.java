package com.goon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.goon.domain.Route;
import com.goon.repository.RouteRepository;

@Controller
public class RouteController {

	@Autowired
	private RouteRepository routerepository;

	@PostMapping("/map/route")
	public String setroute(Route route) {
		routerepository.save(route);
		return "redirect:/";
	}

	// 탑승자 지도 화면
	@GetMapping("/map/psgmain")
	public String psgroute(Model model) {
		Route route = routerepository.findOne((long) 6);
		
		model.addAttribute("startX", route.getStartX());
		model.addAttribute("startY", route.getStartY());
		model.addAttribute("endX", route.getEndX());
		model.addAttribute("endY", route.getEndY());
		model.addAttribute("distance", route.getDistance());
		model.addAttribute("fee", route.getFee());
		model.addAttribute("time", route.getTime());
		
		return "/map/psgmain";
	}
}
