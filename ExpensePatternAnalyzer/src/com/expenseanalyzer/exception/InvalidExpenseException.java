package com.expenseanalyzer.exception;

public class InvalidExpenseException extends RuntimeException {

    public InvalidExpenseException(String message) {
        super(message);
    }
}