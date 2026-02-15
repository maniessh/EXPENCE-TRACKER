package com.expensetracker.service;

import com.expensetracker.model.Transaction;
import javafx.scene.chart.PieChart;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChartService {
    private TransactionService transactionService;

    public ChartService() {
        this.transactionService = new TransactionService();
    }

    public Map<String, Double> getExpensesByCategory(int userId) throws SQLException {
        List<Transaction> transactions = transactionService.getTransactionsByUserId(userId);
        Map<String, Double> categoryExpenses = new HashMap<>();

        for (Transaction t : transactions) {
            if ("EXPENSE".equals(t.getType())) {
                String category = t.getCategory() != null ? t.getCategory() : "Other";
                categoryExpenses.put(category, categoryExpenses.getOrDefault(category, 0.0) + t.getAmount());
            }
        }
        return categoryExpenses;
    }

    public Map<String, Double> getIncomeByCategory(int userId) throws SQLException {
        List<Transaction> transactions = transactionService.getTransactionsByUserId(userId);
        Map<String, Double> categoryIncome = new HashMap<>();

        for (Transaction t : transactions) {
            if ("INCOME".equals(t.getType())) {
                String category = t.getCategory() != null ? t.getCategory() : "Other";
                categoryIncome.put(category, categoryIncome.getOrDefault(category, 0.0) + t.getAmount());
            }
        }
        return categoryIncome;
    }
}
