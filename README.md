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

## 🚧 Installation (One-Time Setup)

### ✅ Prerequisites
- Java 17 installed
- Maven installed
- MySQL or Oracle server running
- IDE like IntelliJ IDEA / Eclipse

---

### 📥 Clone the Repository

```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
🗄️ Set up the Database
🐬 For MySQL:
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
🍊 For Oracle:
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
📄 File: src/main/resources/com/nt/commons/Info.properties

✅ MySQL Configuration (Default):
properties
Copy
Edit
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql:///NTSPBMS716DB
jdbc.username=root
jdbc.password=root
dao.id=custDAO-mysql
🔁 Oracle Configuration (Uncomment and modify if needed):
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
▶️ Post-Installation: Running the Application
🧪 Execute the Application
Run the main class:
📁 src/main/java/com/nt/test/RealtimeDITest.java

java
Copy
Edit
public class RealtimeDITest {
    public static void main(String[] args) {
        // Code to load Spring context and interact with the user
    }
}
The program will prompt for:

Customer name

Customer address

Bill amount

Discount percentage

📝 Sample Input & Output
✅ MySQL Example:
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
Check MySQL DB:

sql
Copy
Edit
SELECT * FROM SPRING_CUSTOMER_INFO;
CNO	CNAME	CADDRS	BILLAMT	DISCOUNT	FINALAMOUNT
1	John Doe	123 Main St	1000.0	10.0	900.0

🟠 Oracle Example:
Update Info.properties as shown above for Oracle. Then run the app again.

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
🛠️ How It Works
Layer	Role
🎮 Controller	Takes input & delegates to service
🧠 Service	Calculates discount & calls DAO
🗄️ DAO	Interacts with DB using JDBC + HikariCP
🧾 Config	XML config loads properties & scans components

📌 Notes
XML-based config used for learning clarity (can be converted to annotation-based later)

DB server must be running before execution

Update DB credentials to match your environment

Oracle JDBC may need manual addition to .m2 repository

🤝 Contributing
Fork the repo

Create a branch:

bash
Copy
Edit
git checkout -b feature-branch
Make your changes

Commit:

bash
Copy
Edit
git commit -m "Add feature"
Push:

bash
Copy
Edit
git push origin feature-branch
Create a Pull Request

📬 Contact
For queries or bug reports, use GitHub Issues

Happy Coding! 🚀

yaml
Copy
Edit

---

Would you like me to create a downloadable version (`README.md` file), or generate 
