package com.goon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.goon.domain.Passenger;
import com.goon.repository.PassengerRepository;
import com.goon.service.PassengerTransaction;
import com.goon.service.SmtpAuth;

@Controller
public class PassengerController {

	@Autowired
	private SmtpAuth smtpAuth;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private PassengerTransaction passengerTransaction;

	private Passenger passenger;

	// 이메일 회원가입폼
	@GetMapping("/passenger/joinform")
	public String psgjoinform() {
		return "/passenger/joinform";
	}

	// 이메일회원가입 DB연동 및 인증이메일 전송
	@PostMapping("/passenger/join")
	public String psgjoin(Passenger passenger) {// create안에 인자를 다 넣으면 복잡해지므로 User클래스를추가해서 사용한다.
		passengerTransaction.setPassenger(passenger);
		passengerRepository.save(passenger);

		smtpAuth.send(passenger.getPsgEmail());
		return "redirect:/passenger/login";
	}

	// 이메일 인증 후 추가정보 입력페이지 및 이메일인증 DB연동
	@GetMapping("/passenger/infoform")
	public String psginfoform() {
		passenger = passengerTransaction.getPassenger();
		passenger.setPsgAuth(1);
		passengerRepository.save(passenger);

		return "/passenger/infoform";
	}

	// 추가정보 DB연동
	@PostMapping("/passenger/joinmember")
	public String psginfo(Passenger psg) {
		Passenger passenger = passengerTransaction.getPassenger();
		passenger.setPsgGender(psg.getPsgGender());
		passenger.setPsgTell(psg.getPsgTell());
		passenger.setPsgPicture(psg.getPsgPicture());
		passengerRepository.save(passenger);
		return "redirect:/";
	}

	// 카카오계정으로 회원가입
	@PostMapping("/passenger/kakaojoin")
	public String kakaojoin(Passenger passenger) {
		// 이미 데이터베이스에 등록되어있는 지 조건식 만들기
		if (true) {
			passengerTransaction.setPassenger(passenger);
			passengerRepository.save(passenger);
			return "redirect:/passenger/infoform";
		} else {
			return "redirect:/";
		}
	}

	// // 사용자 목록 조회
	// @GetMapping("/passenger/list")
	// public String list(Model model) {
	// model.addAttribute("users", passengerRepository.findAll());
	// return "/passenger/list";
	// }

	// //현재 회원정보를 받아와 받아온 email로 메일 전송
	// @RequestMapping("/email")
	// public String sendMail() throws MessagingException {
	// passenger = passengerTransaction.getPassenger();
	// smtpAuth.send(passenger.getPsgEmail());
	// return "index";
	// }
}
