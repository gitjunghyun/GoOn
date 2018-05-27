package com.goon.service;

import org.springframework.stereotype.Component;

import com.goon.domain.Driver;

@Component
public class DriverTransaction {

	private Driver driver;
	
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public Driver getDriver() {
		return driver;
	}
}
