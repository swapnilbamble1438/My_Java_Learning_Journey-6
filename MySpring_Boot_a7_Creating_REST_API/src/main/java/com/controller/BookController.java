package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Book;

/*@Controller*/ // it is not needed
@RestController
public class BookController {

	/*
	 * @RequestMapping(value="/books",method = RequestMethod.GET)
	 * 
	 * @ResponseBody
	 */
	@GetMapping("/books")
	public Book getBooks() {
		
		Book book = new Book();
		book.setId(1);
		book.setTitle("Java Complete Reference");
		book.setAuthor("ABC");
		return book;

	}

}
