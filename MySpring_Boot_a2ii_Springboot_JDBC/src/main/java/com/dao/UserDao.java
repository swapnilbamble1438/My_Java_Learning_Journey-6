package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public UserDao()
	{
		
	}
	
	
	// create table
	public int createTable()
	{
		String query="create table if not exists User("
				+ "id int primary key,"
				+ "name varchar(200),"
				+ "age int,"
				+ "city varchar(100))";
		
		int createTable =  this.jdbcTemplate.update(query);
			
		return createTable;

	}
	
	
	// inserting user to database
	public int insertUser(int id,String name,int age,String city)
	{
		String query = "insert into user(id,name,age,city) values(?,?,?,?)";
		
	int insertedUser =	this.jdbcTemplate.update(query,new Object[]{id,name,age,city});
	
		return  insertedUser;
	}
	
	
	

}
