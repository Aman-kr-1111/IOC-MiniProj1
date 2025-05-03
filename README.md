📋 Spring Customer Management System
    
📖 Overview
This project is a Spring-based Customer Management System demonstrating Real-time Dependency Injection (DI) and the Strategy Design Pattern. It allows storing customer information (name, address, bill amount, discount, and final amount) in a database, with support for both MySQL and Oracle databases. The application uses Spring IoC for loose coupling and HikariCP for connection pooling.
Key features:

🛠️ Modular architecture with DAO layer for database operations.
🔄 Switch between MySQL and Oracle databases via configuration.
📊 Calculate discounts and final bill amounts dynamically.
🧪 JUnit 5 for testing (configured but not implemented in this code).

🏗️ Project Structure
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.nt
│   │   │       ├── controller
│   │   │       │   └── CustomerOperationController.java
│   │   │       ├── dao
│   │   │       │   ├── CustomerMYSQLDAOImpl.java
│   │   │       │   ├── CustomerOracleDAOImpl.java
│   │   │       │   └── ICustomerDAO.java
│   │   │       ├── model
│   │   │       │   └── Customer.java
│   │   │       ├── service
│   │   │       │   ├── CustomerMgmtServiceImpl.java
│   │   │       │   └── ICustomerMgmtService.java
│   │   │       └── test
│   │   │           └── RealtimeDITest.java
│   │   └── resources
│   │       ├── com/nt/cfgs
│   │       │   └── applicationContext.xml
│   │       └── com/nt/commons
│   │           └── Info.properties
├── pom.xml
└── README.md

⚙️ Technologies Used

Java: 17
Spring Framework: 6.2.5 (spring-context-support, spring-jdbc)
Maven: 4.0.0
Databases:
MySQL (mysql-connector-j: 9.2.0)
Oracle (ojdbc8: 23.7.0.25.01)


Connection Pooling: HikariCP 6.2.1
Testing: JUnit 5.11.0
Configuration: Spring XML-based configuration

🚀 Getting Started
Prerequisites

Java 17 installed
Maven installed
MySQL or Oracle database server running
IDE (e.g., IntelliJ IDEA, Eclipse) recommended

Installation

Clone the repository:
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name


Set up the database:

For MySQL:
Create a database named NTSPBMS716DB.
Create the table:CREATE TABLE SPRING_CUSTOMER_INFO (
    CNO INT PRIMARY KEY AUTO_INCREMENT,
    CNAME VARCHAR(50),
    CADDRS VARCHAR(100),
    BILLAMT DOUBLE,
    DISCOUNT DOUBLE,
    FINALAMOUNT DOUBLE
);




For Oracle:
Create a schema and table:CREATE TABLE SPRING_CUSTOMER_INFO (
    CNO NUMBER PRIMARY KEY,
    CNAME VARCHAR2(50),
    CADDRS VARCHAR2(100),
    BILLAMT NUMBER(10,2),
    DISCOUNT NUMBER(5,2),
    FINALAMOUNT NUMBER(10,2)
);
CREATE SEQUENCE CNO_SEQ1 START WITH 1 INCREMENT BY 1;






Configure database properties:

Edit src/main/resources/com/nt/commons/Info.properties:
For MySQL (already configured):jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql:///NTSPBMS716DB
jdbc.username=root
jdbc.password=root
dao.id=custDAO-mysql


For Oracle (uncomment and configure):jdbc.driver=oracle.jdbc.driver.OracleDriver
jdbc.url=jdbc:oracle:thin:@localhost:1521:xe
jdbc.username=system
jdbc.password=tiger
dao.id=custDAO-oracle






Build the project:
mvn clean install


Run the application:

Execute the RealtimeDITest class:public class RealtimeDITest {
    public static void main(String[] args) { ... }
}


Input customer details (name, address, bill amount, discount percentage) when prompted.



📝 Example Usage
MySQL Example

Ensure MySQL is configured in Info.properties (as shown above).
Run RealtimeDITest.
Input:Enter customer name:: John Doe
Enter customer address:: 123 Main St
Enter customer bill amount:: 1000
Enter discount percentage:: 10


Output:Customer Registered having BillAmount::1000.0 Discount Amount::100.0 final Amount::900.0


Check the SPRING_CUSTOMER_INFO table in MySQL:SELECT * FROM SPRING_CUSTOMER_INFO;

Expected result:CNO | CNAME     | CADDRS       | BILLAMT | DISCOUNT | FINALAMOUNT
1   | John Doe  | 123 Main St  | 1000.0  | 10.0     | 900.0



Oracle Example

Update Info.properties for Oracle (as shown above).
Run RealtimeDITest.
Input:Enter customer name:: Jane Smith
Enter customer address:: 456 Oak Ave
Enter customer bill amount:: 2000
Enter discount percentage:: 15


Output:Customer Registered having BillAmount::2000.0 Discount Amount::300.0 final Amount::1700.0


Check the SPRING_CUSTOMER_INFO table in Oracle:SELECT * FROM SPRING_CUSTOMER_INFO;

Expected result:CNO | CNAME      | CADDRS      | BILLAMT | DISCOUNT | FINALAMOUNT
1   | Jane Smith | 456 Oak Ave | 2000.0  | 15.0     | 1700.0



🛠️ How It Works

Controller Layer (CustomerOperationController):

Receives customer data and delegates to the service layer.
Uses @Autowired to inject the service.


Service Layer (CustomerMgmtServiceImpl):

Calculates discount and final amount.
Calls the DAO layer to persist data.
Uses @Qualifier("db") to inject the appropriate DAO based on Info.properties.


DAO Layer (CustomerMYSQLDAOImpl or CustomerOracleDAOImpl):

Implements ICustomerDAO to insert customer data.
Uses HikariCP (HikariDataSource) for efficient database connections.
MySQL uses AUTO_INCREMENT for the primary key, while Oracle uses a sequence (CNO_SEQ1).


Configuration:

applicationContext.xml:
Configures HikariCP as the DataSource.
Enables component scanning for @Component, @Service, @Repository.
Loads properties from Info.properties using <context:property-placeholder>.


Info.properties:
Specifies database connection details and DAO bean ID (custDAO-mysql or custDAO-oracle).




Main Application (RealtimeDITest):

Creates a Spring IoC container using ClassPathXmlApplicationContext.
Retrieves the controller bean and processes user input.



📌 Notes

The project uses XML-based Spring configuration for simplicity. You can extend it to use Java-based or annotation-based configuration.
Ensure the database server is running before executing the application.
Update the database credentials in Info.properties to match your environment.
The Oracle JDBC driver (ojdbc8) may require manual installation in your Maven repository if not available in the central repository.

🤝 Contributing
Contributions are welcome! Please follow these steps:

Fork the repository.
Create a new branch (git checkout -b feature-branch).
Make your changes and commit (git commit -m "Add feature").
Push to the branch (git push origin feature-branch).
Create a Pull Request.

📬 Contact
For any queries, reach out via GitHub Issues.

Happy Coding! 🚀
