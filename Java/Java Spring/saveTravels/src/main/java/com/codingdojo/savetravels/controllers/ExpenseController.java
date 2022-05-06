package com.codingdojo.savetravels.controllers;

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

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	
	// Create instance of expensesApi? to use its features?
	@Autowired
	private ExpenseService expenseService;	
	
	// all expenses
//	@GetMapping("/expense")
//	public String allExpenses(Model model) {
//		List<Expense> expense = expenseService.allExpenses();
//		model.addAttribute("expenses", expense);
//		return "index.jsp";
//	}
	
	// one expense
	@GetMapping("/expense/{id}")
	public String oneExpense(@PathVariable("id")Long id, Model model) {
		Expense oneExpense= expenseService.findExpense(id);
		model.addAttribute("expense", oneExpense);
		return "show.jsp";
	}
	
	// Used to call the /expense route.
	@GetMapping("/expense")
	// ModelAttribute will serve as an empty expense to fill with form data. Model model is used to 
	// pass expense data from the server to the display part of our index.jsp
	public String index(@ModelAttribute("expense") Expense expense, Model model){
		// Using methods of expenseService create a List of all Expenses in the database
		List<Expense> allExpenses = expenseService.allExpenses();
		// Create a key to call all expenses from JSP file. 
		model.addAttribute("allExpenses", allExpenses);
		return "index.jsp";
	}
	
	// Validates if information entered into forms is valid. If valid we create a new expense then
	// redirect back to reload expense to display the new expense and any others in the database
	@PostMapping("/expense/add")
    public String createExpense(@Valid @ModelAttribute("expense") Expense expense, 
    		BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/expense";
        }
    }
	
}
