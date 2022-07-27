package com.osama.pokebook.repositories;

import com.osama.pokebook.models.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    List <Expense> findAll();
}
