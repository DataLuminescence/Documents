package com.codingdojo.dojosandninjas.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	// Adding the book repository as a dependency
	private final DojoRepository dojoRepository;
	
	// Dependency Injection
	public DojoService(DojoRepository dojoRepository){
		this.dojoRepository = dojoRepository;
	}

	// Returns all the dojos
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}
	// Creates an dojo
	public Dojo createDojo(Dojo b) {
		return dojoRepository.save(b);
	}
	// Retrieves an dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	// Update an dojo
//	public Dojo updateDojo(Long id, String name, String vendor, Integer amount, String description) {
//	    Dojo changeDojo = this.findDojo(id);
//	    changeDojo.setName(name);
//	    changeDojo.setVendor(vendor);
//	    changeDojo.setAmount(amount);
//	    changeDojo.setDescription(description);
//	    return dojoRepository.save(changeDojo);
//	}
	
	// update a movie
	public Dojo updateDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}

	// Delete an dojo
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
		
	}
	


 }
