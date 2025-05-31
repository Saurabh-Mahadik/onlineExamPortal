package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherContoller {

	@Autowired
	TrainerRepository trainerrepository;
	
	@Autowired
	public ScheduleRepository schedulerepository;

	@RequestMapping("/trainer")
	public String tainerRegistration(Model model) {

		model.addAttribute("trainer", new Trainer());
		return "trainer";
	}

	@GetMapping("teacherinfo")
	public String getTeacherData(@ModelAttribute Trainer trainer,Model model) {

		trainerrepository.save(trainer);

		return "redirect:login";
	}

	@GetMapping("login")
	public String teacheraLogin(Model model) {

		model.addAttribute("teacher",new Trainer());


		return "teacherLogin";
	}

	@PostMapping("credentials")
	public String teacherCrendemtials(@ModelAttribute Trainer cred) {
		Trainer trainerEntity=trainerrepository.findByEmailAndPass(cred.getEmail(), cred.getPass());

		if(trainerEntity!=null) {
			return "teacherDash";
		}
		else {
			return "teacherDash";

		}
	}

	@RequestMapping("/check1")
	public String check(Model model) {

		//model.addAttribute("tests", mark);

		return "teacherDash";
	}
	
	@GetMapping("schedule")
	public String checkIt(Model model) {
		model.addAttribute("schedule", new ScheduleTest());
        return "schedule";
	}
	
	@GetMapping("scheduletest")
	public String check(@ModelAttribute ScheduleTest test,Model model) {
		schedulerepository.save(test);
		System.out.println(test.getTime());
		return "success";
	}
	
	/*
	 * @RequestMapping("") public String scheduleTest() { return"schedule"; }
	 */

}
