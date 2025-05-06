# 📋 Spring Customer Management System

## 📖 Overview

This is a **Spring-based Customer Management System** showcasing:

- ✅ Real-time **Dependency Injection (DI)**
- 🧠 Usage of **Strategy Design Pattern**
- 🗃️ Supports both **MySQL** and **Oracle** databases

It captures customer data (name, address, bill amount, discount %, final amount) and stores it in the database with **HikariCP** connection pooling and **Spring IoC** for loose coupling.


## ✨ Key Features

- 🛠️ Modular architecture with DAO Layer  
- 🔄 Easily switch between **MySQL** and **Oracle** via config  
- 💰 Real-time **discount and final amount calculation**  
- ⚡ Fast DB connections via **HikariCP**  
- 🧪 JUnit 5 integrated (setup done, tests not implemented yet)


## 🗂️ Project Structure

```
📂com/nt
 ┣ 📂 controller
 ┃ ┗ 📄 CustomerOperationController.java
 ┣ 📂 dao
 ┃ ┣ 📄 ICustomerDAO.java
 ┃ ┣ 📄 CustomerMYSQLDAOImpl.java
 ┃ ┗ 📄 CustomerOracleDAOImpl.java
 ┣ 📂 model
 ┃ ┗ 📄 Customer.java
 ┣ 📂 service
 ┃ ┣ 📄 ICustomerMgmtService.java
 ┃ ┗ 📄 CustomerMgmtServiceImpl.java
 ┗ 📂 test
 ┃ ┗ 📄 RealtimeDITest.java
 ┣ 📂 cfgs
 ┃ ┗ 📄 applicationContext.xml
 ┗ 📂 commons
 ┃ ┗ 📄 Info.properties
 ┗ 📄 pom.xml

```


## ⚙️ Technologies Used

| 🔧 Tool / Library     | 📌 Version              |
|-----------------------|-------------------------|
| ☕ Java                | 17                      |
| 🌱 Spring Framework   | 6.2.5                   |
| 📦 Maven              | 4.0.0                   |
| 🐬 MySQL Driver       | mysql-connector-j: 9.2.0|
| 🍊 Oracle Driver      | ojdbc8: 23.7.0.25.01     |
| 💧 HikariCP           | 6.2.1                   |
| 🧪 JUnit              | 5.11.0                  |
| 🛠️ Configuration Type | XML-based               |


## 🚧 Installation (One-Time Setup)

### ✅ Prerequisites

- Java 17 installed  
- Maven installed  
- MySQL or Oracle running  
- IDE like IntelliJ / Eclipse  


## 📥 Clone the Repository

```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
```

## 🗃️ Set Up the Database :🐬 MySQL
```
CREATE DATABASE NTSPBMS716DB;

CREATE TABLE SPRING_CUSTOMER_INFO (
  CNO INT PRIMARY KEY AUTO_INCREMENT,
  CNAME VARCHAR(50),
  CADDRS VARCHAR(100),
  BILLAMT DOUBLE,
  DISCOUNT DOUBLE,
  FINALAMOUNT DOUBLE
);
```

## 🍊 Oracle:
```
CREATE TABLE SPRING_CUSTOMER_INFO (
  CNO NUMBER PRIMARY KEY,
  CNAME VARCHAR2(50),
  CADDRS VARCHAR2(100),
  BILLAMT NUMBER(10,2),
  DISCOUNT NUMBER(5,2),
  FINALAMOUNT NUMBER(10,2)
);

CREATE SEQUENCE CNO_SEQ1 START WITH 1 INCREMENT BY 1;

```


## ⚙️ Configuration `Info.properties` 

## ✅ MySQL properties

- jdbc.driver=com.mysql.cj.jdbc.Driver  
- jdbc.url=jdbc:mysql:///NTSPBMS716DB  
- jdbc.username=root  
- jdbc.password=root  
- dao.id=custDAO-mysql 


## 🟠 Oracle properties

- jdbc.driver=oracle.jdbc.driver.OracleDriver  
- jdbc.url=jdbc:oracle:thin:@localhost:1521:xe  
- jdbc.username=system  
- jdbc.password=tiger  
- dao.id=custDAO-oracle


## ▶️ Run the Application
Run the RealtimeDITest class:

```
public class RealtimeDITest {
    public static void main(String[] args) {
        // Execution starts here
    }
}

```


🐬 MySQL Example

## 📥 Input
```
Enter customer name:: John Doe  
Enter customer address:: 123 Main St  
Enter customer bill amount:: 1000  
Enter discount percentage:: 10
```

## 📤 Output
```
Customer Registered having BillAmount::1000.0  
Discount Amount::100.0  
Final Amount::900.0
```

## 📊 Database Check

```
CNO	CNAME	CADDRS	BILLAMT	DISCOUNT	FINALAMOUNT
1	John Doe	123 Main St	1000.0	10.0	900.0
```

🛢️ Oracle Example

## 📥 Input
```
Enter customer name:: Jane Smith  
Enter customer address:: 456 Oak Ave  
Enter customer bill amount:: 2000  
Enter discount percentage:: 15
```

## 📤 Output
```
Customer Registered having BillAmount::2000.0  
Discount Amount::300.0  
Final Amount::1700.0
```

## 📊 Database Check
```
CNO	CNAME	CADDRS	BILLAMT	DISCOUNT	FINALAMOUNT
1	Jane Smith	456 Oak Ave	2000.0	15.0	1700.0

```

## 🧠 How It Works

1. 🎮 Controller Layer :
- CustomerOperationController
Receives input and delegates to service layer.

- Injected using @Autowired.

2. 🧰 Service Layer :
- CustomerMgmtServiceImpl
Calculates discount and final amount.

- Injects DAO using @Qualifier("db").

3.🗄️DAO Layer
- CustomerMYSQLDAOImpl or CustomerOracleDAOImpl
Persists customer data.

- Uses HikariDataSource for connections.

- MySQL uses AUTO_INCREMENT, Oracle uses CNO_SEQ1.

4. 🧾 Configuration Details : 🧬 applicationContext.xml
- Configures HikariCP.

- Enables component scanning.

- Loads database properties.

5. 🗃️ Info.properties  
- Holds connection details and DAO bean ID

- custDAO-mysql
- custDAO-oracle

6. 🧪 Main Class  
- RealtimeDITest
Loads Spring container using ClassPathXmlApplicationContext.

- Retrieves controller bean and executes logic.

📌 Notes
- ✅ Uses XML-based Spring config.
- 💾 Ensure DB server is running before execution.

- 🔑 Update credentials as per your environment.

- 📦 Oracle JDBC driver (ojdbc8) may require manual installation.

---

## 📧 Contact
- **LinkedIn**: [Aman Kumar](https://www.linkedin.com/in/aman-kumar-64b22b270/)
- **Portfolio**: [Visit Here](https://aman-first-portfolio.netlify.app/)

---

### 🌟 Show your support by giving this repository a ⭐!

🔗 Happy Coding! 🚀
