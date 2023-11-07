package com.controller;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Logindata;



@Controller 
public class MyController {

	
	@GetMapping("/form")
	public String form(Model model)
	{
		
		System.out.println("Opening form");
		model.addAttribute("Logindata",new Logindata());
		
		return "form";
	}
	
	
	// handler for processing form
	@PostMapping("/process")
	public String process(@Valid @ModelAttribute("Logindata") Logindata Logindata,BindingResult result)
	{
		if(result.hasErrors())
		{
			
			System.out.println(result);
			
			return "form";
		}
		
		
		System.out.println(Logindata);
		return "success";
	}
}
