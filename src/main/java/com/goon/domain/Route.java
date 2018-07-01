package com.goon.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Route")
public class Route {

	@Id
	@GeneratedValue
	private Long id;
	
	private String startX;
	private String startY;
	private String endX;
	private String endY;
	private String time;
	private String fee;
	private String distance;
	private String date  = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStartX() {
		return startX;
	}
	public void setStartX(String startX) {
		this.startX = startX;
	}
	public String getStartY() {
		return startY;
	}
	public void setStartY(String startY) {
		this.startY = startY;
	}
	public String getEndX() {
		return endX;
	}
	public void setEndX(String endX) {
		this.endX = endX;
	}
	public String getEndY() {
		return endY;
	}
	public void setEndY(String endY) {
		this.endY = endY;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Route [id=" + id + ", startX=" + startX + ", startY=" + startY + ", endX=" + endX + ", endY=" + endY
				+ ", time=" + time + ", fee=" + fee + ", distance=" + distance + ", date=" + date + "]";
	}
}
