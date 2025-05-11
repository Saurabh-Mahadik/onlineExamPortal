package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ScheduleTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String batch;
	String level;
	String time;
	String date;
	String subject;
	String duration;
	Integer question;
	Integer marks;
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Integer getQuestion() {
		return question;
	}
	public void setQuestion(Integer question) {
		this.question = question;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public ScheduleTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ScheduleTest(Long id, String batch, String level, String time, String date, String subject, String duration,
			Integer question, Integer marks) {
		super();
		this.id = id;
		this.batch = batch;
		this.level = level;
		this.time = time;
		this.date = date;
		this.subject = subject;
		this.duration = duration;
		this.question = question;
		this.marks = marks;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "ScheduleTest [id=" + id + ", batch=" + batch + ", level=" + level + ", time=" + time + ", date=" + date
				+ ", subject=" + subject + ", duration=" + duration + ", question=" + question + ", marks=" + marks
				+ "]";
	}
	
	
}
