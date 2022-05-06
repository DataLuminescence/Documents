package com.codingdojo.allbooks.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.allbooks.models.Book;
import com.codingdojo.allbooks.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;
	
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	
	// Returns a List of all Books
	@RequestMapping("/books")
	public List<Book> index(){
		return bookService.allBooks();
	}
	
	// Create Method
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public Book create(
			@RequestParam(value="title") String title, 
			@RequestParam(value="description") String desc, 
			@RequestParam(value="language") String lang, 
			@RequestParam(value="pages") Integer numOfPages) {
	    Book book = new Book(title, desc, lang, numOfPages);
	    return bookService.createBook(book);

	}	
	// Read one Book method by using its ID
	@RequestMapping("/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
	    return book;
	}
	
	// Update one Book by using its ID
	@RequestMapping(value="books", method=RequestMethod.PUT) 
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
	@RequestMapping(value="/books", method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
	
}
