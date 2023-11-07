package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Book;
import com.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	/*
	 Try this url in Postman app
	 */
	
	
	
//===========Read Data==========================================================	
	@GetMapping("/books")
	public List<Book> getBooks() {
		
		return this.bookService.getAllBooks();
	}
	
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") int id) {
		
		return this.bookService.getBookbyId(id);
	}
	
//=================================================================================	

}


