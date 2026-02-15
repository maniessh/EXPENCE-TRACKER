package com.expensetracker.controller;

import com.expensetracker.dao.UserDAO;
import com.expensetracker.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.sql.SQLException;

public class ProfileController {
    
    @FXML
    private Label usernameLabel;
    
    @FXML
    private TextField emailField;
    
    @FXML
    private TextField fullNameField;

    private UserDAO userDAO;
    private int currentUserId;
    private User currentUser;

    @FXML
    public void initialize() {
        userDAO = new UserDAO();
    }

    public void loadUserProfile(int userId) {
        this.currentUserId = userId;
        try {
            currentUser = userDAO.getUserById(userId);
            if (currentUser != null) {
                usernameLabel.setText(currentUser.getUsername());
                emailField.setText(currentUser.getEmail());
                fullNameField.setText(currentUser.getFullName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleUpdateProfile() {
        try {
            currentUser.setEmail(emailField.getText());
            currentUser.setFullName(fullNameField.getText());
            
            if (userDAO.updateUser(currentUser)) {
                System.out.println("Profile updated successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
