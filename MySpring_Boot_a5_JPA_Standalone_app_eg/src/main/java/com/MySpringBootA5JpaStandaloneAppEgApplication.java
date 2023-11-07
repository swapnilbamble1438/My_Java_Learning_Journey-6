package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dao.UserRepository;
import com.entity.User;

@SpringBootApplication
public class MySpringBootA5JpaStandaloneAppEgApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(MySpringBootA5JpaStandaloneAppEgApplication.class, args);
	
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		User user = new User();
		user.setName("Swapnil Bamble");
		user.setCity("Mumbai");
		user.setStatus("I am java programmer");
		
		User user2 = userRepository.save(user);
		
		System.out.println(user2);
	
	}

}
