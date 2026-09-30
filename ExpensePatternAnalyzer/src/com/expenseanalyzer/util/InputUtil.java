package com.expenseanalyzer.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public final class InputUtil {

    private static final Scanner scanner =
            new Scanner(System.in);

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    // Prevent object creation
    private InputUtil() {
    }

    // =========================================================
    // READ STRING
    // =========================================================

    public static String readString(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {

                return input;
            }

            ConsoleUtil.printError(
                    "Input cannot be empty."
            );
        }
    }

    // =========================================================
    // READ INTEGER
    // =========================================================

    public static int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                ConsoleUtil.printError(
                        "Please enter a valid integer."
                );
            }
        }
    }

    // =========================================================
    // READ LONG
    // =========================================================

    public static long readLong(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {

                return Long.parseLong(input);

            } catch (NumberFormatException e) {

                ConsoleUtil.printError(
                        "Please enter a valid number."
                );
            }
        }
    }

    // =========================================================
    // READ DOUBLE
    // =========================================================

    public static double readDouble(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {

                return Double.parseDouble(input);

            } catch (NumberFormatException e) {

                ConsoleUtil.printError(
                        "Please enter a valid amount."
                );
            }
        }
    }

    // =========================================================
    // READ DATE
    // =========================================================

    public static LocalDate readDate() {

    while (true) {

        System.out.print("Enter Date (DD-MM-YYYY): ");

        String input = scanner.nextLine().trim();

        try {

            return LocalDate.parse(
                    input,
                    DATE_FORMATTER
            );

        } catch (DateTimeParseException e) {

            ConsoleUtil.printError(
                    "Invalid date. Use format DD-MM-YYYY."
            );
        }
    }
}

    // =========================================================
    // READ POSITIVE DOUBLE
    // =========================================================

    public static double readPositiveDouble(
            String message) {

        while (true) {

            double value = readDouble(message);

            if (value > 0) {

                return value;
            }

            ConsoleUtil.printError(
                    "Amount must be greater than zero."
            );
        }
    }

    // =========================================================
    // READ POSITIVE INTEGER
    // =========================================================

    public static int readPositiveInt(
            String message) {

        while (true) {

            int value = readInt(message);

            if (value > 0) {

                return value;
            }

            ConsoleUtil.printError(
                    "Value must be greater than zero."
            );
        }
    }
}