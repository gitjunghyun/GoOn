package com.goon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.goon.domain.User;
import com.goon.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/create")
	public String create(User user) {// create안에 인자를 다 넣으면 복잡해지므로 User클래스를추가해서 사용한다.
		System.out.println("user:" + user);
		userRepository.save(user);
		return "index.html";

		// 회원가입 후 -> 홈페이지로 이동.

	}

	// 사용자 목록 맵핑
	@GetMapping("/user/list")
	public String list(Model model) {
		model.addAttribute("users", userRepository.findAll());// userRepository.findAll()을통해서 데이터를 불러와서 보여준다.
		return "/user/list";
	}
	
	@GetMapping("/user/form")
	public String form() {
		return "/user/form";
	}
	
	@GetMapping("/user/map")
	public String map() {
		return "/user/google";
	}
}
