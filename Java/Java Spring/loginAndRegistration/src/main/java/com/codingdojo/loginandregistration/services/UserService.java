package com.codingdojo.loginandregistration.services;

import java.util.Optional;
    

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
    
import com.codingdojo.loginandregistration.models.LoginUser;
import com.codingdojo.loginandregistration.models.User;
import com.codingdojo.loginandregistration.repositories.UserRepository;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    //
    public User register(User newUser, BindingResult result) {
    	
    	// Use userRepository to conduct a query if email in new user exists in the database
    	Optional <User> potentialUser = userRepository.findByEmail(newUser.getEmail());
    	
		// Reject if email is currently in database
    	if(potentialUser.isPresent()) {
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
    
    
    //
    public User login(LoginUser newLogin, BindingResult result) {
        
    	// Find user in DB by email by using email provided by form
    	Optional <User> potentialUser = userRepository.findByEmail(newLogin.getEmail());
    	
		// Verify that email/username is in the DB if not reject
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "unique", "Unknown Email");
        	return null;
    	}
    	
    	// Get user from DB. By using Optional built in methods.
    	User activeUser = potentialUser.get();

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
    
}
