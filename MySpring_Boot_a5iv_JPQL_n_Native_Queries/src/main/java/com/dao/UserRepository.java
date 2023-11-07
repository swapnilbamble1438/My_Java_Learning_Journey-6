package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	public List<User> findByName(String name);
	
	public List<User> findByNameAndCity(String name,String city);
	
//===========================================================================
	
	// this is JPQL Queries
	@Query("select u From User u")
	public List<User> getAllUsers();	
	
	@Query("select u From User u WHERE u.name =:n")
	public List<User> getUserByName(@Param("n")String name);
	
	@Query("select u From User u WHERE u.name =:n and u.city =:c")
	public List<User> getUserByNameandCity(@Param("n")String name,@Param("c")String city);
	
	
	// this is native query
	@Query(value = "select * from user",nativeQuery = true)
	public List<User> getTotalUsers();
	
}
