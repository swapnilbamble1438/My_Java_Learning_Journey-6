package com.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Userr;
import com.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class UserController {

		@Autowired
		private UserService userService;
	
	
		@PostMapping("users")
		public ResponseEntity<Userr> createUser(@Valid @RequestBody Userr user)
		{
			
			Userr savedUser = userService.createUser(user);
			
			return new ResponseEntity<Userr>(savedUser,HttpStatus.CREATED);
			
			
			
		}
		
		
		// try this on postman app
		/*
		 http://localhost:8080/api/users
		 
		 select POST selet Body-> raw -> JSON
		 
		 {
		 	"name": "Ramesh",
		 	"email":"ramesh@gmail.com",
		 	"password":"Password123"
		 }
		 
		 and hit send mutton
		 
		 
		 and not try to send the 
		 
		 
		 
		 */
}
