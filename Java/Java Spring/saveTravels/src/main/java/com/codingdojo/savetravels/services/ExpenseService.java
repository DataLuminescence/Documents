package com.codingdojo.savetravels.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.repositories.ExpenseRepository;

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
	public Expense updateExpense(Long id, String name, String vendor, Integer amount) {
	    Expense changeExpense = this.findExpense(id);
	    changeExpense.setName(name);
	    changeExpense.setVendor(vendor);
	    changeExpense.setAmount(amount);
	    return expenseRepository.save(changeExpense);
	}

	// Delete an expense
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
		
	}
	


 }
