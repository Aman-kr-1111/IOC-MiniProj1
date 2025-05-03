# 📋 Spring Customer Management System

## 📖 Overview
This project is a **Spring-based Customer Management System** demonstrating:
- ✅ Real-time **Dependency Injection (DI)**
- 🧠 Use of the **Strategy Design Pattern**

It allows storing customer details (name, address, bill amount, discount, final amount) into a **MySQL** or **Oracle** database.

🔧 Key Features:
- 🛠️ Modular architecture with **DAO layer** for database operations  
- 🔄 Switch between **MySQL** and **Oracle** databases via configuration  
- 📊 Dynamically calculate **discounts** and **final bill amounts**  
- 🧪 JUnit 5 setup for testing (config ready, test not implemented)  
- ⚡ Uses **Spring IoC** for loose coupling & **HikariCP** for fast connection pooling  

---

## 🏗️ Project Structure
├── src
│ ├── main
│ │ ├── java
│ │ │ └── com.nt
│ │ │ ├── controller
│ │ │ │ └── CustomerOperationController.java
│ │ │ ├── dao
│ │ │ │ ├── CustomerMYSQLDAOImpl.java
│ │ │ │ ├── CustomerOracleDAOImpl.java
│ │ │ │ └── ICustomerDAO.java
│ │ │ ├── model
│ │ │ │ └── Customer.java
│ │ │ ├── service
│ │ │ │ ├── CustomerMgmtServiceImpl.java
│ │ │ │ └── ICustomerMgmtService.java
│ │ │ └── test
│ │ │ └── RealtimeDITest.java
│ │ └── resources
│ │ ├── com/nt/cfgs
│ │ │ └── applicationContext.xml
│ │ └── com/nt/commons
│ │ └── Info.properties
├── pom.xml
└── README.md

yaml
Copy
Edit

---

## ⚙️ Technologies Used
| 🔧 Tool            | 📌 Version            |
|--------------------|-----------------------|
| ☕ Java             | 17                    |
| 🌱 Spring Framework| 6.2.5 (IoC, JDBC)     |
| 📦 Maven           | 4.0.0                 |
| 🐬 MySQL Connector | 9.2.0                 |
| 🍊 Oracle JDBC     | 23.7.0.25.01          |
| 💧 HikariCP        | 6.2.1                 |
| 🧪 JUnit           | 5.11.0                |
| 🛠️ Config Style    | XML-based             |

---

## 🚀 Getting Started

### ✅ Prerequisites
- Java 17 installed
- Maven installed
- MySQL or Oracle server running
- IDE like IntelliJ IDEA / Eclipse

---

### 🛠️ Installation

1. **Clone the repo**
   ```bash
   git clone https://github.com/your-username/your-repo-name.git
   cd your-repo-name
Set up database

For MySQL:

sql
Copy
Edit
CREATE DATABASE NTSPBMS716DB;
USE NTSPBMS716DB;

CREATE TABLE SPRING_CUSTOMER_INFO (
    CNO INT PRIMARY KEY AUTO_INCREMENT,
    CNAME VARCHAR(50),
    CADDRS VARCHAR(100),
    BILLAMT DOUBLE,
    DISCOUNT DOUBLE,
    FINALAMOUNT DOUBLE
);
For Oracle:

sql
Copy
Edit
CREATE TABLE SPRING_CUSTOMER_INFO (
    CNO NUMBER PRIMARY KEY,
    CNAME VARCHAR2(50),
    CADDRS VARCHAR2(100),
    BILLAMT NUMBER(10,2),
    DISCOUNT NUMBER(5,2),
    FINALAMOUNT NUMBER(10,2)
);
CREATE SEQUENCE CNO_SEQ1 START WITH 1 INCREMENT BY 1;
⚙️ Configure Info.properties
Location: src/main/resources/com/nt/commons/Info.properties

✅ MySQL:

properties
Copy
Edit
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql:///NTSPBMS716DB
jdbc.username=root
jdbc.password=root
dao.id=custDAO-mysql
🔁 Oracle (Uncomment):

properties
Copy
Edit
# jdbc.driver=oracle.jdbc.driver.OracleDriver
# jdbc.url=jdbc:oracle:thin:@localhost:1521:xe
# jdbc.username=system
# jdbc.password=tiger
# dao.id=custDAO-oracle
🔨 Build the Project
bash
Copy
Edit
mvn clean install
▶️ Run the Application
Run the main class:

java
Copy
Edit
// RealtimeDITest.java
public class RealtimeDITest {
    public static void main(String[] args) {
        // code to launch Spring and interact
    }
}
Provide customer details in terminal:

Name

Address

Bill amount

Discount %

📝 Example Usage
✅ MySQL Example
Input:

yaml
Copy
Edit
Enter customer name:: John Doe
Enter customer address:: 123 Main St
Enter customer bill amount:: 1000
Enter discount percentage:: 10
Output:

cpp
Copy
Edit
Customer Registered having BillAmount::1000.0 Discount Amount::100.0 final Amount::900.0
Check in DB:

sql
Copy
Edit
SELECT * FROM SPRING_CUSTOMER_INFO;
CNO	CNAME	CADDRS	BILLAMT	DISCOUNT	FINALAMOUNT
1	John Doe	123 Main St	1000.0	10.0	900.0

🟠 Oracle Example
Update Info.properties for Oracle (as shown earlier), then rerun.

Input:

yaml
Copy
Edit
Enter customer name:: Jane Smith
Enter customer address:: 456 Oak Ave
Enter customer bill amount:: 2000
Enter discount percentage:: 15
Output:

cpp
Copy
Edit
Customer Registered having BillAmount::2000.0 Discount Amount::300.0 final Amount::1700.0
DB Output:

CNO	CNAME	CADDRS	BILLAMT	DISCOUNT	FINALAMOUNT
1	Jane Smith	456 Oak Ave	2000.0	15.0	1700.0

⚙️ How It Works
🎮 Controller Layer (CustomerOperationController)
Accepts user input

Delegates to service layer

Uses @Autowired for DI

🧠 Service Layer (CustomerMgmtServiceImpl)
Calculates discount & final amount

Calls DAO for data persistence

Uses @Qualifier("db") for dynamic DAO selection

🗄️ DAO Layer (CustomerMYSQLDAOImpl, CustomerOracleDAOImpl)
Implements ICustomerDAO

Uses HikariCP for pooling

MySQL → uses AUTO_INCREMENT

Oracle → uses SEQUENCE

🧾 Configuration
🗂️ applicationContext.xml:

Configures:

HikariCP DataSource

Component scanning

Loads Info.properties

📝 Info.properties:

Defines JDBC settings

DAO bean ID (e.g., custDAO-mysql or custDAO-oracle)

🧪 Main Class (RealtimeDITest)
Loads Spring container

Fetches controller bean

Accepts user input and processes it

📌 Notes
XML config used for simplicity. Can be extended to annotation/Java-based config.

Make sure DB server is running before executing.

Update DB credentials in Info.properties.

Oracle driver may need manual addition to your Maven repo.

🤝 Contributing
Fork this repo

Create a new branch

bash
Copy
Edit
git checkout -b feature-branch
Commit your changes

bash
Copy
Edit
git commit -m "Add feature"
Push the branch

bash
Copy
Edit
git push origin feature-branch
Open a Pull Request

📬 Contact
For issues or queries, please raise a ticket on GitHub Issues

Happy Coding! 🚀
