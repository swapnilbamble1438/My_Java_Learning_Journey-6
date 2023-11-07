package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	
//===========Read Data===================================================	
	@GetMapping("/books")
	public List<Book> getBooks() {
		
		return this.bookService.getAllBooks();
	}
	
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		
		return this.bookService.getBookbyId(id);
	}
	
	/*
	  Try this url in Postman app
	 open postman app open your workspace
	 
	 Use Get method and enter url:
	 
	 localhost:8080/books
	 
	 localhost:8080/books/id
	 
	 and send
	 
	 */
//=========================================================================
	
	
//==========Create Data======================================================	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
	Book b =	this.bookService.addBook(book);
		return b;
	}
	
	/*
	 Try this url in Postman app
	 open postman app open your workspace
	 
	 select Post method
	 than enter url:
	 localhost:8080/books
	 
	 than select Body
	 than select raw
	 than select JSON (u will find it below text)
	 
	 and then enter your data which u want to add temperory
	 example
	  {
       "id": 5,
        "title": "Programming Book",
        "author": "UVW"
        }
        
        and then send your url simply
        and you will get your output.
	 
	 */
	
//=============================================================================
	
	
//===============Delete Data===================================================================
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId)
	{
		this.bookService.deleteBook(bookId);
	}
	
	/*
	 Use Delete method and enter url:
	 
	 localhost:8080/books/id
	 
	 and send
	 
	 */
	
	
//=============================================================================================	
		
	
//===========Update Data======================================================================
	
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
	{
		this.bookService.updateBook(book,bookId);		
		return book;
	}
	/*
	 Try this url in Postman app
	 open postman app open your workspace
	 
	 select Put method
	 than enter url:
	 localhost:8080/books/id
	 
	 than select Body
	 than select raw
	 than select JSON (u will find it below text)
	 
	 and then enter your data which u want to update with its id temperory
	 example
	  {
      "id": 4,
       "title": "ASP.NET Book",
       "author": "RST"
       }
       
       and then send your url simply
       and you will get your output.
	 
	 */
	
	
//============================================================================================	
	
	
	
}


