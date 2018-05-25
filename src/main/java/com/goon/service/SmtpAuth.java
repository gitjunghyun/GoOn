package com.goon.service;

import javax.mail.MessagingException;	
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SmtpAuth {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void send(String to) {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		// 보내는 메일 내용
		String body = "<a href=\"http://210.123.254.134:8080/passenger/infoform\">ㅇ!ㅈ!</a>";
		String subject = "안녕하세요 GoOn입니다.";
		
		try {
			helper = new MimeMessageHelper(message,true);
			
			helper.setSubject(subject);
			helper.setTo(to);
			helper.setText(body,true);
			
			javaMailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
