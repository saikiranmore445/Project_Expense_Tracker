package com.expenseanalyzer.service;

import java.time.YearMonth;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.expenseanalyzer.enums.Category;
import com.expenseanalyzer.enums.ExpenseType;
import com.expenseanalyzer.enums.PaymentMethod;
import com.expenseanalyzer.model.Expense;
import com.expenseanalyzer.repository.ExpenseRepository;

public class ReportService {

    private final ExpenseRepository expenseRepository;

    // Constructor
    public ReportService(ExpenseRepository expenseRepository) {

        this.expenseRepository = expenseRepository;
    }

    // =========================================================
    // GENERATE OVERALL REPORT
    // =========================================================

    public String generateOverallReport() {

        List<Expense> expenses =
                expenseRepository.findAll();

        if (expenses.isEmpty()) {

            return "No expenses available for report.";
        }

        double totalAmount = 0;

        for (Expense expense : expenses) {

            totalAmount += expense.getAmount();
        }

        double averageAmount =
                totalAmount / expenses.size();

        StringBuilder report =
                new StringBuilder();

        report.append("\n");
        report.append("==============================================\n");
        report.append("              OVERALL EXPENSE REPORT\n");
        report.append("==============================================\n");

        report.append(
                String.format(
                        "Total Expenses    : %d%n",
                        expenses.size()
                )
        );

        report.append(
                String.format(
                        "Total Spending    : ₹%.2f%n",
                        totalAmount
                )
        );

        report.append(
                String.format(
                        "Average Expense   : ₹%.2f%n",
                        averageAmount
                )
        );

        report.append("----------------------------------------------\n");

        return report.toString();
    }

    // =========================================================
    // CATEGORY REPORT
    // =========================================================

    public String generateCategoryReport() {

        List<Expense> expenses =
                expenseRepository.findAll();

        if (expenses.isEmpty()) {

            return "No expenses available for report.";
        }

        Map<Category, Double> categoryTotals =
                new LinkedHashMap<>();

        for (Expense expense : expenses) {

            Category category =
                    expense.getCategory();

            double currentAmount =
                    categoryTotals.getOrDefault(
                            category,
                            0.0
                    );

            categoryTotals.put(
                    category,
                    currentAmount + expense.getAmount()
            );
        }

        StringBuilder report =
                new StringBuilder();

        report.append("\n");
        report.append("==============================================\n");
        report.append("             CATEGORY EXPENSE REPORT\n");
        report.append("==============================================\n");

        for (Map.Entry<Category, Double> entry
                : categoryTotals.entrySet()) {

            report.append(
                    String.format(
                            "%-20s : ₹%.2f%n",
                            entry.getKey(),
                            entry.getValue()
                    )
            );
        }

        report.append("----------------------------------------------\n");

        return report.toString();
    }

    // =========================================================
    // EXPENSE TYPE REPORT
    // =========================================================

    public String generateExpenseTypeReport() {

        List<Expense> expenses =
                expenseRepository.findAll();

        if (expenses.isEmpty()) {

            return "No expenses available for report.";
        }

        Map<ExpenseType, Double> typeTotals =
                new LinkedHashMap<>();

        for (Expense expense : expenses) {

            ExpenseType type =
                    expense.getExpenseType();

            double currentAmount =
                    typeTotals.getOrDefault(
                            type,
                            0.0
                    );

            typeTotals.put(
                    type,
                    currentAmount + expense.getAmount()
            );
        }

        StringBuilder report =
                new StringBuilder();

        report.append("\n");
        report.append("==============================================\n");
        report.append("            EXPENSE TYPE REPORT\n");
        report.append("==============================================\n");

        for (Map.Entry<ExpenseType, Double> entry
                : typeTotals.entrySet()) {

            report.append(
                    String.format(
                            "%-20s : ₹%.2f%n",
                            entry.getKey(),
                            entry.getValue()
                    )
            );
        }

        report.append("----------------------------------------------\n");

        return report.toString();
    }

    // =========================================================
    // PAYMENT METHOD REPORT
    // =========================================================

    public String generatePaymentMethodReport() {

        List<Expense> expenses =
                expenseRepository.findAll();

        if (expenses.isEmpty()) {

            return "No expenses available for report.";
        }

        Map<PaymentMethod, Double> paymentTotals =
                new LinkedHashMap<>();

        for (Expense expense : expenses) {

            PaymentMethod method =
                    expense.getPaymentMethod();

            double currentAmount =
                    paymentTotals.getOrDefault(
                            method,
                            0.0
                    );

            paymentTotals.put(
                    method,
                    currentAmount + expense.getAmount()
            );
        }

        StringBuilder report =
                new StringBuilder();

        report.append("\n");
        report.append("==============================================\n");
        report.append("          PAYMENT METHOD REPORT\n");
        report.append("==============================================\n");

        for (Map.Entry<PaymentMethod, Double> entry
                : paymentTotals.entrySet()) {

            report.append(
                    String.format(
                            "%-20s : ₹%.2f%n",
                            entry.getKey(),
                            entry.getValue()
                    )
            );
        }

        report.append("----------------------------------------------\n");

        return report.toString();
    }

    // =========================================================
    // MONTHLY REPORT
    // =========================================================

    public String generateMonthlyReport(YearMonth month) {

        List<Expense> expenses =
                expenseRepository.findAll();

        double totalAmount = 0;
        int expenseCount = 0;

        for (Expense expense : expenses) {

            YearMonth expenseMonth =
                    YearMonth.from(
                            expense.getExpenseDate()
                    );

            if (expenseMonth.equals(month)) {

                totalAmount += expense.getAmount();

                expenseCount++;
            }
        }

        StringBuilder report =
                new StringBuilder();

        report.append("\n");
        report.append("==============================================\n");
        report.append("              MONTHLY EXPENSE REPORT\n");
        report.append("==============================================\n");

        report.append(
                String.format(
                        "Month             : %s%n",
                        month
                )
        );

        report.append(
                String.format(
                        "Number of Expenses: %d%n",
                        expenseCount
                )
        );

        report.append(
                String.format(
                        "Total Spending    : ₹%.2f%n",
                        totalAmount
                )
        );

        if (expenseCount > 0) {

            report.append(
                    String.format(
                            "Average Expense   : ₹%.2f%n",
                            totalAmount / expenseCount
                    )
            );
        } else {

            report.append(
                    "Average Expense   : ₹0.00\n"
            );
        }

        report.append("----------------------------------------------\n");

        return report.toString();
    }
}