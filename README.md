# Employee Management System

## Overview

The Employee Management System is a Java Swing application designed to perform basic CRUD (Create, Read, Update, Delete) operations on an employee database. This application demonstrates the use of Java Swing for GUI, JDBC for database connectivity, and MySQL for the backend database.

## Features

- **Add Employee**: Enter employee details (name, salary, mobile) and add them to the database.
- **Update Employee**: Modify existing employee records by updating their details.
- **Delete Employee**: Remove employee records from the database.
- **Search Employee**: Retrieve and display employee details based on their ID.

## Technologies Used

- **Java Swing**: For building the graphical user interface.
- **JDBC**: For connecting and executing SQL queries on the MySQL database.
- **MySQL**: As the backend database to store employee information.
- **IntelliJ IDEA**: As the development environment.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Server
- IntelliJ IDEA or any other Java IDE

### Setup

1. **Clone the repository**:

    ```bash
    git clone https://github.com/NadunMadawala/Employee-Management-System.git
    cd YOUR-REPOSITORY
    ```

2. **Set up the MySQL database**:
    - Create a MySQL database named `ncmcompany`.
    - Create a table named `employee` with the following schema:

        ```sql
        CREATE TABLE employee (
            id INT AUTO_INCREMENT PRIMARY KEY,
            empname VARCHAR(100) NOT NULL,
            salary VARCHAR(100) NOT NULL,
            mobile VARCHAR(100) NOT NULL
        );
        ```

3. **Update the database connection in the code**:
    - Modify the connection string in the `connect` method of the `Employee` class if necessary.

4. **Run the application**:
    - Open the project in IntelliJ IDEA.
    - Run the `Employee` class to start the application.

## Usage

- Use the text fields to enter employee details.
- Click `Add` to insert a new employee record.
- Use `Search` to find an employee by their ID and display their details.
- Update the details and click `Update` to modify the record.
- Click `Delete` to remove the employee record from the database.



## Acknowledgments

- [MySQL Connector/J]MySQL connector for java) for the JDBC driver and add bin path to project structure -> Modules -> Dedpendencies -> select files.
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) for the development environment.
- [DbUtils](http://swinglabs.org/DbUtils) for simplifying database operations with Swing.
- Download rs2xxml.jar file add bin path to project structure -> Modules -> Dedpendencies -> select files.
