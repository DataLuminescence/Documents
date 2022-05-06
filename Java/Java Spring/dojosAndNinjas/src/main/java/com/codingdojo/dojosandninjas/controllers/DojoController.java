package com.codingdojo.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.services.DojoService;

@Controller
public class DojoController {
	
	
	// Create instance of dojosApi? to use its features?
	@Autowired
	private DojoService dojoService;	
	
	// Displays dojos currently in the database and sets up forms to create new dojo
	@GetMapping("/dojos")
	// ModelAttribute will serve as an empty dojo to fill with form data. Model model is used to 
	// pass dojo data from the server to the display part of our index.jsp
	public String renderCreateDojo(@ModelAttribute("dojo") Dojo dojo, Model model){
		
		// Using methods of dojoService create a List of all Dojos in the database
		List<Dojo> allDojos = dojoService.allDojos();
		// Create a key to call all dojos from JSP file. 
		model.addAttribute("allDojos", allDojos);
		return "dojopage.jsp";
	}
	
	// Validates if information entered into forms is valid. If valid we create a new dojo then
	// redirect back to reload dojo to display the new dojo and any others in the database
	@PostMapping("/dojos/new")
    public String processCreateDojo(@Valid @ModelAttribute("dojo") Dojo dojo, 
    		BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "dojopage.jsp";
        } else {
        	// Create dojo if validation successful
            dojoService.createDojo(dojo);
            return "redirect:/ninjas";
        }
    }
	
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
	
}
