package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherContoller {

	@Autowired
	TrainerRepository trainerrepository;
	
	@Autowired
	public ScheduleRepository schedulerepository;
	
	@Autowired
	public JavaRepository javarepository;
	
	@Autowired
	public QuestionRepository questionrepository;
	

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
			return "redirect:/trainer";

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
	
	
	//Add  questions(admin page)
		@GetMapping("add")
		public String question(Model model) {
			model.addAttribute("question", new AddQuestion());
			return "addquestion";
		}
		
		@PostMapping("save")
		public String save(@ModelAttribute Java question,Model model) {
			System.out.println();
			if(question.getSubject().equals("Java")) {
				javarepository.save(question);
				return "success";
			}
			else {
				
				return "success";
			}
			
		}
	
		//Common question bank
		@GetMapping("add/{id}")
		public String addquestion(@PathVariable  Long id,Model model) {
			Java q1=javarepository.findById(id).orElse(null);
			//Java q12=q1;
			AddQuestion que=new AddQuestion(q1.qid,q1.question,q1.opt1,q1.opt2,q1.opt3,q1.opt4,q1.ans,q1.subject,q1.batch,q1.level);
			System.out.println(que);
			
			questionrepository.save(que);
			return "redirect:/select1";
		}
	
		@GetMapping("select1")
		public String select(@ModelAttribute Java question,Model model) {
			List<Java> ques=javarepository.findAll();
			model.addAttribute("questions",ques);
			return "select";
		}
	/*
	 * @RequestMapping("") public String scheduleTest() { return"schedule"; }
	 */

}
