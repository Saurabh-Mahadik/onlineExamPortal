package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MarksRepository extends JpaRepository<Marks,Long>{
             
	public List<Marks> findByEmail(String email);
	public List<Marks> findByEmailAndTime(String email,String time);
	public List<Marks> findByStudentId(Long studentID);
	public List<Marks> findByTidAndSubject(Long tid,String subject);
}
