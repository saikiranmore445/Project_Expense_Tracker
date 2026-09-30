package com.expenseanalyzer.model;

import java.time.LocalDate;

import com.expenseanalyzer.enums.Category;
import com.expenseanalyzer.enums.ExpenseType;
import com.expenseanalyzer.enums.PaymentMethod;

public class Expense {

    // Instance variables
    private Long expenseId;
    private double amount;
    private Category category;
    private String description;
    private LocalDate expenseDate;
    private PaymentMethod paymentMethod;
    private ExpenseType expenseType;

    // No-argument constructor
    public Expense() {
    }

    // Parameterized constructor
    public Expense(Long expenseId, double amount, Category category,
                   String description, LocalDate expenseDate,
                   PaymentMethod paymentMethod, ExpenseType expenseType) {

        this.expenseId = expenseId;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.expenseDate = expenseDate;
        this.paymentMethod = paymentMethod;
        this.expenseType = expenseType;
    }

    // Getter and Setter for expenseId
    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    // Getter and Setter for amount
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Getter and Setter for category
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for expenseDate
    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    // Getter and Setter for paymentMethod
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Getter and Setter for expenseType
    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    // toString method
    @Override
    public String toString() {
        return "Expense [expenseId=" + expenseId
                + ", amount=" + amount
                + ", category=" + category
                + ", description=" + description
                + ", expenseDate=" + expenseDate
                + ", paymentMethod=" + paymentMethod
                + ", expenseType=" + expenseType + "]";
    }
}