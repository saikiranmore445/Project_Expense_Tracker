package com.expenseanalyzer.exception;

public class DuplicateExpenseException extends RuntimeException {

    public DuplicateExpenseException(String message) {
        super(message);
    }
}