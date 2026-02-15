package com.expensetracker.service;

import com.expensetracker.dao.TransactionDAO;
import com.expensetracker.model.Transaction;
import java.sql.SQLException;
import java.util.List;

public class TransactionService {
    private TransactionDAO transactionDAO;

    public TransactionService() {
        this.transactionDAO = new TransactionDAO();
    }

    public boolean addTransaction(Transaction transaction) throws SQLException {
        if (transaction.getAmount() <= 0) {
            return false; // Invalid amount
        }
        return transactionDAO.addTransaction(transaction);
    }

    public List<Transaction> getTransactionsByUserId(int userId) throws SQLException {
        return transactionDAO.getTransactionsByUserId(userId);
    }

    public double getTotalIncome(int userId) throws SQLException {
        List<Transaction> transactions = transactionDAO.getTransactionsByUserId(userId);
        double total = 0;
        for (Transaction t : transactions) {
            if ("INCOME".equals(t.getType())) {
                total += t.getAmount();
            }
        }
        return total;
    }

    public double getTotalExpense(int userId) throws SQLException {
        List<Transaction> transactions = transactionDAO.getTransactionsByUserId(userId);
        double total = 0;
        for (Transaction t : transactions) {
            if ("EXPENSE".equals(t.getType())) {
                total += t.getAmount();
            }
        }
        return total;
    }

    public boolean deleteTransaction(int transactionId) throws SQLException {
        return transactionDAO.deleteTransaction(transactionId);
    }

    public boolean updateTransaction(Transaction transaction) throws SQLException {
        return transactionDAO.updateTransaction(transaction);
    }
}
