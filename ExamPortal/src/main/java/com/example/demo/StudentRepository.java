package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Studentsignup,Long> {
	
	Studentsignup findByEmailAndPass(String email,String pass);

}
