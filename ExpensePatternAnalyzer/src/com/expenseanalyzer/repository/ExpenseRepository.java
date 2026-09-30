package com.expenseanalyzer.repository;

import java.util.List;
import java.util.Optional;

import com.expenseanalyzer.model.Expense;

public interface ExpenseRepository {

    void save(Expense expense);

    Optional<Expense> findById(Long expenseId);

    List<Expense> findAll();

    boolean update(Expense expense);

    boolean deleteById(Long expenseId);

    boolean existsById(Long expenseId);

    long count();

    void deleteAll();
}