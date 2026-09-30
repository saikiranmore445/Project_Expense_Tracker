package com.expenseanalyzer.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.expenseanalyzer.model.Expense;

public class InMemoryExpenseRepository implements ExpenseRepository {

    private final List<Expense> expenses;

    public InMemoryExpenseRepository() {
        expenses = new ArrayList<>();
    }

    @Override
    public void save(Expense expense) {
        expenses.add(expense);
    }

    @Override
    public Optional<Expense> findById(Long expenseId) {

        for (Expense expense : expenses) {

            if (expense.getExpenseId().equals(expenseId)) {
                return Optional.of(expense);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Expense> findAll() {
        return new ArrayList<>(expenses);
    }

    @Override
    public boolean update(Expense updatedExpense) {

        for (int i = 0; i < expenses.size(); i++) {

            Expense existingExpense = expenses.get(i);

            if (existingExpense.getExpenseId()
                    .equals(updatedExpense.getExpenseId())) {

                expenses.set(i, updatedExpense);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean deleteById(Long expenseId) {

        for (int i = 0; i < expenses.size(); i++) {

            if (expenses.get(i).getExpenseId().equals(expenseId)) {

                expenses.remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean existsById(Long expenseId) {

        for (Expense expense : expenses) {

            if (expense.getExpenseId().equals(expenseId)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public long count() {
        return expenses.size();
    }

    @Override
    public void deleteAll() {
        expenses.clear();
    }
}