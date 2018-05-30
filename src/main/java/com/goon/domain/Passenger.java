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

	private String psgName;
	private String psgEmail;
	private String psgPassword;
	
	//이메일 인증 여부를 0과 1로 구분(인증 후 1로 변경)
	private int psgAuth=0;
	private String psgGender;
	private String psgTell;
	private String psgJoinDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	private String psgPicture;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getPsgName() {
		return psgName;
	}
	public void setPsgName(String psgName) {
		this.psgName = psgName;
	}
	public String getPsgEmail() {
		return psgEmail;
	}
	public void setPsgEmail(String psgEmail) {
		this.psgEmail = psgEmail;
	}
	public String getPsgPassword() {
		return psgPassword;
	}
	public void setPsgPassword(String psgPassword) {
		this.psgPassword = psgPassword;
	}
	public int getPsgAuth() {
		return psgAuth;
	}
	public void setPsgAuth(int psgAuth) {
		this.psgAuth = psgAuth;
	}
	public String getPsgGender() {
		return psgGender;
	}
	public void setPsgGender(String psgGender) {
		this.psgGender = psgGender;
	}
	public String getPsgTell() {
		return psgTell;
	}
	public void setPsgTell(String psgTell) {
		this.psgTell = psgTell;
	}
	public String getPsgJoinDate() {
		return psgJoinDate;
	}
	public void setPsgJoinDate(String psgJoinDate) {
		this.psgJoinDate = psgJoinDate;
	}
	public String getPsgPicture() {
		return psgPicture;
	}
	public void setPsgPicture(String psgPicture) {
		this.psgPicture = psgPicture;
	}
	
	@Override
	public String toString() {
		return "Passenger [Id=" + Id + ", psgName=" + psgName + ", psgEmail=" + psgEmail + ", psgPassword="
				+ psgPassword + ", psgAuth=" + psgAuth + ", psgGender=" + psgGender + ", psgTell=" + psgTell
				+ ", psgJoinDate=" + psgJoinDate + ", psgPicture=" + psgPicture + "]";
	}
}