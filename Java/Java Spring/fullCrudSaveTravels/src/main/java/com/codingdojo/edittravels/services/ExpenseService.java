package com.codingdojo.edittravels.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.edittravels.models.Expense;
import com.codingdojo.edittravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	// Adding the book repository as a dependency
	private final ExpenseRepository expenseRepository;
	
	// Dependency Injection
	public ExpenseService(ExpenseRepository expenseRepository){
		this.expenseRepository = expenseRepository;
	}

	// Returns all the expenses
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	// Creates an expense
	public Expense createExpense(Expense b) {
		return expenseRepository.save(b);
	}
	// Retrieves an expense
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	// Update an expense
//	public Expense updateExpense(Long id, String name, String vendor, Integer amount, String description) {
//	    Expense changeExpense = this.findExpense(id);
//	    changeExpense.setName(name);
//	    changeExpense.setVendor(vendor);
//	    changeExpense.setAmount(amount);
//	    changeExpense.setDescription(description);
//	    return expenseRepository.save(changeExpense);
//	}
	
	// update a movie
	public Expense updateExpense(Expense expense) {
		return expenseRepository.save(expense);
	}

	// Delete an expense
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
		
	}
	


 }
