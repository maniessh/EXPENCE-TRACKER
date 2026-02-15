package com.expensetracker.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Helpers {

    public static String formatCurrency(double amount) {
        return Constants.CURRENCY_SYMBOL + String.format("%.2f", amount);
    }

    public static String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
        return date.format(formatter);
    }

    public static LocalDate parseDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
        return LocalDate.parse(dateString, formatter);
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    public static boolean isValidAmount(String amount) {
        try {
            double value = Double.parseDouble(amount);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void showAlert(String title, String message) {
        System.out.println(title + ": " + message);
    }
}
