package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Product;




public interface UserRepository extends JpaRepository<Product,Integer> {

	
}

