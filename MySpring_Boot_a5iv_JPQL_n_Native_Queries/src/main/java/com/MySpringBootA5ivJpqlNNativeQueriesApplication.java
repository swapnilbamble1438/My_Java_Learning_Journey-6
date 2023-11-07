package com;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dao.UserRepository;
import com.entity.User;

@SpringBootApplication
public class MySpringBootA5ivJpqlNNativeQueriesApplication {

	public static void main(String[] args) {
	
		ApplicationContext context = SpringApplication.run(MySpringBootA5ivJpqlNNativeQueriesApplication.class, args);
	
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		System.out.println("===============================================================================");
		
//====================================================================================================		
	List<User> alluser = userRepository.getAllUsers();
	
	alluser.forEach(e -> {
		System.out.println(e);
	});
		
//====================================================================================================		
	
	List<User> userByName =  userRepository.getUserByName("Yash More");
	
	userByName.forEach(e -> {
		System.out.println(e);
	});
	
//====================================================================================================		
	
List<User> userByNameandCity =  userRepository.getUserByNameandCity("Pratik Shinde", "Kalwa");
	
	userByNameandCity.forEach(e -> {
		System.out.println(e);
	});
	
//====================================================================================================		
	
	List<User> totalusers =  userRepository.getTotalUsers();
		
		totalusers.forEach(e -> {
			System.out.println(e);
		});
	
	
	
	
	}

}
