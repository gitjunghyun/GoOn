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
	private int PsgAuth = 0;
	private String PsgGender;
	private String PsgTell;
	private String PsgJoinDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	private String PsgPicture;
	

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
	public int getPsgAuth() {
		return PsgAuth;
	}
	public void setPsgAuth(int psgAuth) {
		PsgAuth = psgAuth;
	}
	public String getPsgGender() {
		return PsgGender;
	}
	public void setPsgGender(String psgGender) {
		PsgGender = psgGender;
	}
	public String getPsgTell() {
		return PsgTell;
	}
	public void setPsgTell(String psgTell) {
		PsgTell = psgTell;
	}
	public String getPsgJoinDate() {
		return PsgJoinDate;
	}
	public void setPsgJoinDate(String psgJoinDate) {
		PsgJoinDate = psgJoinDate;
	}
	public String getPsgPicture() {
		return PsgPicture;
	}
	public void setPsgPicture(String psgPicture) {
		PsgPicture = psgPicture;
	}
	
	@Override
	public String toString() {
		return "Driver [Id=" + Id + ", DriName=" + DriName + ", DriEmail=" + DriEmail + ", DriPassword=" + DriPassword
				+ ", PsgAuth=" + PsgAuth + ", PsgGender=" + PsgGender + ", PsgTell=" + PsgTell + ", PsgJoinDate="
				+ PsgJoinDate + ", PsgPicture=" + PsgPicture + "]";
	}
}
