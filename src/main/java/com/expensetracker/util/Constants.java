package com.expensetracker.util;

public class Constants {
    // Application
    public static final String APP_NAME = "Expense Tracker";
    public static final String APP_VERSION = "1.0.0";

    // Transaction Types
    public static final String TYPE_INCOME = "INCOME";
    public static final String TYPE_EXPENSE = "EXPENSE";

    // Default Categories
    public static final String[] EXPENSE_CATEGORIES = {
        "Food & Dining",
        "Transportation",
        "Shopping",
        "Entertainment",
        "Bills & Utilities",
        "Healthcare",
        "Education",
        "Other"
    };

    public static final String[] INCOME_CATEGORIES = {
        "Salary",
        "Freelance",
        "Investment",
        "Bonus",
        "Other"
    };

    // Currency
    public static final String CURRENCY_SYMBOL = "$";

    // Date Format
    public static final String DATE_FORMAT = "yyyy-MM-dd";
}
