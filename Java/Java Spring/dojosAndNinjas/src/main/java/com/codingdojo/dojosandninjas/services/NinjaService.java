package com.codingdojo.dojosandninjas.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	// Adding the book repository as a dependency
	private final NinjaRepository ninjaRepository;
	
	// Dependency Injection
	public NinjaService(NinjaRepository ninjaRepository){
		this.ninjaRepository = ninjaRepository;
	}

	// Returns all the ninjas
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
	// Creates an ninja
	public Ninja createNinja(Ninja b) {
		return ninjaRepository.save(b);
	}
	// Retrieves an ninja
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	// update a movie
	public Ninja updateNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}

	// Delete an ninja
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
		
	}
	


 }
