package com.dao;

import org.springframework.data.repository.CrudRepository;

import com.model.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {

	public Book findById(int id);
	
	
	
}
