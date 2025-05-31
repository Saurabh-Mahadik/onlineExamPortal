package com.example.demo;


import java.time.LocalDate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StudentController {

	@Autowired
	public StudentRepository studentrepository;
	@Autowired
	public QuestionRepository questionrepository;
	
	@Autowired
	public AnswerRepository answerepository;
	
	@Autowired
	public JavaRepository javarepository;
	
	@Autowired
	public ScheduleRepository schedulerepository;
	
	@Autowired
	public MarksRepository marksrepository;
	
	public Long tid;
	public String email;
	public List<Marks> mark;
	public String subject;
	public String batch;
	public Studentsignup student1;
	//New registration
	@RequestMapping("registration")
	public String signIn(Model model) {
		model.addAttribute("student", new Studentsignup());
        return "signup";
	}
	
	@PostMapping("signUp")
	public String saveInfo(@ModelAttribute Studentsignup student,Model model) {
		studentrepository.save(student);
		
		return "redirect:loginup";
	}
	
	//User login
	@GetMapping("loginup")
	public String loginup(Model model) {
		model.addAttribute("student1", new Studentsignup());
		return "login";
	}
	
	//Displaying Scheduled tests
	@PostMapping("loginIn")
	public String login(@ModelAttribute("student")Studentsignup student, Model model,ScheduleTest test) {
		 student1=studentrepository.findByEmailAndPass(student.getEmail(), student.getPass());
		//System.out.println(student1.getBatch()+student1.getBatch());
		
		//System.out.println(user);
		if(student1!=null) {
			email=student1.getEmail();
			subject=student1.getSubject();
			batch=student1.getBatch();
		    model.addAttribute("name",student1.getSname());
			return "welcome";
			//}
			//catch(Exception e) {
				//System.out.println("------------------------------");
				//System.out.println(schedule);
				//model.addAttribute("tests", schedule);
				//return "studDashBoard";
			//}
		}
		else {
			return "signup";
		}
	}
	
	@RequestMapping("/DashBoard")
	public String studentDashBoard(Model model,ScheduleTest test) {
		
		
		 mark=marksrepository.findByEmail(email);
		List<ScheduleTest> schedule=schedulerepository.findAllBySubjectAndBatch(subject,batch);
		List<ScheduleTest> scheduletest=new ArrayList<ScheduleTest>(schedule);
		//System.out.println(mark);
		//System.out.println("-----------------");
		//System.out.println(schedule);
		int count=mark.size();
		model.addAttribute("count", count);
		System.out.println(count);
		//try {
		for(Marks marks1:mark) {
			//System.out.println(marks1);
			for(ScheduleTest schedule1:schedule) {
				//System.out.println(marks1);
				//System.out.println(marks1.getTid()+" "+schedule1.getId());
				if(marks1.getTid()==schedule1.getId()) {
					scheduletest.remove(scheduletest.indexOf(schedule1));
				
					
				}
			}
		}
		//System.out.println(schedule);
       model.addAttribute("tests", scheduletest);
       //model.addAttribute("mark", mark);
       //model.addAttribute("email", email);
		return "studDashBoard";
		
	}
	
	//Index page
	@GetMapping("/")
	public String home(){
		return "home";
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
		return "select";
	}
	@GetMapping("select1")
	public String select(@ModelAttribute Java question,Model model) {
		List<Java> ques=javarepository.findAll();
		model.addAttribute("questions",ques);
		return "select";
	}
	
	//Displaying question and option
	@RequestMapping("alltests/view/{id}")
	public String viewQuestion( @PathVariable Long id,Model model,@ModelAttribute AddQuestion add,@ModelAttribute Answer question,@ModelAttribute ScheduleTest s) {
		
		AddQuestion  l1=questionrepository.findById(id).orElse(add);
		
		AddQuestion  l2=questionrepository.findById(id-1).orElse(add);
		String cans=l2.getAns();
		model.addAttribute("list1",l1);
		//System.out.println(l2);
		
		//System.out.println(question);
		System.out.println(l1.getSubject());
		//Answer a1=answerepository.findById(id).orElse(question);
		//model.addAttribute("a1", a1);
		int nq;
		if(id==1) {
			ScheduleTest st=schedulerepository.findById(tid).orElse(null);
			System.out.println(id);
			  nq=st.getQuestion();
		}
		
		else {
		ScheduleTest st=schedulerepository.findById(tid).orElse(null);		
		//System.out.println(id);
		  nq=st.getQuestion();
		}
		//if(st.getQuestion()>=id) {
         if(id==nq+1) {
        	question.setId(id-1);
 			question.setCorrect(cans);
 			answerepository.save(question);
			
			
			return "score";
		}

		else if(id!=1) {
			question.setId(id-1);
			question.setCorrect(cans);
			answerepository.save(question);
			model.addAttribute("questions",nq);
			//model.addAttribute("list1",l1);
			return "view";
			
		}
		
				else {
			model.addAttribute("questions",nq);
					//model.addAttribute("a1", new Answer());
		return "view";
		}
		//}
		//else {
			
			//return"end";
	    // }
	}
	
	//Displaying Score 
	@RequestMapping("/score/result")
	public String totalScore(Model model,@ModelAttribute Answer question,@ModelAttribute AddQuestion add) {
		
		List<Answer> a=answerepository.findAll();
		Iterator<Answer> i1=a.iterator();
		Integer score=0;
		System.out.println("Testid"+tid);
		ScheduleTest schedule=schedulerepository.findById(tid).orElse(null);
       String subject= schedule.getSubject();
        String batch=schedule.getBatch();
		while(i1.hasNext()) {
			Answer ans=(Answer)i1.next();
			String str1=ans.getCorrect();
			String str2=ans.getSelectedAns();
			if(str1.equals(str2)) {
				
									
				
				score=score+1;
				//System.out.println(score);
				
				
			}
			
			
			
			
		}
		LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String dateString = currentDate.format(dateFormatter);
        String timeString = currentTime.format(timeFormatter);
        
		Marks m=new Marks();
		m.setDate(dateString);
		m.setTime(timeString);
		m.setMarks(score);
		m.setBatch(batch);
		m.setSubject(subject);
		m.setTid(tid);
		m.setEmail(email);
		marksrepository.save(m);
		model.addAttribute("marks",score);
		
		return "result";
	}
	/*
	 * @GetMapping("schedule") public String checkIt(Model model) {
	 * model.addAttribute("schedule", new ScheduleTest()); return "schedule"; }
	 */
	
	@GetMapping("profile")
	public String checkout(Model model,Studentsignup studentprofile) {
		studentprofile=student1;
		model.addAttribute("profile", studentprofile);
		
        return "studentprofile";
	}
	
	
	
	
	
	
	@RequestMapping("alltests/{id}")
	public String allTest(Model model,@PathVariable Long id) {
		System.out.println(id);
		ScheduleTest schedule=schedulerepository.findById(id).orElse(null);
        model.addAttribute("tests", schedule);
        //model.addAttribute("tid", id);
        tid=id;
		return "alltest";
	}
	
	@GetMapping("alltests/start")
	public String start() {
		System.out.println(tid);
		return"start";
		
	}
	
	@RequestMapping("/allAttemptedtests")
	public String attemptedTest(Model model) {
		
		model.addAttribute("tests", mark);
		
		return "attemptedtest";
	}
	
	@RequestMapping("/check")
	public String check(Model model) {
		
		//model.addAttribute("tests", mark);
		
		return "teacherDash";
	}
	
}