package com.controller;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Book>> getBooks() {
		
		List<Book> list = this.bookService.getAllBooks();
		if(list.size() <= 0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		
		Book book =  this.bookService.getBookbyId(id);
		
		if(book == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(book));
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
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
	Book b = null;
	try {
			this.bookService.addBook(book);
			System.out.println(book);
			return ResponseEntity.of(Optional.of(b));
	
	}catch(Exception e){
		e.printStackTrace();
	}
	
	return	ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
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
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId)
	{
		
		try
		{
		this.bookService.deleteBook(bookId);
		
	//	return ResponseEntity.ok().build();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		

		
	}
	
	/*
	 Use Delete method and enter url:
	 
	 localhost:8080/books/id
	 
	 and send
	 
	 */
	
	
//=============================================================================================	
		
	
//===========Update Data======================================================================
	
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
	{
		
		try
		{
		this.bookService.updateBook(book,bookId);
		
		return ResponseEntity.ok().body(book);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
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


