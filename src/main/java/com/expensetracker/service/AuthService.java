package com.expensetracker.service;

import com.expensetracker.dao.UserDAO;
import com.expensetracker.model.User;
import java.sql.SQLException;

public class AuthService {
    private UserDAO userDAO;

    public AuthService() {
        this.userDAO = new UserDAO();
    }

    public boolean login(String username, String password) throws SQLException {
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public boolean register(String username, String email, String password, String fullName) throws SQLException {
        if (userDAO.getUserByUsername(username) != null) {
            return false; // User already exists
        }
        User newUser = new User(username, email, password, fullName);
        return userDAO.addUser(newUser);
    }

    public User getUserByUsername(String username) throws SQLException {
        return userDAO.getUserByUsername(username);
    }
}
