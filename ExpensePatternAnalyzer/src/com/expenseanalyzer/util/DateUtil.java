package com.expenseanalyzer.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class DateUtil {

    // Date format used throughout the application
    private static final String DATE_PATTERN = "dd-MM-yyyy";

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_PATTERN);

    // Prevent object creation
    private DateUtil() {
    }

    // =========================================================
    // PARSE STRING TO LOCALDATE
    // =========================================================

    public static LocalDate parseDate(String dateText) {

        if (dateText == null || dateText.trim().isEmpty()) {
            return null;
        }

        try {

            return LocalDate.parse(
                    dateText.trim(),
                    DATE_FORMATTER
            );

        } catch (DateTimeParseException e) {

            return null;
        }
    }

    // =========================================================
    // FORMAT LOCALDATE TO STRING
    // =========================================================

    public static String formatDate(LocalDate date) {

        if (date == null) {
            return "";
        }

        return date.format(DATE_FORMATTER);
    }

    // =========================================================
    // CHECK WHETHER STRING IS A VALID DATE
    // =========================================================

    public static boolean isValidDate(String dateText) {

        return parseDate(dateText) != null;
    }

    // =========================================================
    // GET TODAY'S DATE
    // =========================================================

    public static LocalDate getToday() {

        return LocalDate.now();
    }

    // =========================================================
    // CHECK WHETHER DATE IS IN THE FUTURE
    // =========================================================

    public static boolean isFutureDate(LocalDate date) {

        if (date == null) {
            return false;
        }

        return date.isAfter(LocalDate.now());
    }

    // =========================================================
    // CHECK WHETHER DATE IS TODAY
    // =========================================================

    public static boolean isToday(LocalDate date) {

        if (date == null) {
            return false;
        }

        return date.equals(LocalDate.now());
    }

    // =========================================================
    // CHECK WHETHER DATE IS BEFORE TODAY
    // =========================================================

    public static boolean isPastDate(LocalDate date) {

        if (date == null) {
            return false;
        }

        return date.isBefore(LocalDate.now());
    }

    // =========================================================
    // COMPARE TWO DATES
    // =========================================================

    public static boolean isBefore(
            LocalDate firstDate,
            LocalDate secondDate) {

        if (firstDate == null || secondDate == null) {
            return false;
        }

        return firstDate.isBefore(secondDate);
    }

    public static boolean isAfter(
            LocalDate firstDate,
            LocalDate secondDate) {

        if (firstDate == null || secondDate == null) {
            return false;
        }

        return firstDate.isAfter(secondDate);
    }

    // =========================================================
    // CHECK WHETHER DATE IS WITHIN RANGE
    // =========================================================

    public static boolean isWithinRange(
            LocalDate date,
            LocalDate startDate,
            LocalDate endDate) {

        if (date == null
                || startDate == null
                || endDate == null) {

            return false;
        }

        return !date.isBefore(startDate)
                && !date.isAfter(endDate);
    }

    // =========================================================
    // GET DATE PATTERN
    // =========================================================

    public static String getDatePattern() {

        return DATE_PATTERN;
    }
}
