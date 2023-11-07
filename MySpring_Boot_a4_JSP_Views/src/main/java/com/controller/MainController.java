package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home()
	{
		System.out.println("this is home page");
		return "home";
	}
	
	@RequestMapping("/contact")
	public String contact()
	{
		System.out.println("this is contact page");
		return "contact";
	}
}
