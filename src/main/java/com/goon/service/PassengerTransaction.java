package com.goon.service;

import org.springframework.stereotype.Component;

import com.goon.domain.Passenger;

@Component
public class PassengerTransaction {

	private Passenger passenger;
	
	public void setA(Passenger psg) {
		passenger = psg;
	}
	
	public Passenger getA() {
		return passenger;
	}
}
