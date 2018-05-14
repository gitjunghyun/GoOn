package com.goon.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goon.domain.Passenger;
import com.goon.service.PassengerTransaction;
import com.goon.service.SmtpMailSender;

@Controller
public class MailController {

	@Autowired
	private SmtpMailSender smtpMailSender;
	
	
	private Passenger passenger;
	
	@Autowired
	private PassengerTransaction passengerTransaction;

	@RequestMapping("/email")
	public String sendMail() throws MessagingException {
		passenger = passengerTransaction.getA();
		
		smtpMailSender.send(passenger.getPsgEmail(), "제목");
		return "index";
	}
}
