package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Employee;
import com.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmployeeService empserv;
	
	@GetMapping("/")
	public String home(Model m)
	{
		List<Employee> emp = empserv.getAllEmployee();
		m.addAttribute("emp",emp);
		
		return "home";
	}
	
	@GetMapping("/addemp")
	public String addemp()
	{
		
		return "addemp";
	}
	
	@PostMapping("/doaddemp")
	public String doaddemp(@ModelAttribute Employee emp,HttpSession session)
	{
		System.out.println(emp);
		
		empserv.addEmployee(emp);
		session.setAttribute("msg", "Employee added successfully...");
		 return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		Employee emp = empserv.getEmployeeById(id);
			
		m.addAttribute("emp",emp);
		
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateemp(@ModelAttribute Employee emp,HttpSession session)
	{
		empserv.addEmployee(emp);
		
		session.setAttribute("msg", "Employee Data updated successfully...");
		
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteemp(@PathVariable int id,HttpSession session)
	{
		empserv.deleteEmployee(id);
		
		session.setAttribute("msg", "Employee data deleted successfully...");
		
		return "redirect:/";
	}
}
