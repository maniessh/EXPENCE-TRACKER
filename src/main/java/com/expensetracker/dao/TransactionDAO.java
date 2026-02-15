package com.expensetracker.dao;

import com.expensetracker.model.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    public boolean addTransaction(Transaction transaction) throws SQLException {
        String query = "INSERT INTO transactions (user_id, category_id, type, amount, description, transaction_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, transaction.getUserId());
            pstmt.setInt(2, transaction.getCategoryId());
            pstmt.setString(3, transaction.getType());
            pstmt.setDouble(4, transaction.getAmount());
            pstmt.setString(5, transaction.getDescription());
            pstmt.setDate(6, java.sql.Date.valueOf(transaction.getTransactionDate()));
            return pstmt.executeUpdate() > 0;
        }
    }

    public List<Transaction> getTransactionsByUserId(int userId) throws SQLException {
        String query = "SELECT * FROM transactions WHERE user_id = ? ORDER BY transaction_date DESC";
        List<Transaction> transactions = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(rs.getInt("transaction_id"));
                transaction.setUserId(rs.getInt("user_id"));
                transaction.setCategoryId(rs.getInt("category_id"));
                transaction.setType(rs.getString("type"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setDescription(rs.getString("description"));
                transaction.setTransactionDate(rs.getDate("transaction_date").toLocalDate());
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    public boolean deleteTransaction(int transactionId) throws SQLException {
        String query = "DELETE FROM transactions WHERE transaction_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, transactionId);
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean updateTransaction(Transaction transaction) throws SQLException {
        String query = "UPDATE transactions SET category_id = ?, type = ?, amount = ?, description = ?, transaction_date = ? WHERE transaction_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, transaction.getCategoryId());
            pstmt.setString(2, transaction.getType());
            pstmt.setDouble(3, transaction.getAmount());
            pstmt.setString(4, transaction.getDescription());
            pstmt.setDate(5, java.sql.Date.valueOf(transaction.getTransactionDate()));
            pstmt.setInt(6, transaction.getTransactionId());
            return pstmt.executeUpdate() > 0;
        }
    }
}
