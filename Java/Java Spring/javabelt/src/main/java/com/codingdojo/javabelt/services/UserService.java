package com.codingdojo.javabelt.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.javabelt.models.Show;
import com.codingdojo.javabelt.models.LoginUser;
import com.codingdojo.javabelt.models.User;
import com.codingdojo.javabelt.repositories.ShowRepository;
import com.codingdojo.javabelt.repositories.UserRepository;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ShowRepository showRepository;
    
    // Validates form data and registers new user if data is sound
    public User register(User newUser, BindingResult result) {
    	
    	// Use userRepository to conduct a query if email in new user exists in the database
    	Optional <User> potentialEmail = userRepository.findByEmail(newUser.getEmail());
    	Optional <User> potentialUserName = userRepository.findByUserName(newUser.getUserName());
    	
    	if(potentialUserName.isPresent()) {
    		result.rejectValue("userName", "unique", "Username already exists");
    	}
    	
		// Reject if email is currently in database
    	if(potentialEmail.isPresent()) {
    		result.rejectValue("email", "unique", "Email already exists");
    	}
    	   	
    	// Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())  ) {
    		result.rejectValue("password", "match", "Password and confirmation don't match");
    	}
    	
    	// Return null if result has errors
    	if(result.hasErrors()){
    		return null;
    	}
    	
    	// Hash and set password, save user to database
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return userRepository.save(newUser);
    }
    
    
    // Validates form data and signs user in if data is sound
    public User login(LoginUser newLogin, BindingResult result) {
        
    	// Find user in DB by email by using email provided by form
    	Optional <User> potentialEmail= userRepository.findByEmail(newLogin.getEmail());
    	
		// Verify that email/username is in the DB if not reject
    	if(!potentialEmail.isPresent()) {
    		result.rejectValue("email", "unique", "Unknown Email");
        	return null;
    	}
    	
    	// Get user from DB. By using Optional built in methods.
    	User activeUser = potentialEmail.get();

    	// BCrypt compares the hashes of the password entered into form and what is in DB
    	if(!BCrypt.checkpw(newLogin.getPassword(), activeUser.getPassword())) {
    	    
    		// If there is no match return error message
    		result.rejectValue("password", "matches", "Invalid Password!");
    	}
    	
    	// Return null if result has errors
    	if(result.hasErrors()){
    		return null;
    	}
    	
    	return activeUser;	
    }
    
    public User findById(Long id) {
    	
    	// Find user in DB by email
    	Optional <User> sessionUser = userRepository.findById(id);
    	
    	// Serches if the user is in the DB and if so returns that uses 
    	if (sessionUser.isPresent()) {
    		return sessionUser.get();
    	} 
    	return null;
    }
    
	// Returns all the shows
	public List<Show> allShows() {
		return showRepository.findAll();
	}
	
	// Creates a show
	public Show createShow(Show newShow) {
		return showRepository.save(newShow);
	}
	
	// Retrieves a show
	public Show findShow(Long id) {
		Optional<Show> optionalShow = showRepository.findById(id);
		
		// Validates that the show is in DB otherwise returns null
		if(optionalShow.isPresent()) {
			return optionalShow.get();
		} else {
			return null;
		}
	}
	
	// Update a show
	public Show updateShow(Show changeShow, BindingResult result) {
		
    	// Use userRepository to conduct a query if email in new user exists in the database
    	Optional <Show> potentialTitle = showRepository.findByTitle(changeShow.getTitle());
    	
    	if(potentialTitle.isPresent()) {
    		result.rejectValue("title", "unique", "Title of show already exists");
    	}
    	// Return null if result has errors
    	if(result.hasErrors()){
    		return null;
    	}
		
		return showRepository.save(changeShow);
	}
    
	// Delete a show
	public void deleteShow(Long id) {
		showRepository.deleteById(id);
	}
}
