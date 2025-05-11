package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data // Lombok annotation for getters, setters, toString, etc.
@NoArgsConstructor // Lombok annotation for a no-args constructor
@AllArgsConstructor
public class Java {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long qid;
	String question;
	String opt1;
	String opt2;
	String opt3;
	String opt4;
	String ans;
	String subject;
	String batch;
	String level;
	public Long getQid() {
		return qid;
	}
	public void setQid(Long qid) {
		this.qid = qid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOpt1() {
		return opt1;
	}
	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}
	public String getOpt2() {
		return opt2;
	}
	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}
	public String getOpt3() {
		return opt3;
	}
	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}
	public String getOpt4() {
		return opt4;
	}
	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Java(Long qid, String question, String opt1, String opt2, String opt3, String opt4, String ans,
			String subject, String batch, String level) {
		super();
		this.qid = qid;
		this.question = question;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.ans = ans;
		this.subject = subject;
		this.batch = batch;
		this.level = level;
	}
	public Java() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Java [qid=" + qid + ", question=" + question + ", opt1=" + opt1 + ", opt2=" + opt2 + ", opt3=" + opt3
				+ ", opt4=" + opt4 + ", ans=" + ans + ", subject=" + subject + ", batch=" + batch + ", level=" + level
				+ "]";
	}
	

}
