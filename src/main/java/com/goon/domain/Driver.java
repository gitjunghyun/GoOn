package com.goon.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Driver")
public class Driver {

	@Id
	@GeneratedValue
	private Long Id;

	private String driName;
	private String driEmail;
	private String driPassword;

	// 이메일 인증 여부를 0과 1로 구분(인증 후 1로 변경)
	private int driAuth = 0;
	private String driGender;
	private String driTell;
	private String driJoinDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	private String driPicture;
	
	//운전자한테 필요한 정보 속성 추가하기!!!
	
	
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getDriName() {
		return driName;
	}
	public void setDriName(String driName) {
		this.driName = driName;
	}
	public String getDriEmail() {
		return driEmail;
	}
	public void setDriEmail(String driEmail) {
		this.driEmail = driEmail;
	}
	public String getDriPassword() {
		return driPassword;
	}
	public void setDriPassword(String driPassword) {
		this.driPassword = driPassword;
	}
	public int getDriAuth() {
		return driAuth;
	}
	public void setDriAuth(int driAuth) {
		this.driAuth = driAuth;
	}
	public String getDriGender() {
		return driGender;
	}
	public void setDriGender(String driGender) {
		this.driGender = driGender;
	}
	public String getDriTell() {
		return driTell;
	}
	public void setDriTell(String driTell) {
		this.driTell = driTell;
	}
	public String getDriJoinDate() {
		return driJoinDate;
	}
	public void setDriJoinDate(String driJoinDate) {
		this.driJoinDate = driJoinDate;
	}
	public String getDriPicture() {
		return driPicture;
	}
	public void setDriPicture(String driPicture) {
		this.driPicture = driPicture;
	}
	@Override
	public String toString() {
		return "Driver [Id=" + Id + ", driName=" + driName + ", driEmail=" + driEmail + ", driPassword=" + driPassword
				+ ", driAuth=" + driAuth + ", driGender=" + driGender + ", driTell=" + driTell + ", driJoinDate="
				+ driJoinDate + ", driPicture=" + driPicture + "]";
	}
}
