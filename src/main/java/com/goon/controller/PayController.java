package com.goon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PayController {

	@PostMapping("/pay/kakaopay")
	public String pay(String fee, Model model) {
		model.addAttribute("fee", fee);
		return "/pay/kakaopay";
	}
}
