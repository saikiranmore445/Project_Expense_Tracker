package com.expenseanalyzer.dto;

import java.time.LocalDate;

import com.expenseanalyzer.enums.Category;
import com.expenseanalyzer.enums.ExpenseType;
import com.expenseanalyzer.enums.PaymentMethod;

public class ExpenseDTO {

    private Long expenseId;
    private double amount;
    private Category category;
    private String description;
    private LocalDate expenseDate;
    private PaymentMethod paymentMethod;
    private ExpenseType expenseType;

    public ExpenseDTO() {
    }

    public ExpenseDTO(
            Long expenseId,
            double amount,
            Category category,
            String description,
            LocalDate expenseDate,
            PaymentMethod paymentMethod,
            ExpenseType expenseType) {

        this.expenseId = expenseId;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.expenseDate = expenseDate;
        this.paymentMethod = paymentMethod;
        this.expenseType = expenseType;
    }

    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }
}