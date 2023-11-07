package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.BookRepository;
import com.model.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
//===========Read Data==================================================================	
	
	// get all books
	public List<Book> getAllBooks()
	{
	      List<Book> list =  (List<Book>) this.bookRepo.findAll();
	
	      return list;
	}
	
	// get single book by id
	public Book getBookbyId(int id)
	{
	Book book = null;
	try {
		book = this.bookRepo.findById(id);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
   return book;

	}
	
	
	
	
//================================================================================================	
	
//===============Add Data======================================================================
	public Book addBook(Book b)
	{
		Book result = bookRepo.save(b);
		return result;
	}
//==============================================================================================
	
//===============Delete Data===================================================================
	
	public void  deleteBook(int bid)
	{
		
		bookRepo.deleteById(bid);
		
	}
	
	
	
//=============================================================================================	
	
//===========Update Data======================================================================
	
	public void updateBook(Book book,int bookId)
	{
		book.setId(bookId);
		bookRepo.save(book);
	}
	
//============================================================================================	
	

}
