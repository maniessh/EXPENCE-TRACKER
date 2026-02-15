package com.expensetracker.controller;

import com.expensetracker.model.Transaction;
import com.expensetracker.service.TransactionService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import java.sql.SQLException;
import java.time.LocalDate;

public class IncomeController {
    
    @FXML
    private TextField amountField;
    
    @FXML
    private ComboBox<String> categoryComboBox;
    
    @FXML
    private TextField descriptionField;
    
    @FXML
    private DatePicker datePicker;
    
    @FXML
    private TableView<Transaction> incomeTableView;

    private TransactionService transactionService;
    private int currentUserId;

    @FXML
    public void initialize() {
        transactionService = new TransactionService();
        setupCategoryComboBox();
    }

    private void setupCategoryComboBox() {
        categoryComboBox.getItems().addAll(
            "Salary",
            "Freelance",
            "Investment",
            "Bonus",
            "Other"
        );
    }

    @FXML
    public void handleAddIncome() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String category = categoryComboBox.getValue();
            String description = descriptionField.getText();
            LocalDate date = datePicker.getValue();

            if (category == null || date == null) {
                System.out.println("Please fill all fields");
                return;
            }

            Transaction transaction = new Transaction(currentUserId, 1, "INCOME", amount, description, date);
            transaction.setCategory(category);
            
            if (transactionService.addTransaction(transaction)) {
                clearFields();
                System.out.println("Income added successfully");
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        amountField.clear();
        categoryComboBox.setValue(null);
        descriptionField.clear();
        datePicker.setValue(null);
    }

    public void setCurrentUserId(int userId) {
        this.currentUserId = userId;
    }
}
