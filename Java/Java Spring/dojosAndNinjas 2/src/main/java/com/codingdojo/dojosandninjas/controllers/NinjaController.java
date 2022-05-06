package com.codingdojo.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.services.DojoService;
import com.codingdojo.dojosandninjas.services.NinjaService;

@Controller
public class NinjaController {
	
	
	// Create instance of dojosApi? to use its features?
	@Autowired
	private NinjaService ninjaService;	
	
	@Autowired
	private DojoService dojoService;	
	
	// Displays dojos currently in the database and sets up forms to create new dojo
	@GetMapping("/ninjas")
	// ModelAttribute will serve as an empty dojo to fill with form data. Model model is used to 
	// pass dojo data from the server to the display part of our index.jsp
	public String renderCreateNinja(@ModelAttribute("ninja") Ninja ninja, Model model){
		
		// Using methods of dojoService create a List of all Dojos in the database
		List<Dojo> allDojos = dojoService.allDojos();
		// Create a key to call all dojos from JSP file. 
		model.addAttribute("allDojos", allDojos);
		return "ninjapage.jsp";
	}
	
	// Validates if information entered into forms is valid. If valid we create a new dojo then
	// redirect back to reload dojo to display the new dojo and any others in the database
	@PostMapping("/ninjas/new")
    public String processCreateNinja(@Valid @ModelAttribute("ninja") Ninja ninja, 
    		BindingResult result, Model model) {
        if (result.hasErrors()) {

    		// Using methods of dojoService create a List of all Dojos in the database
    		List<Dojo> allDojos = dojoService.allDojos();
    		// Create a key to call all dojos from JSP file. 
    		model.addAttribute("allDojos", allDojos);
            return "index.jsp";
        } else {
        	// Create dojo if validation successful
            ninjaService.createNinja(ninja);
            return "redirect:/dojos/show";
        }
    }
	
	// Render show page
	@GetMapping("/dojos/show")
	public String showDojos(Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos", allDojos);
	  	return "alldojos.jsp";
	}
	
	@GetMapping("/dojos/show/{id}")
	public String showNinjasInDojos(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "dojosandninjas.jsp";
	}
//	
//	// Render Edit page
//	@GetMapping("/ninja/{id}/edit")
//	public String renderEditNinja(@PathVariable("id")Long id, Model model) {
//		Ninja oneNinja= ninjaService.findNinja(id);
//		model.addAttribute("ninja", oneNinja);
//		return "edit.jsp";
//	}
//	
//	// Process edit page forms
//	@PostMapping("/dojo/{id}/edit")
//	public String processEditNinja(@Valid @ModelAttribute("ninja") Ninja ninja,
//			BindingResult result) {
//		if(result.hasErrors()) {
//			return "edit.jsp";
//		}else {
//			ninjaService.updateNinja(ninja);
//			return "redirect:/ninja";
//		}	
//	}
//	
//	// Delete dojo by id
//	@PostMapping("/ninja/{id}/delete")
//	public String destroy(@PathVariable("id") Long id) {
//		ninjaService.deleteNinja(id);
//	  	return "redirect:/ninja";
//	}
//	
}
