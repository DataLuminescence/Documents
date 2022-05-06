package com.codingdojo.edittravels.controllers;

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

import com.codingdojo.edittravels.models.Expense;
import com.codingdojo.edittravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	
	// Create instance of expensesApi? to use its features?
	@Autowired
	private ExpenseService expenseService;	
	
	// Displays expenses currently in the database and sets up forms to create new expense
	@GetMapping("/expense")
	// ModelAttribute will serve as an empty expense to fill with form data. Model model is used to 
	// pass expense data from the server to the display part of our index.jsp
	public String renderCreateExpense(@ModelAttribute("expense") Expense expense, Model model){
		
		// Using methods of expenseService create a List of all Expenses in the database
		List<Expense> allExpenses = expenseService.allExpenses();
		// Create a key to call all expenses from JSP file. 
		model.addAttribute("allExpenses", allExpenses);
		return "index.jsp";
	}
	
	// Validates if information entered into forms is valid. If valid we create a new expense then
	// redirect back to reload expense to display the new expense and any others in the database
	@PostMapping("/expense/add")
    public String processCreateExpense(@Valid @ModelAttribute("expense") Expense expense, 
    		BindingResult result, Model model) {
        if (result.hasErrors()) {

    		// Used to display all expenses in the database
    		model.addAttribute("allExpenses", expenseService.allExpenses());
            return "index.jsp";
        } else {
        	// Create expense if validation successful
            expenseService.createExpense(expense);
            return "redirect:/expense";
        }
    }
	
	// 
	@GetMapping("/expense/{id}/edit")
	public String renderEditExpense(@PathVariable("id")Long id, Model model) {
		Expense oneExpense= expenseService.findExpense(id);
		model.addAttribute("expense", oneExpense);
		return "show.jsp";
	}
	
	// process the edit
	@PostMapping("/expense/{id}/edit")
	public String processEditExpense(@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result) {
		if(result.hasErrors()) {
			return "show.jsp";
		}else {
			expenseService.updateExpense(expense);
			return "redirect:/expense";
		}	
	}
	
}
