package com.goon.repository;

import org.springframework.data.jpa.repository.JpaRepository;	

import com.goon.domain.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long>{

	public Driver findByDriEmail(String email);
}
