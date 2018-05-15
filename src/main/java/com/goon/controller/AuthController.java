package com.goon.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goon.domain.Passenger;
import com.goon.service.PassengerTransaction;
import com.goon.service.SmtpAuth;

@Controller
public class AuthController {

	@Autowired
	private SmtpAuth smtpAuth;
	
	@Autowired
	private PassengerTransaction passengerTransaction;
	
	private Passenger passenger;

	//현재 회원정보를 받아와 받아온 email로 메일 전송
	@RequestMapping("/email")
	public String sendMail() throws MessagingException {
		passenger = passengerTransaction.getPassenger();
		smtpAuth.send(passenger.getPsgEmail(), "안녕하세요 GoOn입니다.");
		return "index";
	}
}