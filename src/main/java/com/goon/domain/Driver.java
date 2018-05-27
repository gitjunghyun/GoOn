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

	private String DriName;
	private String DriEmail;
	private String DriPassword;

	// 이메일 인증 여부를 0과 1로 구분(인증 후 1로 변경)
	private int DriAuth = 0;
	private String DriGender;
	private String DriTell;
	private String DriJoinDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	private String DriPicture;
	
	//운전자한테 필요한 정보 속성 추가하기!!!
	
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getDriName() {
		return DriName;
	}
	public void setDriName(String driName) {
		DriName = driName;
	}
	public String getDriEmail() {
		return DriEmail;
	}
	public void setDriEmail(String driEmail) {
		DriEmail = driEmail;
	}
	public String getDriPassword() {
		return DriPassword;
	}
	public void setDriPassword(String driPassword) {
		DriPassword = driPassword;
	}
	public int getDriAuth() {
		return DriAuth;
	}
	public void setDriAuth(int driAuth) {
		DriAuth = driAuth;
	}
	public String getDriGender() {
		return DriGender;
	}
	public void setDriGender(String driGender) {
		DriGender = driGender;
	}
	public String getDriTell() {
		return DriTell;
	}
	public void setDriTell(String driTell) {
		DriTell = driTell;
	}
	public String getDriJoinDate() {
		return DriJoinDate;
	}
	public void setDriJoinDate(String driJoinDate) {
		DriJoinDate = driJoinDate;
	}
	public String getDriPicture() {
		return DriPicture;
	}
	public void setDriPicture(String driPicture) {
		DriPicture = driPicture;
	}
	
	@Override
	public String toString() {
		return "Driver [Id=" + Id + ", DriName=" + DriName + ", DriEmail=" + DriEmail + ", DriPassword=" + DriPassword
				+ ", DriAuth=" + DriAuth + ", DriGender=" + DriGender + ", DriTell=" + DriTell + ", DriJoinDate="
				+ DriJoinDate + ", DriPicture=" + DriPicture + "]";
	}
}
