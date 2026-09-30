package com.expenseanalyzer.util;

import com.expenseanalyzer.dto.ExpenseDTO;
import com.expenseanalyzer.model.Expense;

public final class ExpenseMapper {

    // Prevent object creation
    private ExpenseMapper() {
    }

    // =========================================================
    // DTO → ENTITY / MODEL
    // =========================================================

    public static Expense toExpense(ExpenseDTO dto) {

        if (dto == null) {
            return null;
        }

        return new Expense(
                dto.getExpenseId(),
                dto.getAmount(),
                dto.getCategory(),
                dto.getDescription(),
                dto.getExpenseDate(),
                dto.getPaymentMethod(),
                dto.getExpenseType()
        );
    }

    // =========================================================
    // ENTITY / MODEL → DTO
    // =========================================================

    public static ExpenseDTO toDTO(Expense expense) {

        if (expense == null) {
            return null;
        }

        return new ExpenseDTO(
                expense.getExpenseId(),
                expense.getAmount(),
                expense.getCategory(),
                expense.getDescription(),
                expense.getExpenseDate(),
                expense.getPaymentMethod(),
                expense.getExpenseType()
        );
    }
}