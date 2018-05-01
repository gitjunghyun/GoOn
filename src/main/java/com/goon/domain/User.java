package com.goon.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class User {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false,length=50)
	private String PsgId;
	private String PsgName;
	private String PsgPw;
	private int PsgGender;
	private String PsgTell;
	private Date PsgJoinDate;
	private String PsgPicture;
	private String PsgEmail;
}
