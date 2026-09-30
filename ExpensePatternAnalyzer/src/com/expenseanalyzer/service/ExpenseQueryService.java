package com.expenseanalyzer.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.expenseanalyzer.enums.Category;
import com.expenseanalyzer.enums.ExpenseType;
import com.expenseanalyzer.model.Expense;
import com.expenseanalyzer.repository.ExpenseRepository;

public class ExpenseQueryService {

    private final ExpenseRepository expenseRepository;

    // Constructor
    public ExpenseQueryService(
            ExpenseRepository expenseRepository) {

        this.expenseRepository = expenseRepository;
    }

    // =========================================================
    // SEARCH BY DESCRIPTION
    // =========================================================

    public List<Expense> searchByDescription(
            String keyword) {

        return expenseRepository.findAll()
                .stream()
                .filter(expense ->
                        expense.getDescription()
                                .toLowerCase()
                                .contains(
                                        keyword.toLowerCase()
                                )
                )
                .collect(Collectors.toList());
    }

    // =========================================================
    // FILTER BY CATEGORY
    // =========================================================

    public List<Expense> filterByCategory(
            Category category) {

        return expenseRepository.findAll()
                .stream()
                .filter(expense ->
                        expense.getCategory()
                                .equals(category)
                )
                .collect(Collectors.toList());
    }

    // =========================================================
    // FILTER BY EXPENSE TYPE
    // =========================================================

    public List<Expense> filterByExpenseType(
            ExpenseType expenseType) {

        return expenseRepository.findAll()
                .stream()
                .filter(expense ->
                        expense.getExpenseType()
                                .equals(expenseType)
                )
                .collect(Collectors.toList());
    }

    // =========================================================
    // SORT BY AMOUNT - LOW TO HIGH
    // =========================================================

    public List<Expense> sortByAmountAscending() {

        return expenseRepository.findAll()
                .stream()
                .sorted(
                        Comparator.comparingDouble(
                                Expense::getAmount
                        )
                )
                .collect(Collectors.toList());
    }

    // =========================================================
    // SORT BY AMOUNT - HIGH TO LOW
    // =========================================================

    public List<Expense> sortByAmountDescending() {

        return expenseRepository.findAll()
                .stream()
                .sorted(
                        Comparator.comparingDouble(
                                Expense::getAmount
                        ).reversed()
                )
                .collect(Collectors.toList());
    }

    // =========================================================
    // SORT BY DATE - OLDEST FIRST
    // =========================================================

    public List<Expense> sortByDateAscending() {

        return expenseRepository.findAll()
                .stream()
                .sorted(
                        Comparator.comparing(
                                Expense::getExpenseDate
                        )
                )
                .collect(Collectors.toList());
    }

    // =========================================================
    // SORT BY DATE - NEWEST FIRST
    // =========================================================

    public List<Expense> sortByDateDescending() {

        return expenseRepository.findAll()
                .stream()
                .sorted(
                        Comparator.comparing(
                                Expense::getExpenseDate
                        ).reversed()
                )
                .collect(Collectors.toList());
    }

    // =========================================================
    // SORT BY CATEGORY
    // =========================================================

    public List<Expense> sortByCategory() {

        return expenseRepository.findAll()
                .stream()
                .sorted(
                        Comparator.comparing(
                                expense ->
                                        expense.getCategory()
                                                .name()
                        )
                )
                .collect(Collectors.toList());
    }

    // =========================================================
    // FIND EXPENSES ABOVE AMOUNT
    // =========================================================

    public List<Expense> findExpensesAboveAmount(
            double amount) {

        return expenseRepository.findAll()
                .stream()
                .filter(expense ->
                        expense.getAmount() > amount
                )
                .collect(Collectors.toList());
    }

    // =========================================================
    // FIND EXPENSES BELOW AMOUNT
    // =========================================================

    public List<Expense> findExpensesBelowAmount(
            double amount) {

        return expenseRepository.findAll()
                .stream()
                .filter(expense ->
                        expense.getAmount() < amount
                )
                .collect(Collectors.toList());
    }

    // =========================================================
    // FIND EXPENSES WITHIN AMOUNT RANGE
    // =========================================================

    public List<Expense> findExpensesBetweenAmounts(
            double minimum,
            double maximum) {

        return expenseRepository.findAll()
                .stream()
                .filter(expense ->
                        expense.getAmount() >= minimum
                                && expense.getAmount() <= maximum
                )
                .collect(Collectors.toList());
    }
}