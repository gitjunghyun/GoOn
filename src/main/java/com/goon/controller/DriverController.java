package com.goon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.goon.domain.Driver;
import com.goon.repository.DriverRepository;
import com.goon.service.DriverTransaction;
import com.goon.service.SmtpAuth;

@Controller
public class DriverController {

	@Autowired
	private SmtpAuth smtpAuth;
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private DriverTransaction driverTransaction;
	
	private Driver driver;
	
	// 이메일 회원가입폼
		@GetMapping("/driver/joinform")
		public String psgjoinform() {
			return "/driver/joinform";
		}

		// 이메일회원가입 DB연동 및 인증이메일 전송
		@PostMapping("/driver/join")
		public String psgjoin(Driver driver) {// create안에 인자를 다 넣으면 복잡해지므로 User클래스를추가해서 사용한다.
			driverTransaction.setDriver(driver);
			driverRepository.save(driver);

			smtpAuth.send(driver.getDriEmail());
			return "redirect:/driver/login";
		}

		// 이메일 인증 후 추가정보 입력페이지 및 이메일인증 DB연동
		@GetMapping("/driver/infoform")
		public String psginfoform() {
			driver = driverTransaction.getDriver();
			driver.setPsgAuth(1);
			driverRepository.save(driver);

			return "/driver/infoform";
		}

		// 추가정보 DB연동
		@PostMapping("/driver/joinmember")
		public String psginfo(Driver dri) {
			Driver driver = driverTransaction.getDriver();
			driver.setPsgGender(dri.getPsgGender());
			driver.setPsgTell(dri.getPsgTell());
			driver.setPsgPicture(dri.getPsgPicture());
			driverRepository.save(driver);
			return "redirect:/";
		}

		// 카카오계정으로 회원가입
		@PostMapping("/driver/kakaojoin")
		public String kakaojoin(Driver driver) {
			// 이미 데이터베이스에 등록되어있는 지 조건식 만들기
			if (true) {
				driverTransaction.setDriver(driver);
				driverRepository.save(driver);
				return "redirect:/driver/infoform";
			} else {
				return "redirect:/";
			}
		}

		// // 사용자 목록 조회
		// @GetMapping("/driver/list")
		// public String list(Model model) {
		// model.addAttribute("users", driverRepository.findAll());
		// return "/driver/list";
		// }

		// //현재 회원정보를 받아와 받아온 email로 메일 전송
		// @RequestMapping("/email")
		// public String sendMail() throws MessagingException {
		// driver = driverTransaction.getDriver();
		// smtpAuth.send(driver.getPsgEmail());
		// return "index";
		// }
}
