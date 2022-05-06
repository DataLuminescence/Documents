package com.codingdojo.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class OmikujiController {
	
	@RequestMapping("")
	public String form(){
		return "form.jsp";
	}
	
	@RequestMapping(value="/processForm",method = RequestMethod.POST)
    public String formProcess(@RequestParam(value="number") Integer number, 
    		@RequestParam(value="city") String city,
    		@RequestParam(value="name") String name,
    		@RequestParam(value="activity") String activity,
    		@RequestParam(value="being") String being,
    		@RequestParam(value="comment") String comment, 
    		HttpSession session){

    	session.setAttribute("number",number);
    	session.setAttribute("city", city);
    	session.setAttribute("name", name);
    	session.setAttribute("activity", activity);
    	session.setAttribute("being",being);
    	session.setAttribute("comment",comment);
    	return "redirect:/omikuji/show";
	}
	
    @RequestMapping("/show")
    public String show() {
    	return "show.jsp";
    }
}
