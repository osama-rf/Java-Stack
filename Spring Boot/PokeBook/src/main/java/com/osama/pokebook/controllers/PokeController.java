package com.osama.pokebook.controllers;


import com.osama.pokebook.models.Expense;
import com.osama.pokebook.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PokeController {

    @Autowired
    ExpenseService expenseService;



    @RequestMapping("/expense")
    public String newExpense(Model model, @ModelAttribute("expense")Expense expense){
        List<Expense> expens = expenseService.allExpenses();
        model.addAttribute("expenses", expens);
        return "index.jsp";
    }

    @RequestMapping(value = "/expense", method = RequestMethod.POST)
    public String createExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()){
            return "index.jsp";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/expense";
        }
    }

    @RequestMapping("/expense/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expens", expense);
        return "edit.jsp";
    }

    @RequestMapping(value = "/expense/edit/{id}", method = RequestMethod.PUT)
    public String updateExpense(@Valid @ModelAttribute("expense") Expense expense, @PathVariable("id") Long id, BindingResult result){
        if (result.hasErrors()){
            return "edit.jsp";
        } else {
            expenseService.updateExpense(expense, id);
            return "redirect:/expense";
        }
    }

//    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
//    public String delete(@PathVariable("id") Long id) {
//        expenseService.deleteExpense(id);
//        return "redirect:/expense";
//    }
}
