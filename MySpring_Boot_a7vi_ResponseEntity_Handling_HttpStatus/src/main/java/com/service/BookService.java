package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.model.Book;

@Component
public class BookService {
	
	
//===========Read Data==================================================================	
	private static List<Book> list = new ArrayList<>();
	
	static {
		list.add(new Book(2,"Python Book","PQR"));
		list.add(new Book(3,"C++ Book","DEF"));
		list.add(new Book(4,"PHP Book","RST"));
	}
	
	// get all books
	public List<Book> getAllBooks()
	{
		return list;
	}
	
	// get single book by id
	public Book getBookbyId(int id)
	{
	Book book = null;
	try {
   book =	list.stream().filter(e ->e.getId()==id).findFirst().get();
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
   return book;

	}
	
	
	/*
	  public static void main(String[] args) {
	  
	  
	  // Java8 methods of retrieving
	  
	  // retrieving by int Book b1 = new Book(); b1 = list.stream().filter(e
	  ->e.getId()== 2).findFirst().get();
	  
	  System.out.println(b1);
	  
	  
	  // retrieving by String Book b2 = new Book(); b2 = list.stream().filter(e
	  ->e.getAuthor().equals("RST")).findFirst().get();
	  
	  System.out.println(b2); }
	 */
	
//================================================================================================	
	
//===============Add Data======================================================================
	public Book addBook(Book b)
	{
		list.add(b);
		return b;
	}
//==============================================================================================
	
//===============Delete Data===================================================================
	
	public void  deleteBook(int bid)
	{
		list = list.stream().filter(book -> book.getId()!=bid).
		 collect(Collectors.toList());
		
		// here we have compare each list with the list which we want to delete
		// so in this list variable all the list will
		// get store and the the list whose id we have send to delete
		// it will detect that list and will not store that list 
		// in our new list variable
			

	}
	
	
	
//=============================================================================================	
	
//===========Update Data======================================================================
	
	public void updateBook(Book book,int bookId)
	{
		list = list.stream().map(b -> {
			if(b.getId() == bookId)
			{
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}
	
//============================================================================================	
	

}
