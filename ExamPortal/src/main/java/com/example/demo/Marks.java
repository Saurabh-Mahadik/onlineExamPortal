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
public class Marks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Long tid;
	String date;
	String time;
	Integer marks;
	String subject;
	String batch;
	String email;
	String startDate;
	Long studentId;
	
	public Marks(Long id, Long tid, String date, String time, Integer marks, String subject, String batch, String email,
			String startDate, Long studentId) {
		super();
		this.id = id;
		this.tid = tid;
		this.date = date;
		this.time = time;
		this.marks = marks;
		this.subject = subject;
		this.batch = batch;
		this.email = email;
		this.startDate = startDate;
		this.studentId = studentId;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Marks() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Marks(Long id, Long tid, String date, String time, Integer marks, String subject, String batch,
			String email) {
		super();
		this.id = id;
		this.tid = tid;
		this.date = date;
		this.time = time;
		this.marks = marks;
		this.subject = subject;
		this.batch = batch;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Marks [id=" + id + ", tid=" + tid + ", date=" + date + ", time=" + time + ", marks=" + marks
				+ ", subject=" + subject + ", batch=" + batch + ", email=" + email + ", startDate=" + startDate
				+ ", studentId=" + studentId + "]";
	}
	
	
	
	
	
	

}
