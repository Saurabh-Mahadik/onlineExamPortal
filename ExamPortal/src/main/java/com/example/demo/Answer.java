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
public class Answer {
	@Id
	
	Long aid;
	String selectedAns;
	String correct;
	
	public Answer(Long aid, String selectedAns, String correct) {
		super();
		this.aid = aid;
		this.selectedAns = selectedAns;
		this.correct = correct;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return aid;
	}
	public void setId(Long aid) {
		this.aid = aid;
	}
	public String getSelectedAns() {
		return selectedAns;
	}
	public void setSelectedAns(String selectedAns) {
		this.selectedAns = selectedAns;
	}
	public String getCorrect() {
		return correct;
	}
	public void setCorrect(String correct) {
		this.correct = correct;
	}
	@Override
	public String toString() {
		return "Answer [id=" + aid + ", selectedAns=" + selectedAns + ", correct=" + correct + "]";
	}
    
}
