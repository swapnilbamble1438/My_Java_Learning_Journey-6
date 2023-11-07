package com.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/test")
	@ResponseBody
	public String test()
	{
		int a = 67;
		int b = 89;
		int c = 90;
		
		return "this is just testing. sum of a,b and c is" + (a + b + c ); 
	}
}
