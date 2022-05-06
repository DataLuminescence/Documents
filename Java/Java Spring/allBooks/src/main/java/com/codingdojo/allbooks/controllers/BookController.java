package com.codingdojo.allbooks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.allbooks.models.Book;
import com.codingdojo.allbooks.services.BookService;

@Controller
public class BookController {
	
	
	// Create instance of BooksApi? to use its features?
	@Autowired
	private BookService bookService;
	
	// all books
	@GetMapping("/book")
	public String allBooks(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	
	// one book
	@GetMapping("/book/{id}")
	public String oneBook(@PathVariable("id")Long id, Model model) {
		Book oneBook = bookService.findBook(id);
		model.addAttribute("book", oneBook);
		return "show.jsp";
	}	

	
}
