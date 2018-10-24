package com.goon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PayController {

	@PostMapping("/pay/kakaopay")
	public String pay(int cnt, String fee1, String fee2, String fee3, String fee4, String fee5, String fee6,
			String fee7, String fee8, String fee9, String fee10, String fee11, Model model) {
		switch (cnt) {
		case 1:
			model.addAttribute("fee", fee1);
			break;
		case 2:
			model.addAttribute("fee", fee2);
			break;
		case 3:
			model.addAttribute("fee", fee3);
			break;
		case 4:
			model.addAttribute("fee", fee4);
			break;
		case 5:
			model.addAttribute("fee", fee5);
			break;
		case 6:
			model.addAttribute("fee", fee6);
			break;
		case 7:
			model.addAttribute("fee", fee7);
			break;
		case 8:
			model.addAttribute("fee", fee8);
			break;
		case 9:
			model.addAttribute("fee", fee9);
			break;
		case 10:
			model.addAttribute("fee", fee10);
			break;
		case 11:
			model.addAttribute("fee", fee11);
			break;
		}
		return "/pay/kakaopay";
	}
}
