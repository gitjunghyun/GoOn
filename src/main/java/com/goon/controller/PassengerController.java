package com.goon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.goon.domain.Passenger;
import com.goon.repository.PassengerRepository;
import com.goon.service.PassengerService;

@Controller
public class PassengerController {

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private PassengerService passengerService;

	private Passenger passenger;

	// 이메일 회원가입폼
	@GetMapping("/passenger/joinform")
	public String psgjoinform() {
		return "/passenger/joinform";
	}

	// 이메일회원가입 DB연동 및 인증이메일 전송
	@PostMapping("/passenger/join")
	public String psgjoin(Passenger psg, HttpSession session) {// create안에 인자를 다 넣으면 복잡해지므로 User클래스를추가해서 사용한다.
		passenger = passengerRepository.findByPsgEmail(psg.getPsgEmail());

		if (passenger == null) {
			passengerRepository.save(psg);
			passengerService.send(psg.getPsgEmail());

			session.setAttribute("user", psg);
			session.setAttribute("email", psg.getPsgEmail());
			session.setAttribute("name", psg.getPsgName());

			return "redirect:/passenger/loginform";
		} else {
			// 이미 존재하는 이메일이라는 알림 페이지 만들기
			return "redirect:/";
		}
	}

	// 이메일 인증 후 추가정보 입력페이지 및 이메일인증 DB연동
	@GetMapping("/passenger/infoform")
	public String psginfoform(HttpSession session) {
		String email = (session.getAttribute("email")).toString();
		passenger = passengerRepository.findByPsgEmail(email);

		passenger.setPsgAuth(1);
		passengerRepository.save(passenger);

		return "/passenger/infoform";
	}

	// 추가정보 DB연동
	@PostMapping("/passenger/joinmember")
	public String psginfo(Passenger psg, HttpSession session) {
		String email = (session.getAttribute("email")).toString();
		passenger = passengerRepository.findByPsgEmail(email);

		passenger.setPsgAuth(1);
		passenger.setPsgGender(psg.getPsgGender());
		passenger.setPsgTell(psg.getPsgTell());
		passenger.setPsgPicture(psg.getPsgPicture());
		passengerRepository.save(passenger);
		return "redirect:/";
	}

	// 로그인
	@PostMapping("/passenger/login")
	public String psglogin(Passenger psg, HttpSession session) {
		passenger = passengerRepository.findByPsgEmail(psg.getPsgEmail());

		if (passenger == null) {
			return "/passenger/login";
		}
		if (!psg.getPsgPassword().equals(passenger.getPsgPassword())) {
			return "/passenger/login";
		}

		session.setAttribute("user", passenger);
		session.setAttribute("email", passenger.getPsgEmail());
		session.setAttribute("name", passenger.getPsgName());

		return "redirect:/";
	}

	// 카카오계정으로 회원가입
	@PostMapping("/passenger/kakaojoin")
	public String kakaojoin(Passenger psg, HttpSession session) {
		passenger = passengerRepository.findByPsgEmail(psg.getPsgEmail());

		if (passenger == null) {
			passengerRepository.save(psg);
			
			session.setAttribute("user", psg);
			session.setAttribute("email", psg.getPsgEmail());
			session.setAttribute("name", psg.getPsgName());
			
			return "redirect:/passenger/infoform";
		} else {
			session.setAttribute("user", passenger);
			session.setAttribute("email", passenger.getPsgEmail());
			session.setAttribute("name", passenger.getPsgName());
			
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
