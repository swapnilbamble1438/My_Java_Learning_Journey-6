package com.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.UserRepository;
import com.model.Product;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {
	


	@Autowired
	private UserRepository userRepo;
	
	
		@RequestMapping(value="/",method=RequestMethod.GET)
		public String home(Model model)
		{
			model.addAttribute("title","Home - CRUD Operations");
			return "home";
		}
		
		

		@RequestMapping(value="/viewall",method=RequestMethod.GET)
		public String about(Model model)
		{
			List<Product> prod = userRepo.findAll();
			model.addAttribute("prod", prod);
			model.addAttribute("title","Products - CRUD Operations");
			return "viewall";
		}
		
		@RequestMapping(value="/addproduct",method = RequestMethod.GET)
		public String addproduct(Model model)
		{
			model.addAttribute("title","Add Product - CRUD Operations");
			model.addAttribute("prod",new Product());
			
			return "addproduct";
		}
		
		
		// handler for inserting or creating data
		@RequestMapping(value="/doaddproduct",method = RequestMethod.POST)
		public String doaddproduct(@ModelAttribute Product prod,Model model,HttpSession session)
		{
			
			
				Product result = userRepo.save(prod);
				
				session.setAttribute("msg","New Product Added successfully");
				
				return "viewall";
					
		}
		
		@RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
		public String edit(@PathVariable int id,Model m)
		{
			Product prod = new Product();
			Optional<Product> pr = userRepo.findById(id);
			if(pr.isPresent())
			{
				prod = pr.get();
			}
				
			m.addAttribute("prod",prod);
			
			return "edit";
		}
		
		@RequestMapping(value="/update",method = RequestMethod.POST)
		public String updateemp(@ModelAttribute Product prod,HttpSession session)
		{
			System.out.println(prod);
			userRepo.save(prod);
			
			session.setAttribute("msg", "Product Data updated successfully...");
			
			return "redirect:/viewall";
		}
		
		
		@RequestMapping(value="/delete/{id}",method =RequestMethod.GET )
		public String deleteemp(@PathVariable int id,HttpSession session)
		{
			userRepo.deleteById(id);
			
			session.setAttribute("msg", "Product data deleted successfully...");
			
			return "redirect:/viewall";
			
		}
		
		

}
