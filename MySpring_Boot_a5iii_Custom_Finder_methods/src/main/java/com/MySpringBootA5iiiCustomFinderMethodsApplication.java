package com;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dao.UserRepository;
import com.entity.User;


@SpringBootApplication
public class MySpringBootA5iiiCustomFinderMethodsApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(MySpringBootA5iiiCustomFinderMethodsApplication.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		System.out.println("===============================================================================");
		
//=============================================================================		
		// viewing data by findByName
		
		/*
		List<User> user1 = userRepository.findByName("Yash More");
	
		user1.forEach(e -> System.err.println(e));
		*/
//=============================================================================		
	
		// viewing data by findByNameandCity
		/*
		List<User> user2 = userRepository.findByNameAndCity("Yash More", "Thane");
		
		user2.forEach(e -> System.out.println(e));
		*/
//=============================================================================		
		
		
		
		
		
		
		
	}

}
