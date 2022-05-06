package com.codingdojo.javabelt.controllers;

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

import com.codingdojo.javabelt.models.User;
//import com.codingdojo.javabelt.models.LoginUser;
import com.codingdojo.javabelt.models.Show;
import com.codingdojo.javabelt.services.UserService;

@Controller
public class ShowController {
	
	@Autowired
	private UserService userService;
	
	//
    @GetMapping("/shows")
    public String home(HttpSession session, Model model) {
    	
    	// Use session data to obtain user information
    	Long userId = (Long) session.getAttribute("userId");
    	
    	// If user id is null it means no one is logged in an we go to login/register page
    	if(userId == null) {
        	return "redirect:/";
    	} 
    		
    	// Query the database for user who has ID provided by session data
    	User loggedInUser = userService.findById(userId);
    	List<Show> allShows = userService.allShows();
    	
    	// Pass information into home.jsp so we can display user name
		model.addAttribute("loggedInUser", loggedInUser);
		model.addAttribute("allShows", allShows);
		return "dashboard.jsp";
}
	// Render addbook page and create empty book to be filled out
	@GetMapping("/new")
	public String newShow(Model model, HttpSession session) {
    	
		// Use session data to obtain user information
    	Long userId = (Long) session.getAttribute("userId");
    	
    	// If user id is null it means no one is logged in an we go to login/register page
    	if(userId == null) {
        	return "redirect:/";
    	} 
		
		// Bind empty show object to JSP to capture form data
		model.addAttribute("newShow", new Show());
		return "addshow.jsp";
	}
	
	// Validate and process information entered into forms
	@PostMapping("/add")
	public String addShow(@Valid @ModelAttribute("newShow") Show newShow, 
			BindingResult result, HttpSession session){
		
        // If userService returns errors reset page to addshow.jsp
        if(result.hasErrors()) {
            return "addshow.jsp";
        }
		
		// Use user service to create a show from form data 
		userService.createShow(newShow);
		return "redirect:/shows";
	}
	
	// Renders one show based on the ID
	@GetMapping("/shows/{id}")
	public String showShow(@PathVariable("id")Long id, Model model,
			HttpSession session) {
    	
		// Use session data to obtain user information
    	Long userId = (Long) session.getAttribute("userId");
    	
    	// If user id is null it means no one is logged in an we go to login/register page
    	if(userId == null) {
        	return "redirect:/";
    	} 
    	
		// Located book in DB using userService query and bookID
    	Show oneShow = userService.findShow(id);
		model.addAttribute("show", oneShow);
		return "showshow.jsp";
	}	
	
	// Render Edit page
	@GetMapping("/shows/{id}/edit")
	public String editShow(@PathVariable("id")Long id, Model model,
			HttpSession session) {
    	
		// Use session data to obtain user information
    	Long userId = (Long) session.getAttribute("userId");
    	
    	// If user id is null it means no one is logged in an we go to login/register page
    	if(userId == null) {
        	return "redirect:/";
    	} 
		
    	Show testShow = userService.findShow(id);
    	
    	if(userId != testShow.getUser().getId()) {
        	return "redirect:/shows";
    	} 
    	
    	Show oneShow = userService.findShow(id);
		model.addAttribute("show", oneShow);
		return "editshow.jsp";
	} 
	
	// Process edit page forms
	@PutMapping("/shows/{id}/update")
	public String processEditShow(@Valid @ModelAttribute("show") Show show,
			BindingResult result) {
		
		userService.updateShow(show, result);
		
		if(result.hasErrors()) {
			return "editshow.jsp";
		}else {

			return "redirect:/shows";
		}	
	}
	
	// Delete book by id
	@DeleteMapping("/shows/{id}/delete")
	public String destroyShow(@PathVariable("id") Long id) {

		
		userService.deleteShow(id);
	  	return "redirect:/shows";
	}
	
}
