package com.goon.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Evaluation")
public class Evaluation {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	private String evalDrive;
	private String evalClean;
	private String evalManner;
	private String evalText;
	private String evalDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getEvalDrive() {
		return evalDrive;
	}
	public void setEvalDrive(String evalDrive) {
		this.evalDrive = evalDrive;
	}
	public String getEvalClean() {
		return evalClean;
	}
	public void setEvalClean(String evalClean) {
		this.evalClean = evalClean;
	}
	public String getEvalManner() {
		return evalManner;
	}
	public void setEvalManner(String evalManner) {
		this.evalManner = evalManner;
	}
	public String getEvalText() {
		return evalText;
	}
	public void setEvalText(String evaltext) {
		this.evalText = evaltext;
	}
	public String getEvalDate() {
		return evalDate;
	}
	public void setEvalDate(String evalDate) {
		this.evalDate = evalDate;
	}
	
	@Override
	public String toString() {
		return "Evaluation [Id=" + Id + ", evalDrive=" + evalDrive + ", evalClean=" + evalClean + ", evalManner="
				+ evalManner + ", evalText=" + evalText + ", evalDate=" + evalDate + "]";
	}
}
