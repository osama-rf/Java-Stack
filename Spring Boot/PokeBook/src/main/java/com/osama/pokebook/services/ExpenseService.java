package com.osama.pokebook.services;


import com.osama.pokebook.models.Expense;
import com.osama.pokebook.repositories.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    // Adding the expense repository as a dependency
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    // return all the expenses
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }

    // create a expense
    public Expense createExpense(Expense expense){
        return expenseRepository.save(expense);
    }

    // retrieves a expense
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            return optionalExpense.get();
        } else {
            return null;
        }
    }

    //  Delete expenses
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

}
