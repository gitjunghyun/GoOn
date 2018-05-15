package com.goon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.goon.domain.Passenger;
import com.goon.repository.PassengerRepository;
import com.goon.service.PassengerTransaction;

@Controller
public class PassengerController {

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private PassengerTransaction passengerTransaction;

	@PostMapping("/join")
	public String join(Passenger passenger) {// create안에 인자를 다 넣으면 복잡해지므로 User클래스를추가해서 사용한다.
		passengerTransaction.setPassenger(passenger);
		passengerRepository.save(passenger);

		return "redirect:/email";
	}

	// 회원이 메일의 링크를 통해 접근하는 컨트롤러
	@GetMapping("/passenger/auth")
	public String auth(Passenger passenger) {
		passenger = passengerTransaction.getPassenger();
		passenger.setPsgAuth(1);
		passengerRepository.save(passenger);

		return "/passenger/auth";
	}

	// 추가 정보 입력페이지
	@GetMapping("/passenger/info")
	public String info() {
		return "/passenger/info";
	}
	
	@PostMapping("/test")
	public String info(Passenger psg) {
		Passenger passenger = passengerTransaction.getPassenger();
		passenger.setPsgGender(psg.getPsgGender());
		passenger.setPsgTell(psg.getPsgTell());
		passenger.setPsgPicture(psg.getPsgPicture());
		passengerRepository.save(passenger);
		return "/index";
	}

	// 사용자 목록 조회
	@GetMapping("/passenger/list")
	public String list(Model model) {
		model.addAttribute("users", passengerRepository.findAll());
		return "/passenger/list";
	}

	@GetMapping("/passenger/form")
	public String form() {
		return "/passenger/join";
	}
}
