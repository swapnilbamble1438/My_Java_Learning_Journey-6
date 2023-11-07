package com;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dao.UserRepository;
import com.entity.User;

@SpringBootApplication
public class MySpringBootA5iiJpaCrudApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(MySpringBootA5iiJpaCrudApplication.class, args);
	
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		
		// create object of User(data) to save
//=======================================================================
		// inserting single data
		/*
		  User user = new User();
		  user.setName("Yash More"); 
		  user.setCity("Thane");
		  user.setStatus("I am python programmer");
		  
		  User user2 = userRepository.save(user);
		  
		  System.out.println(user2);
		 */
//=======================================================================	
		// inserting multiple data
		/*
		  User user3 = new User(); 
		  user3.setName("Pratik Shinde");
		  user3.setCity("Thane"); 
		  user3.setStatus("I am C++ programmer");
		  
		  User user4 = new User(); 
		  user4.setName("Deepak Sawant");
		  user4.setCity("Thane"); 
		  user4.setStatus("I am PHP programmer");
		  
		  List<User> users = List.of(user3,user4); 
		  Iterable<User> result = userRepository.saveAll(users);
		  
		  result.forEach(user->{ System.out.println(user); });
		 */
//=======================================================================		
		// updating data
		/*
		  Optional<User> optional = userRepository.findById(53);
		  
		  User user5 = optional.get();
		  
		  user5.setName("Omkar Jagtap"); User result = userRepository.save(user5);
		  
		  System.out.println(result);
		 */
//=======================================================================		
		// viewing data
		
			// findById(id) - return Optional Containing your data
		
		  Iterable<User> itr = userRepository.findAll(); 
		  
		  // old method----------------------------------------------------
		  /*  
		  Iterator<User> iterator = itr.iterator();
		  
		  while(iterator.hasNext()) { User user = iterator.next();
		  System.out.println(user); }
		 -----------------------------------------------------------------*/
		
		// new method------------------------------------------------------
		/* 
		itr.forEach(new Consumer<User>() {
			
			public void accept(User t) {
				System.out.println(t);
			}
		});
		-------------------------------------------------------------------*/
		  
		// lambda method
		  /*
		  itr.forEach(userall -> 
		  {
			  System.out.println(userall);
		  });
		  */
//==============================================================================		  
		  
		  // Deleting data
		  
		  // delete single data
		  /*
		  userRepository.deleteById(53);
		  System.out.println("Deleted");
		  */
		  
		  // delete all data
		  /*
		  Iterable<User> allusers = userRepository.findAll();
		  
		  allusers.forEach(user ->System.out.println(user));
				
		  userRepository.deleteAll(allusers);
		  */
		  
		  
//==================================================================================		 
		  
	
		  
		  
		  
	}

}
