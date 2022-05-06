package com.codingdojo.loginandregistration.controllers;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.loginandregistration.models.LoginUser;
import com.codingdojo.loginandregistration.models.User;
import com.codingdojo.loginandregistration.services.UserService;

// .. don't forget to inlcude all your imports! ..
    
@Controller
public class HomeController {
    
    // Add once service is implemented:
     @Autowired
     private UserService userService;
    
    // Render register and login page
    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User()); // For Register
        model.addAttribute("newLogin", new LoginUser()); // For login
        return "loginreg.jsp";
    }
    
    // Process registration form information
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
    	// Pass in form data via newUser to perform validation in UserService
        userService.register(newUser, result);
        
        // If userService returns errors reset the page by ????
        if(result.hasErrors()) {
        	
        	// Binds empty LoginUser object to JSP to capture login form
            model.addAttribute("newLogin", new LoginUser());
            return "loginreg.jsp";
        }
        
        // If no error we store ID in session
        session.setAttribute("userId", newUser.getId());
    
        return "redirect:/home";
    }
    
    // PRocess login form information
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {

        // Validate user email exists in DB and that all forms were properly filled out
        User user =  userService.login(newLogin, result);
    
        // If userService returns errors reset page to login/registration
        if(result.hasErrors()) {
        	
        	// Binds empty LoginUser object to JSP to capture login form
            model.addAttribute("newUser", new User());
            return "loginreg.jsp";
        }
        
        // If no error we store ID in session
        session.setAttribute("userId", user.getId());
        return "redirect:/home";
    }
    
    // 
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
    	
    	// Use session data to obtain user information
    	Long userId = (Long) session.getAttribute("userId");
    	
    	// If user id is null it means no one is logged in an we go to login/register page
    	if(userId == null) {
        	return "redirect:/";
    	} 
    		
    	// Query the database for user who has ID provided by session data
    	User loggedInUser = userService.findById(userId);
    	
    	// Pass information into home.jsp so we can display user name
		model.addAttribute("loggedInUser", loggedInUser);
		return "/home.jsp";
}
    
    // Close session out and send user to the login/register page
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}

//	
//	// Create instance of dojosApi? to use its features?
//	@Autowired
//	private DojoService dojoService;	
//	
//	// Displays dojos currently in the database and sets up forms to create new dojo
//	@GetMapping("/dojos")
//	// ModelAttribute will serve as an empty dojo to fill with form data. Model model is used to 
//	// pass dojo data from the server to the display part of our index.jsp
//	public String renderCreateDojo(@ModelAttribute("dojo") Dojo dojo, Model model){
//		
//		// Using methods of dojoService create a List of all Dojos in the database
//		List<Dojo> allDojos = dojoService.allDojos();
//		// Create a key to call all dojos from JSP file. 
//		model.addAttribute("allDojos", allDojos);
//		return "dojopage.jsp";
//	}
//	
//	// Validates if information entered into forms is valid. If valid we create a new dojo then
//	// redirect back to reload dojo to display the new dojo and any others in the database
//	@PostMapping("/dojos/new")
//    public String processCreateDojo(@Valid @ModelAttribute("dojo") Dojo dojo, 
//    		BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "dojopage.jsp";
//        } else {
//        	// Create dojo if validation successful
//            dojoService.createDojo(dojo);
//            return "redirect:/ninjas";
//        }
//    }
//	
//	// Render show page
//	@GetMapping("/dojo/{id}/show")
//	public String renderShowDojo(@PathVariable("id") Long id, Model model) {
//		Dojo oneDojo= dojoService.findDojo(id);
//		model.addAttribute("dojo", oneDojo);
//		
//		
//	  	return "dojosandninjas.jsp";
//	}
//	
//	// Render Edit page
//	@GetMapping("/dojo/{id}/render/edit")
//	public String renderEditDojo(@PathVariable("id")Long id, Model model) {
//		Dojo oneDojo= dojoService.findDojo(id);
//		model.addAttribute("dojo", oneDojo);
//		return "edit.jsp";
//	}
	
//	// Process edit page forms
//	@PostMapping("/dojo/{id}/edit")
//	public String processEditDojo(@Valid @ModelAttribute("dojo") Dojo dojo,
//			BindingResult result) {
//		if(result.hasErrors()) {
//			return "edit.jsp";
//		}else {
//			dojoService.updateDojo(dojo);
//			return "redirect:/dojo";
//		}	
//	}
	
//	// Delete dojo by id
//	@PostMapping("/dojo/{id}/delete")
//	public String destroy(@PathVariable("id") Long id) {
//		dojoService.deleteDojo(id);
//	  	return "redirect:/dojo";
//	}
	
//}
