package com.expenseanalyzer.util;

import java.time.LocalDate;

public final class ValidationUtil {

    // Prevent object creation
    private ValidationUtil() {
    }

    // =========================================================
    // VALIDATE EXPENSE ID
    // =========================================================

    public static boolean isValidExpenseId(Long expenseId) {

        return expenseId != null && expenseId > 0;
    }

    // =========================================================
    // VALIDATE AMOUNT
    // =========================================================

    public static boolean isValidAmount(double amount) {

        return amount > 0;
    }

    // =========================================================
    // VALIDATE DESCRIPTION
    // =========================================================

    public static boolean isValidDescription(
            String description) {

        return description != null
                && !description.trim().isEmpty();
    }

    // =========================================================
    // VALIDATE DATE
    // =========================================================

    public static boolean isValidDate(LocalDate date) {

        return date != null;
    }

    // =========================================================
    // VALIDATE DATE IS NOT IN FUTURE
    // =========================================================

    public static boolean isDateNotInFuture(
            LocalDate date) {

        return date != null
                && !date.isAfter(LocalDate.now());
    }

    // =========================================================
    // VALIDATE STRING
    // =========================================================

    public static boolean isValidString(String value) {

        return value != null
                && !value.trim().isEmpty();
    }

    // =========================================================
    // VALIDATE AMOUNT RANGE
    // =========================================================

    public static boolean isValidAmountRange(
            double minimum,
            double maximum) {

        return minimum >= 0
                && maximum >= 0
                && minimum <= maximum;
    }
}