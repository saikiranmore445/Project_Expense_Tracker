package com.expenseanalyzer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.expenseanalyzer.enums.Category;
import com.expenseanalyzer.enums.ExpenseType;
import com.expenseanalyzer.enums.PaymentMethod;
import com.expenseanalyzer.model.Expense;
import com.expenseanalyzer.repository.ExpenseRepository;

public class AnalysisService {

    private final ExpenseRepository expenseRepository;

    // Constructor
    public AnalysisService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // Calculate total spending
    public double calculateTotalExpense() {

        List<Expense> expenses = expenseRepository.findAll();

        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        return total;
    }

    // Find highest expense
    public Optional<Expense> getHighestExpense() {

        List<Expense> expenses = expenseRepository.findAll();

        if (expenses.isEmpty()) {
            return Optional.empty();
        }

        Expense highestExpense = expenses.get(0);

        for (Expense expense : expenses) {

            if (expense.getAmount() > highestExpense.getAmount()) {
                highestExpense = expense;
            }
        }

        return Optional.of(highestExpense);
    }

    // Find lowest expense
    public Optional<Expense> getLowestExpense() {

        List<Expense> expenses = expenseRepository.findAll();

        if (expenses.isEmpty()) {
            return Optional.empty();
        }

        Expense lowestExpense = expenses.get(0);

        for (Expense expense : expenses) {

            if (expense.getAmount() < lowestExpense.getAmount()) {
                lowestExpense = expense;
            }
        }

        return Optional.of(lowestExpense);
    }

    // Calculate average expense
    public double calculateAverageExpense() {

        List<Expense> expenses = expenseRepository.findAll();

        if (expenses.isEmpty()) {
            return 0;
        }

        double total = calculateTotalExpense();

        return total / expenses.size();
    }

    // Calculate category-wise spending
    public Map<Category, Double> getCategoryWiseExpenses() {

        List<Expense> expenses = expenseRepository.findAll();

        Map<Category, Double> categoryExpenses = new HashMap<>();

        for (Expense expense : expenses) {

            Category category = expense.getCategory();

            double currentAmount =
                    categoryExpenses.getOrDefault(category, 0.0);

            categoryExpenses.put(
                    category,
                    currentAmount + expense.getAmount()
            );
        }

        return categoryExpenses;
    }

    // Find top spending category
    public Optional<Category> getTopSpendingCategory() {

        Map<Category, Double> categoryExpenses =
                getCategoryWiseExpenses();

        if (categoryExpenses.isEmpty()) {
            return Optional.empty();
        }

        Category topCategory = null;
        double highestAmount = 0;

        for (Map.Entry<Category, Double> entry
                : categoryExpenses.entrySet()) {

            if (entry.getValue() > highestAmount) {

                highestAmount = entry.getValue();
                topCategory = entry.getKey();
            }
        }

        return Optional.of(topCategory);
    }

    // Calculate expense type-wise spending
    public Map<ExpenseType, Double> getExpenseTypeWiseExpenses() {

        List<Expense> expenses = expenseRepository.findAll();

        Map<ExpenseType, Double> typeExpenses = new HashMap<>();

        for (Expense expense : expenses) {

            ExpenseType type = expense.getExpenseType();

            double currentAmount =
                    typeExpenses.getOrDefault(type, 0.0);

            typeExpenses.put(
                    type,
                    currentAmount + expense.getAmount()
            );
        }

        return typeExpenses;
    }

    // Calculate payment-method-wise spending
    public Map<PaymentMethod, Double> getPaymentMethodWiseExpenses() {

        List<Expense> expenses = expenseRepository.findAll();

        Map<PaymentMethod, Double> paymentExpenses =
                new HashMap<>();

        for (Expense expense : expenses) {

            PaymentMethod paymentMethod =
                    expense.getPaymentMethod();

            double currentAmount =
                    paymentExpenses.getOrDefault(paymentMethod, 0.0);

            paymentExpenses.put(
                    paymentMethod,
                    currentAmount + expense.getAmount()
            );
        }

        return paymentExpenses;
    }
}