package com.controller;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class MyController {

	//http://localhost:8080/
	
	// for new about
	@GetMapping("/about")
	public String about()
	{
		
		return "about";
	}
	
	@GetMapping("/contact")
	public String contact()
	{
		
		return "contact";
	}
	
	
	
	
}
