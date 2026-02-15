package com.expensetracker.controller;

import com.expensetracker.service.TransactionService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.sql.SQLException;

public class DashboardController {
    
    @FXML
    private Label totalIncomeLabel;
    
    @FXML
    private Label totalExpenseLabel;
    
    @FXML
    private Label balanceLabel;

    private TransactionService transactionService;
    private int currentUserId;

    @FXML
    public void initialize() {
        transactionService = new TransactionService();
    }

    public void loadDashboard(int userId) {
        this.currentUserId = userId;
        updateDashboard();
    }

    private void updateDashboard() {
        try {
            double income = transactionService.getTotalIncome(currentUserId);
            double expense = transactionService.getTotalExpense(currentUserId);
            double balance = income - expense;

            totalIncomeLabel.setText("$" + String.format("%.2f", income));
            totalExpenseLabel.setText("$" + String.format("%.2f", expense));
            balanceLabel.setText("$" + String.format("%.2f", balance));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
