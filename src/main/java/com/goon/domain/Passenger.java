package com.goon.domain;

import java.text.SimpleDateFormat;	
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Passenger")
@Data
public class Passenger {

	@Id
	@GeneratedValue
	private Long Id;

	private String PsgName;
	private String PsgEmail;
	private String PsgPassword;
	
	//이메일 인증 여부를 0과 1로 구분(인증 후 1로 변경)
	private int PsgAuth=0;
	private String PsgGender;
	private String PsgTell;
	private String PsgJoinDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	private String PsgPicture;
}