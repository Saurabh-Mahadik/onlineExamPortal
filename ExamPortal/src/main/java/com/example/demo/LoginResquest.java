package com.example.demo;

import lombok.Data;

@Data
public class LoginResquest {
	
	String email;
	String pass;
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
	public LoginResquest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginResquest(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "LoginResquest [email=" + email + ", pass=" + pass + "]";
	}
    
}
