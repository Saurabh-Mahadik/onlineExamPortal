package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<AddQuestion,Long> {
	
	//AddQuestion findByIdAndSubject(Long qid,String subject);

}
