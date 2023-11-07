package com.dao;

import org.springframework.data.repository.CrudRepository;

import com.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	
}
