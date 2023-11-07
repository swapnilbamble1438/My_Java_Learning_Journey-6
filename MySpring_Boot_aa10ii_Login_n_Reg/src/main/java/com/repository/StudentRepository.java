package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

	
	public Student findById(int id);
}
