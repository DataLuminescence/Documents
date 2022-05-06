package com.codingdojo.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.bookclub.models.User;
//import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.services.UserService;

@Controller
public class BookController {
	
	// Create instance of BooksApi? to use its features?
	@Autowired
	private UserService userService;
	
	//
    @GetMapping("/books")
    public String home(HttpSession session, Model model) {
    	
    	// Use session data to obtain user information
    	Long userId = (Long) session.getAttribute("userId");
    	
    	// If user id is null it means no one is logged in an we go to login/register page
    	if(userId == null) {
        	return "redirect:/";
    	} 
    		
    	// Query the database for user who has ID provided by session data
    	User loggedInUser = userService.findById(userId);
    	List<Book> allBooks = userService.allBooks();
    	
    	// Pass information into home.jsp so we can display user name
		model.addAttribute("loggedInUser", loggedInUser);
		model.addAttribute("allBooks", allBooks);
		return "dashboard.jsp";
}
	// Render addbook page and create empty book to be filled out
	@GetMapping("/new")
	public String newBook(Model model, HttpSession session) {
    	
		// Use session data to obtain user information
    	Long userId = (Long) session.getAttribute("userId");
    	
    	// If user id is null it means no one is logged in an we go to login/register page
    	if(userId == null) {
        	return "redirect:/";
    	} 
		
		// Bind empty Book object to JSP to capture form data
		model.addAttribute("newBook", new Book());
		return "addbook.jsp";
	}
	
	// Validate and process information entered into forms
	@PostMapping("/add")
	public String addBook(@Valid @ModelAttribute("newBook") Book newBook, 
			BindingResult result, HttpSession session){
		
        // If userService returns errors reset page to addbook.jsp
        if(result.hasErrors()) {
            return "addbook.jsp";
        }
		
		// Use user service to create a book from form data 
		userService.createBook(newBook);
		return "redirect:/books";
	}
	
	// Renders one book based on the ID
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id")Long id, Model model,
			HttpSession session) {
    	
		// Use session data to obtain user information
    	Long userId = (Long) session.getAttribute("userId");
    	
    	// If user id is null it means no one is logged in an we go to login/register page
    	if(userId == null) {
        	return "redirect:/";
    	} 
    	
		// Located book in DB using userService query and bookID
		Book oneBook = userService.findBook(id);
		model.addAttribute("book", oneBook);
		return "showbook.jsp";
	}	
	
	// Render Edit page
	@GetMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id")Long id, Model model,
			HttpSession session) {
    	
		// Use session data to obtain user information
    	Long userId = (Long) session.getAttribute("userId");
    	
    	// If user id is null it means no one is logged in an we go to login/register page
    	if(userId == null) {
        	return "redirect:/";
    	} 
		
    	Book oneBook = userService.findBook(id);
		model.addAttribute("book", oneBook);
		return "editbook.jsp";
	} 
	
	// Process edit page forms
	@PutMapping("/books/{id}/update")
	public String processEditBook(@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		if(result.hasErrors()) {
			return "editbook.jsp";
		}else {
			userService.updateBook(book);
			return "redirect:/books";
		}	
	}
	
	// Delete book by id
	@DeleteMapping("/books/{id}/delete")
	public String destroyBook(@PathVariable("id") Long id) {
		userService.deleteBook(id);
	  	return "redirect:/books";
	}
	
}
