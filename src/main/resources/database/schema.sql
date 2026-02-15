-- Expense Tracker Database Schema

CREATE DATABASE IF NOT EXISTS expense_tracker;
USE expense_tracker;

-- Users Table
CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    full_name VARCHAR(100),
    profile_picture LONGBLOB,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Categories Table
CREATE TABLE IF NOT EXISTS categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL,
    description VARCHAR(200),
    icon VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Transactions Table
CREATE TABLE IF NOT EXISTS transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    category_id INT NOT NULL,
    type ENUM('INCOME', 'EXPENSE') NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    description VARCHAR(255),
    transaction_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES categories(category_id) ON DELETE CASCADE,
    INDEX idx_user_date (user_id, transaction_date),
    INDEX idx_type (type)
);

-- Insert Default Categories
INSERT INTO categories (category_name, description) VALUES
('Salary', 'Income from employment'),
('Freelance', 'Income from freelance projects'),
('Investment', 'Income from investments'),
('Bonus', 'Annual or performance bonus'),
('Food & Dining', 'Groceries and restaurants'),
('Transportation', 'Public transport and fuel'),
('Shopping', 'General shopping and retail'),
('Entertainment', 'Movies, games, and hobbies'),
('Bills & Utilities', 'Electric, water, internet bills'),
('Healthcare', 'Medical expenses'),
('Education', 'Tuition and educational materials'),
('Other', 'Miscellaneous expenses');
