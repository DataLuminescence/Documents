package com.codingdojo.languages.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	// Adding the book repository as a dependency
	private final LanguageRepository languageRepository;
	
	// Dependency Injection
	public LanguageService(LanguageRepository languageRepository){
		this.languageRepository = languageRepository;
	}

	// Returns all the languages
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
	// Creates an language
	public Language createLanguage(Language b) {
		return languageRepository.save(b);
	}
	// Retrieves an language
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}

	// update a movie
	public Language updateLanguage(Language language) {
		return languageRepository.save(language);
	}

	// Delete an language
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
		
	}
	


 }
