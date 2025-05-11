package com.demo.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@Autowired
	TrainerRepository trainerrepository;
	
	@RequestMapping("/trainer")
	public String tainerRegistration(Model model) {
		
		model.addAttribute("tainer", new Trainer());
		return "trainer";
	}

}
