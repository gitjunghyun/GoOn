package com.goon.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CarInfo")
public class CarInfo {

	@Id
	@GeneratedValue
	private Long Id;
	
	private String registration;
	private String trunkuse;
	private String seat;
	private String carType;
	
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public String getTrunkuse() {
		return trunkuse;
	}
	public void setTrunkuse(String trunkuse) {
		this.trunkuse = trunkuse;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	@Override
	public String toString() {
		return "CarInfo [registration=" + registration + ", trunkuse=" + trunkuse + ", seat=" + seat + ", carType="
				+ carType + "]";
	}
}
