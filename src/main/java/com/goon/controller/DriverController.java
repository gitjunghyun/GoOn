package com.goon.controller;

import javax.servlet.http.HttpSession;	

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.goon.domain.Driver;
import com.goon.domain.Passenger;
import com.goon.repository.DriverRepository;
import com.goon.service.DriverService;

@Controller
public class DriverController {
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private DriverService driverService;
	
	private Driver driver;
	
	// 이메일 회원가입폼
		@GetMapping("/driver/joinform")
		public String psgjoinform() {
			return "/driver/joinform";
		}

		// 이메일회원가입 DB연동 및 인증이메일 전송
		@PostMapping("/driver/join")
		public String psgjoin(Driver dri, HttpSession session) {// create안에 인자를 다 넣으면 복잡해지므로 User클래스를추가해서 사용한다.
			driver = driverRepository.findByDriEmail(dri.getDriEmail());

			if (driver == null) {
				driverRepository.save(dri);
				driverService.send(dri.getDriEmail());

				session.setAttribute("user", dri);
				session.setAttribute("email", dri.getDriEmail());
				session.setAttribute("name", dri.getDriName());
				
				return "redirect:/driver/loginform";
			} else {
				// 이미 존재하는 이메일이라는 알림 페이지 만들기
				return "redirect:/";
			}
		}

		// 이메일 인증 후 추가정보 입력페이지 및 이메일인증 DB연동
		@GetMapping("/driver/infoform")
		public String psginfoform(HttpSession session) {
			String email = (session.getAttribute("email")).toString();
			driver = driverRepository.findByDriEmail(email);

			driver.setDriAuth(1);
			driverRepository.save(driver);

			return "/driver/infoform";
		}

		// 추가정보 DB연동
		@PostMapping("/driver/joinmember")
		public String psginfo(Driver dri, HttpSession session) {
			String email = (session.getAttribute("email")).toString();
			driver = driverRepository.findByDriEmail(email);
			
			driver.setDriAuth(1);
			driver.setDriGender(dri.getDriGender());
			driver.setDriTell(dri.getDriTell());
			driver.setDriPicture(dri.getDriPicture());
			driverRepository.save(driver);
			return "redirect:/";
		}

		// 로그인
		@PostMapping("/driver/login")
		public String drilogin(Driver dri, HttpSession session) {
			driver = driverRepository.findByDriEmail(dri.getDriEmail());

			if (driver == null) {
				return "/driver/login";
			}
			if (!dri.getDriPassword().equals(driver.getDriPassword())) {
				return "/driver/login";
			}

			session.setAttribute("user", driver);
			session.setAttribute("email", driver.getDriEmail());
			session.setAttribute("name", driver.getDriName());

			return "redirect:/";
		}
		
		// 카카오계정으로 회원가입
		@PostMapping("/driver/kakaojoin")
		public String kakaojoin(Driver dri, HttpSession session) {
			driver = driverRepository.findByDriEmail(dri.getDriEmail());
			
			if (driver == null) {
				driverRepository.save(driver);
				
				session.setAttribute("user", dri);
				session.setAttribute("email", dri.getDriEmail());
				session.setAttribute("name", dri.getDriName());
				
				return "redirect:/driver/infoform";
			} else {
				session.setAttribute("user", driver);
				session.setAttribute("email", driver.getDriEmail());
				session.setAttribute("name", driver.getDriName());
				
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
