package com.goon.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.goon.domain.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long> {

	//List<Passenger> findByPassengerPsgEmail(String userid);
	//Passenger findByPsgEmail(String PsgEmail);
	//Passenger findByPsgEmail(String PsgEmail);
	public Passenger findByPsgEmail(String email);
	
//	@Query("select u from Passenger u where u.PsgEmail = ?1")
//	Passenger findByPsgEmail(@Param("PsgEmail")String email);
	
//	@Query("select PsgEmail from Passenger")
//	Passenger findByPsgEmailAndPsgNameLessThan(@Param("PsgEmail")String email,@Param("PsgName")String name);

	//List<Passenger> findByPsgEmailAndPsgPassword(String email, String password);
	
	//@Query("select u from Passenger u where u.PsgEmail = ?1")
	//Passenger findByPsgEmail(@Param("PsgEmail")String email);
}