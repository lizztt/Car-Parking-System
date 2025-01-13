# Car Parking Management System

A Java-based application for managing a car parking system with database integration. This project allows users to add, view, and manage parking client details. It features a graphical user interface (GUI) built with Swing and connects to a MySQL database.

---

## Features

- Add new parking clients.
- View and manage client details.
- MySQL database integration for persistent storage.

---

## Prerequisites

Before running the project, ensure you have the following installed:

1. **Java Development Kit (JDK)** (version 17 or higher)
2. **MySQL Server** (version 8.0 or higher)
3. **Git** (optional, for cloning the repository)
4. **IntelliJ IDEA** (or any other Java IDE, optional)

---

## Setup Instructions

### **1. Clone the Repository**
```bash
git clone https://github.com/lizztt/car-parking-system.git
cd car-parking-system
```

### **2. Database Setup**
1. Open your MySQL client or MySQL Workbench.
2. Create a new database:
   ```sql
   CREATE DATABASE car_parking_system;
   ```
3. Import the provided `database_setup.sql` file:
   ```bash
   mysql -u <lizztt> -p car_parking_system < database_setup.sql
   ```
4. Update the database credentials in the `JDBC` class:
   ```java
   String url = "jdbc:mysql://localhost:3306/car_parking_system";
   String user = "your_mysql_username";
   String password = "your_mysql_password";
   ```

### **3. Build and Run the Project**

#### **Using IntelliJ IDEA**
1. Open the project in IntelliJ IDEA.
2. Build the project by going to `Build > Build Artifacts > Build`.
3. Run the project by selecting the `Main` class.

#### **Using Command Line**
1. Navigate to the project folder:
   ```bash
   cd out/production/Car_Parking_System_
   ```
2. Run the JAR file:
   ```bash
   java -jar car_parking_system.jar
   ```

---

## Project Structure

- `src/` - Contains all source code.
- `database_setup.sql` - SQL file for setting up the database.
- `README.md` - Project documentation.
- `lib/` - Contains required external libraries (e.g., `rs2xml.jar`).

---

## External Libraries

- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) (for database connectivity)
- [rs2xml.jar](https://sourceforge.net/projects/finalproject/files/) (for handling table models in Swing)

Ensure these libraries are properly included in your IDE or JAR.

---

## Screenshots

![image](https://github.com/user-attachments/assets/6baabf8c-9b6a-41eb-924c-43f3a1b12e92)


---

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

## Author

**Bill Gichuru**  
[GitHub Profile](https://github.com/lizztt)  
[Email](gichurubill2@gmail.com)

---

## Contributions

Contributions, issues, and feature requests are welcome!  
Feel free to fork this repository and submit pull requests.

---

## Support

If you encounter any issues, feel free to open an issue on [GitHub](https://github.com/lizztt/car-parking-system/issues).

---
```
