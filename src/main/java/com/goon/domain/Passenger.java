package com.goon.domain;

import java.text.SimpleDateFormat;		
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Passenger")
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
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getPsgName() {
		return PsgName;
	}
	public void setPsgName(String psgName) {
		PsgName = psgName;
	}
	public String getPsgEmail() {
		return PsgEmail;
	}
	public void setPsgEmail(String psgEmail) {
		PsgEmail = psgEmail;
	}
	public String getPsgPassword() {
		return PsgPassword;
	}
	public void setPsgPassword(String psgPassword) {
		PsgPassword = psgPassword;
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
		return "Passenger [Id=" + Id + ", PsgName=" + PsgName + ", PsgEmail=" + PsgEmail + ", PsgPassword="
				+ PsgPassword + ", PsgAuth=" + PsgAuth + ", PsgGender=" + PsgGender + ", PsgTell=" + PsgTell
				+ ", PsgJoinDate=" + PsgJoinDate + ", PsgPicture=" + PsgPicture + "]";
	}
}
