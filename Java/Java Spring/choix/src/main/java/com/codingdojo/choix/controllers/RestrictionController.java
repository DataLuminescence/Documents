package com.codingdojo.choix.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.choix.models.User;
//import com.codingdojo.javabelt.models.LoginUser;
import com.codingdojo.choix.models.Restriction;
import com.codingdojo.choix.services.UserService;

@Controller
public class RestrictionController {
	
	@Autowired
	private UserService userService;
	
	// Render the forms the user must user to specify their dietary restrictions
	@GetMapping("/userinfo")
	public String userInfo(Model model, HttpSession session) 
 {
		
    	// Use session data to obtain user information
    	Long userId = (Long) session.getAttribute("userId");
    	
    	// If user id is null it means no one is logged in an we go to login/register page
    	if(userId == null) {
        	return "redirect:/";
    	} 
		
    	User loggedInUser = userService.findById(userId);
    	
    	// Pass information into dashboard.jsp so we can display user name
		model.addAttribute("loggedInUser", loggedInUser);
		
		// Bind empty restriction object to JSP to capture form data
		model.addAttribute("infoUser", new Restriction());
		return "userinfo.jsp";
	}	
	
	// Process the information entered by the user
	@PostMapping("/saveUserInfo")
	public String saveUserInfo(@Valid @ModelAttribute("infoUser") Restriction newRestriction, 
    BindingResult result, Model model, HttpSession session, @RequestParam("allergies") String[] allergies) {
		
		System.out.println(allergies[0]);
		
		// Use user service to create a restriction from form data 
		userService.createRestriction(newRestriction);
		return "redirect:/dashboard";
	}	
	
	// Render the dashboard contents to begin navigating the site
	@GetMapping("/dashboard")
    public String userHome(Model model, HttpSession session) {
    	
    	// Use session data to obtain user information
    	Long userId = (Long) session.getAttribute("userId");
    	
    	// If user id is null it means no one is logged in an we go to login/register page
    	if(userId == null) {
        	return "redirect:/";
    	} 
    		
    	// Query the database for user who has ID provided by session data
    	User loggedInUser = userService.findById(userId);
    	List<Restriction> allRestrictions = userService.allRestrictions();
    	
    	// Pass information into dashboard.jsp so we can display user name
		model.addAttribute("loggedInUser", loggedInUser);
		model.addAttribute("allRestrictions", allRestrictions);
		return "dashboard.jsp";
    }
	
	
	@ModelAttribute("allergiesList")
	   public List<String> getAllergiesList() {
	      List<String> allergiesList = new ArrayList<String>();
	      allergiesList.add("Shellfish");
	      allergiesList.add("Tree Nuts");
	      allergiesList.add("Lactose");
	      allergiesList.add("Gluten");
	      allergiesList.add("Egg");
	      allergiesList.add("Peanuts");
	      allergiesList.add("Wheat");
	      allergiesList.add("Fish");
	      allergiesList.add("Soy");
	      allergiesList.add("Other");
	      return allergiesList;
	   }
	
	
	

}
