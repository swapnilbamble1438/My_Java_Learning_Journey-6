package com.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	public List<User> findByName(String name);
	
	public List<User> findByNameAndCity(String name,String city);
	
	/*
	  	// Derived Query Methods / Custom Finder Methods
	  	 * data by name
	  	 * data by name and password
	  	 * data by name or password
	  	 * data by name starting with prefix
	  	 * data by name like 'keyword'
	 
	 	// You can use
	 	 
	 findByNameStartingWith(String prefix)
	 findByNameEndingWith(String suffix)
	 findByNameContaining(String words)
	 
	 findByNameLike(String likePattern)
	 
	 findByAgeLessThan(int age)
	 
	 findByAgeGreaterThanEqual(int age)
	 
	 findByAgeIn(Collection<Integer> ages)
	 
	 findByNameOrderByName(String name)
	 
	 
	 */
	
	
	
	
}
