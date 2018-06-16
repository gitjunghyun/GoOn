package com.goon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goon.domain.CarInfo;

public interface CarinfoRepository extends JpaRepository<CarInfo, Long>{

}
