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
public class Studentsignup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long sid;
	String sname;
	String gender;
	Long cnum;
	String address;
	String email;
	String pass;
	String subject;
	String batch;
	
	public Studentsignup(Long sid, String sname, String gender, Long cnum, String address, String email, String pass,
			String subject, String batch) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.cnum = cnum;
		this.address = address;
		this.email = email;
		this.pass = pass;
		this.subject = subject;
		this.batch = batch;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getCnum() {
		return cnum;
	}
	public void setCnum(Long cnum) {
		this.cnum = cnum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Studentsignup() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Studentsignup [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", cnum=" + cnum + ", address="
				+ address + ", email=" + email + ", pass=" + pass + ", subject=" + subject + ", batch=" + batch + "]";
	}
	
	
	
	
	

}
