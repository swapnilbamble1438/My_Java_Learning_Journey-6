package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Student;
import com.service.StudentService;

@RestController
public class MyController {
	
	@Autowired
	private StudentService serv;
	
	
	/*
	 Try this url in Postman app
	 */
	
	
	
//===========Read Data===================================================	
	@GetMapping("/Student")
	public ResponseEntity<List<Student>> getStudent() {
		
		List<Student> list = serv.getAllStudent();
		if(list.size() <= 0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	
	@GetMapping("/Student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
		
		Student stud =  serv.getStudentbyId(id);
		
		if(stud == null)
		{
			// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
			
			
		}
		
		return ResponseEntity.of(Optional.of(stud));
	}
	
	/*
	  Try this url in Postman app
	 open postman app open your workspace
	 
	 Use Get method and enter url:
	 
	 localhost:8080/Student
	 
	 localhost:8080/Student/id
	 
	 and send
	 
	 */
//=========================================================================
	
	
//==========Create Data======================================================	
	@PostMapping("/Student")
	public ResponseEntity<Student> addStudent(@RequestBody Student st)
	{
	Student stud = null;
	try {
			serv.addStudent(st);
			System.out.println(st);
			return ResponseEntity.of(Optional.of(stud));
	
	}catch(Exception e){
		e.printStackTrace();
	}
	
	return	ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
	}
	
	/*
	 Try this url in Postman app
	 open postman app open your workspace
	 
	 select Post method
	 than enter url:
	 localhost:8080/Student
	 
	 than select Body
	 than select raw
	 than select JSON (u will find it below text)
	 
	 and then enter your data which u want to add temperory
	 example
	  {
       "id": 1,
        "name": "Swapnil Bamble",
        "password": "1234",
        "city": "Mumbai",
        "course": "Java Developer",
        "duration": "8 Months"
       
        	
        }
        
        and then send your url simply
        and you will get your output.
	 
	 */
	
//=============================================================================
	
	
//===============Delete Data===================================================================
	
	@DeleteMapping("/Student/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id)
	{
		
		try
		{
			serv.deleteStudent(id);
		
	//	return ResponseEntity.ok().build();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		

		
	}
	
	/*
	 Use Delete method and enter url:
	 
	 localhost:8080/Student/id
	 
	 and send
	 
	 */
	
	
//=============================================================================================	
		
	
//===========Update Data======================================================================
	
	@PutMapping("/Student/{id}")
	public ResponseEntity<Student> updateBook(@RequestBody Student st,@PathVariable("id") int id)
	{
		
		try
		{
			serv.updateBook(st, id);
		
		return ResponseEntity.ok().body(st);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	/*
	 Try this url in Postman app
	 open postman app open your workspace
	 
	 select Put method
	 than enter url:
	 localhost:8080/Student/id
	 
	 than select Body
	 than select raw
	 than select JSON (u will find it below text)
	 
	 and then enter your data which u want to update with its id temperory
	 example
	 
	 {
       "id": 1,
        "name": "Swapnil Bamble",
        "password": "1234",
        "city": "Mumbai",
        "course": "Java Developer",
        "duration": "8 Months"
       
        	
        }
	  	  
       
       and then send your url simply
       and you will get your output.
	 
	 */
	
	
//============================================================================================	
	
	

}
