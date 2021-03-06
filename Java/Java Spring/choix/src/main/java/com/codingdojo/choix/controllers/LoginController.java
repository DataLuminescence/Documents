package com.codingdojo.choix.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.codingdojo.choix.models.LoginUser;
import com.codingdojo.choix.models.User;
import com.codingdojo.choix.services.UserService;

@Controller
public class LoginController {

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
    
        return "redirect:/userinfo";
    }
    
    // Process login form information
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
        return "redirect:/dashboard";
    }

    // Close session out and send user to the login/register page
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}	
	
}
