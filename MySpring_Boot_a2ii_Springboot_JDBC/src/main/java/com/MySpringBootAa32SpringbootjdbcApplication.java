package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dao.UserDao;





@SpringBootApplication
public class MySpringBootAa32SpringbootjdbcApplication implements CommandLineRunner{

	@Autowired
	private UserDao userDao;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MySpringBootAa32SpringbootjdbcApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.userDao.createTable());
		
		// creating user
		this.createUser();
		
	}
	
	public void createUser() throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					
		System.out.println("Enter id: ");
		Integer id = Integer.parseInt(br.readLine());
				
		System.out.println("Enter name: ");
		String name = br.readLine();
				
		System.out.println("Enter age: ");
		Integer age = Integer.parseInt(br.readLine());
				
		System.out.println("Enter city: ");
		String city = br.readLine();
		
		int i = this.userDao.insertUser(id, name, age, city);
		
		System.out.println(i + " user added");
				
	}
}
