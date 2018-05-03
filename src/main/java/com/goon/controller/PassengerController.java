package com.goon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.goon.domain.Passenger;
import com.goon.repository.PassengerRepository;

@Controller
public class PassengerController {

	@Autowired
	private PassengerRepository passengerRepository;
	
	@PostMapping("/join")
	public String join(Passenger passenger) {// create안에 인자를 다 넣으면 복잡해지므로 User클래스를추가해서 사용한다.
		passenger.toString();
		passengerRepository.save(passenger);
		return "redirect:/";

		// 회원가입 후 -> 홈페이지로 이동.

	}
	
	@GetMapping("/error")
	public String error() {
		return "/error";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("name", "이정현");
		return "passenger/test";
	}

	//초기화면
	@GetMapping("/")
	public String index() {
		return "/index";
	}
	
	// 사용자 목록 맵핑
	@GetMapping("/passenger/list")
	public String list(Model model) {
		model.addAttribute("users", passengerRepository.findAll());// userRepository.findAll()을통해서 데이터를 불러와서 보여준다.
		return "/passenger/list";
	}
	
	@GetMapping("/passenger/form")
	public String form() {
		return "/passenger/psg_join";
	}
	
	@GetMapping("/map")
	public String map() {
		return "/passenger/google";
	}
}
