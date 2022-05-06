package com.codingdojo.languages.controllers;

import java.util.List;

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

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class LanguageController {
	
	
	// Create instance of languagesApi? to use its features?
	@Autowired
	private LanguageService languageService;	
	
	// Displays languages currently in the database and sets up forms to create new language
	@GetMapping("/language")
	// ModelAttribute will serve as an empty language to fill with form data. Model model is used to 
	// pass language data from the server to the display part of our index.jsp
	public String renderCreateLanguage(@ModelAttribute("language") Language language, Model model){
		
		// Using methods of languageService create a List of all Languages in the database
		List<Language> allLanguages = languageService.allLanguages();
		// Create a key to call all languages from JSP file. 
		model.addAttribute("allLanguages", allLanguages);
		return "index.jsp";
	}
	
	// Validates if information entered into forms is valid. If valid we create a new language then
	// redirect back to reload language to display the new language and any others in the database
	@PostMapping("/language/add")
    public String processCreateLanguage(@Valid @ModelAttribute("language") Language language, 
    		BindingResult result, Model model) {
        if (result.hasErrors()) {

    		// Used to display all languages in the database
    		model.addAttribute("allLanguages", languageService.allLanguages());
            return "index.jsp";
        } else {
        	// Create language if validation successful
            languageService.createLanguage(language);
            return "redirect:/language";
        }
    }
	
	// Render show page
	@GetMapping("/language/{id}/show")
	public String renderShowLanguage(@PathVariable("id") Long id, Model model) {
		Language oneLanguage= languageService.findLanguage(id);
		model.addAttribute("language", oneLanguage);
	  	return "show.jsp";
	}
	
	// Render Edit page
	@GetMapping("/language/{id}/edit")
	public String renderEditLanguage(@PathVariable("id")Long id, Model model) {
		Language oneLanguage= languageService.findLanguage(id);
		model.addAttribute("language", oneLanguage);
		return "edit.jsp";
	}

	// Process edit page forms
	@PutMapping("/language/{id}/edit")
	public String processEditLanguage2(@Valid @ModelAttribute("language") Language language,
			BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			languageService.updateLanguage(language);
			return "redirect:/language";
		}	
	}
	
	// Delete language by it (alternative)
    @DeleteMapping("/language/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/language";
    }
}
