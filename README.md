# Expense Tracker

A JavaFX-based desktop application for tracking income and expenses with a user-friendly interface and database backend.

## Features

- **User Authentication**: Secure login and registration system
- **Dashboard**: Overview of total income, expenses, and balance
- **Income Management**: Add and track income from various sources
- **Expense Management**: Categorize and track expenses
- **Transaction History**: View all transactions with filtering options
- **Charts & Analytics**: Visual representation of spending patterns
- **User Profile**: Manage user information and settings
- **Dark Theme**: Modern dark-themed user interface

## Project Structure

```
ExpenseTracker/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── expensetracker/
│       │           ├── Main.java
│       │           ├── controller/
│       │           ├── model/
│       │           ├── service/
│       │           ├── dao/
│       │           └── util/
│       └── resources/
│           ├── fxml/
│           ├── css/
│           ├── images/
│           └── database/
├── pom.xml
└── README.md
```

## Prerequisites

- Java 21 or higher
- Maven 3.6+
- MySQL 8.0+

## Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/expense-tracker.git
   cd ExpenseTracker
   ```

2. **Set up the database**
   - Open MySQL and create the database
   - Run the SQL script from `src/main/resources/database/schema.sql`

3. **Update database connection**
   - Edit `DatabaseConnection.java` with your MySQL credentials

4. **Build the project**
   ```bash
   mvn clean install
   ```

## Running the Application

### Using Maven
```bash
mvn clean javafx:run
```

### Using JAR
```bash
mvn clean package
java -jar target/expense-tracker-1.0.0.jar
```

## Usage

1. **Register/Login**: Create a new account or login with existing credentials
2. **Add Transaction**: Go to Income or Expense tab and add new transactions
3. **View Dashboard**: Check your financial overview on the dashboard
4. **Analyze Spending**: Use charts to visualize your spending patterns
5. **Manage Profile**: Update your profile information in the settings

## Dependencies

- **JavaFX 21.0.1**: For the GUI
- **MySQL Connector 8.0.33**: For database connectivity
- **JUnit 4.13.2**: For unit testing

## Technologies Used

- **Java 21**: Programming language
- **JavaFX**: GUI framework
- **MySQL**: Database
- **Maven**: Build tool
- **FXML**: UI markup language

## Features in Development

- [ ] Data export to CSV/PDF
- [ ] Budget planning and alerts
- [ ] Recurring transactions
- [ ] Multi-currency support
- [ ] Cloud backup
- [ ] Mobile app synchronization

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

Created by Expense Tracker Team

## Support

For support, email support@expensetracker.com or create an issue in the GitHub repository.

---

**Note**: Make sure to set up your MySQL database and update the connection credentials before running the application.
