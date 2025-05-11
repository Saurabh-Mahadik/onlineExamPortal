package com.example.demo;


import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

public interface ScheduleRepository extends ListCrudRepository<ScheduleTest, Long> {
	
	public ScheduleTest findBySubjectAndBatchAndLevel(String subject,String batch,String level);
	
	public List<ScheduleTest> findAllBySubjectAndBatch(String subject,String batch);

}
