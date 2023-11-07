package com.controller;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class MyController {

	//http://localhost:8080/about
	
	@RequestMapping(value = "/about",method = RequestMethod.GET )
	public String about(Model m)
	{
		System.out.println("Inside about handler...");
		
		
		m.addAttribute("name","Swapnil Bamble");
		m.addAttribute("date",new Date().toLocaleString());
		
		return "about";
		// about.html
	
		
	}
	
	// handling iteration
	
	@GetMapping("/loop")
	public String iterateHandler(Model m)
	{
		//create a list,set collection
		
		 List<String> names = List.of("Ankit","Laxmi","Karan","John");
		
		 m.addAttribute("names",names);
		
		 
		
		
		return "iterate";
	}
	
	//handler for conditional statements
	@GetMapping("/condition")
	public String conditionalHandler(Model m)
	{
		System.out.println("conditional handler executed...");
		
		m.addAttribute("isActive",true);
		
		m.addAttribute("gender","M");
		
		List<Integer> list = List.of(1,2,3,4,5);
		m.addAttribute("mylist",list);
		
		return "condition";
	}
	
	// handler for including fragments
	@GetMapping("/service")
	public String servicesHandler(Model m)
	{
		
		
		
		return "service";
	}
	
	
	
}
