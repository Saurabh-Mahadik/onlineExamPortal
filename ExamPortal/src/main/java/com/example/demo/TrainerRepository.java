package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer,Long> {
	
	Trainer findByEmailAndPass(String email,String pass);

}
