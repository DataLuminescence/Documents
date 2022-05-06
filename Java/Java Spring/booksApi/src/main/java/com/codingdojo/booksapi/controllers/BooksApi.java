package com.codingdojo.booksapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.booksapi.models.Book;
import com.codingdojo.booksapi.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;
	
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	
	// Returns a List of all Books
	@RequestMapping("/api/books")
	public List<Book> index(){
		return bookService.allBooks();
	}
	
	// Create Method
	@RequestMapping(value="/api/books", method=RequestMethod.POST)
	public Book create(
			@RequestParam(value="title") String title, 
			@RequestParam(value="description") String desc, 
			@RequestParam(value="language") String lang, 
			@RequestParam(value="pages") Integer numOfPages) {
	    Book book = new Book(title, desc, lang, numOfPages);
	    return bookService.createBook(book);

	}	
	// Read one Book method by using its ID
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
	    return book;
	}
	
	// Update one Book by using its ID
	@RequestMapping(value="/api/books", method=RequestMethod.PUT) 
	public Book update(
			@PathVariable("id") Long id, 
	 		@RequestParam(value="title") String title, 
	 		@RequestParam(value="description") String desc, 
	 		@RequestParam(value="language") String lang,
	 		@RequestParam(value="pages") Integer numOfPages){
		Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
		return book;
	}
	
	// Delete one Book by using its ID
	@RequestMapping(value="/api/books", method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
	
}
