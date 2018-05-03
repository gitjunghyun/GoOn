package com.goon.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goon.service.SmtpMailSender;

@Controller
public class MailController {

	@Autowired
	private SmtpMailSender smtpMailSender;

	@RequestMapping("/email")
	public String sendMail() throws MessagingException {
		smtpMailSender.send("leeu4728@naver.com", "제목", "HI");
		return "index";
	}
}
