package com.goon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.goon.domain.CarInfo;
import com.goon.domain.Driver;
import com.goon.domain.Passenger;
import com.goon.repository.CarinfoRepository;

@Controller
public class CarInfoController {
	
	@Autowired
	private CarinfoRepository carinforepository;

	@GetMapping("/car/carinfoform")
	public String CarInfoForm() {
		return "/car/carinfoform";
	}
	
	@PostMapping("/car/carinfodb")
	public String CarInfoDB(CarInfo car) {
		carinforepository.save(car);
		
		return "redirect:/";
	}
}
