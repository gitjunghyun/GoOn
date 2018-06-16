package com.goon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.goon.domain.Evaluation;
import com.goon.repository.Evaluationrepository;

@Controller
public class EvalController {
	
	@Autowired
	private Evaluationrepository evaluationrepository;

	@GetMapping("/eval/evalform")
	public String passengerEval() {
		return "/eval/evalform";
	}
	
	@PostMapping("/eval/evaldb")
	public String passengerEvalDB(Evaluation eval) {
		evaluationrepository.save(eval);
		
		return "redirect:/";
	}
}