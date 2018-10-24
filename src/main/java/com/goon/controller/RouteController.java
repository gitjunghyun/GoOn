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

		for (int i = 1; i < 12; i++) {
			Route route = routerepository.findOne((long) i + 16);

			model.addAttribute("startX" + Integer.toString(i), route.getStartX());
			model.addAttribute("startY" + Integer.toString(i), route.getStartY());
			model.addAttribute("endX" + Integer.toString(i), route.getEndX());
			model.addAttribute("endY" + Integer.toString(i), route.getEndY());
			model.addAttribute("distance" + Integer.toString(i), route.getDistance());
			model.addAttribute("fee" + Integer.toString(i), route.getFee());
			model.addAttribute("time" + Integer.toString(i), route.getTime());
		}
		
		return "/map/psgmain";
	}
}
