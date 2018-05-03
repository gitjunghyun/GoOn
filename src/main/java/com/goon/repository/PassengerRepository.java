package com.goon.repository;

import org.springframework.data.jpa.repository.JpaRepository;	

import com.goon.domain.Passenger;
	
public interface PassengerRepository extends JpaRepository<Passenger,Long> {

}
