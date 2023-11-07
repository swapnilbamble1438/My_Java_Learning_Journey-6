package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Student;
import com.repository.StudentRepository;


@Component
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
//===========Read Data==================================================================	
	
	// get all books
	public List<Student> getAllStudent()
	{
	      List<Student> list =  (List<Student>) repo.findAll();
	
	      return list;
	}
	
	// get single book by id
	public Student getStudentbyId(int id)
	{
	Student stud = null;
	try {
		stud = repo.findById(id);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
   return stud;

	}
	
	
	
	
//================================================================================================	
	
//===============Add Data======================================================================
	public Student addStudent(Student st)
	{
		Student stud = repo.save(st);
		return stud;
	}
//==============================================================================================
	
//===============Delete Data===================================================================
	
	public void  deleteStudent(int id)
	{
		
		repo.deleteById(id);
		
	}
	
	
	
//=============================================================================================	
	
//===========Update Data======================================================================
	
	public void updateBook(Student st,int id)
	{
		st.setId(id);
		repo.save(st);
	}
	
//============================================================================================	
	
}
