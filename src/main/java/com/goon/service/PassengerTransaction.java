package com.goon.service;

import org.springframework.stereotype.Component;	

import com.goon.domain.Passenger;

@Component
public class PassengerTransaction {

	private Passenger passenger;
	
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
	public Passenger getPassenger() {
		return passenger;
	}
}
