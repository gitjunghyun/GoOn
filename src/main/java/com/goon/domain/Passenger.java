package com.goon.domain;

import java.sql.Date;

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
	
	private int PsgAuth=0;
	private String PsgGender;
	private String PsgTell;
	private Date PsgJoinDate;
	private String PsgPicture;
}