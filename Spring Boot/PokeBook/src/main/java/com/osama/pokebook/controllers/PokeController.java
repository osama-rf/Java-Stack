package com.osama.pokebook.controllers;


import com.osama.pokebook.models.Expense;
import com.osama.pokebook.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PokeController {

    private  static final String pathExpense = "expense" ;
    private static final String pathExpenses = "expenses";
    @Autowired
    ExpenseService expenseService;


    @RequestMapping("/" + pathExpense)
    public String newExpense(Model model, @ModelAttribute("expense")Expense expense){
        List<Expense> expens = expenseService.allExpenses();
        model.addAttribute(pathExpenses, expens);
        return "index.jsp";
    }

    @RequestMapping(value = "/"+pathExpense, method = RequestMethod.POST)
    public String createExpense(@Valid @ModelAttribute(pathExpense) Expense expense, BindingResult result) {
        if (result.hasErrors()){
            return "index.jsp";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/"+pathExpense;
        }
    }

    @GetMapping("/expense/show/{id}")
    public String showExpense(Model model, @PathVariable("id") Long id){
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expe", expense);
        return "show.jsp";
    }

    @RequestMapping("/expense/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
        return "edit.jsp";
    }

    @RequestMapping(value = "/expense/{id}/submit", method = RequestMethod.POST)
    public String updateExpense(@Valid @ModelAttribute("expense") Expense expense, @PathVariable("id") Long id, BindingResult result) {
        if (result.hasErrors()){
            return "edit.jsp";
        } else {
            expenseService.updateExpense(expense, id);
            return "redirect:/expense";
        }
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
    public String destroy(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expense";
    }
}

