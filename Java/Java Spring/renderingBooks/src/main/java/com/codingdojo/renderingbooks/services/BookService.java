package com.codingdojo.renderingbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.renderingbooks.models.Book;
import com.codingdojo.renderingbooks.repositories.BookRepository;

@Service
public class BookService {
	
	// Adding the book repository as a dependency
	private final BookRepository bookRepository;
	
	// Dependency Injection
	public BookService(BookRepository bookRepository){
		this.bookRepository = bookRepository;
	}

	// Returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	// Creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	// Retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	// Update a book
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
	    Book changeBook = this.findBook(id);
	    changeBook.setTitle(title);
	    changeBook.setDescription(desc);
	    changeBook.setLanguage(lang);
	    changeBook.setNumberOfPages(numOfPages);
	    return bookRepository.save(changeBook);
	}

	// Delete a book
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		
	}
	


 }
