package com.example.demo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok annotation for getters, setters, toString, etc.
@NoArgsConstructor // Lombok annotation for a no-args constructor
@AllArgsConstructor
@Entity
public class Trainer {
	
	@Id
	Long tid;
	String tname;
	String gender;
	String subject;
	String email;
	String pass;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Trainer(Long tid, String tname, String subject, String email, String pass) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.subject = subject;
		this.email = email;
		this.pass = pass;
	}
	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Admin [tid=" + tid + ", tname=" + tname + ", subject=" + subject + ", email=" + email + ", pass=" + pass
				+ "]";
	}
	
	
	
	

}
