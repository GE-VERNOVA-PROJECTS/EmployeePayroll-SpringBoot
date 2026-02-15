Employee Payroll Application – Spring Boot

This project is a Spring Boot based RESTful backend application for managing employee payroll information.
It demonstrates layered application design, REST API development, data validation, exception handling, and database persistence using Spring Data JPA.

 Technology Stack

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL
* Lombok
* Hibernate Validator
* Maven

Application Architecture

The application follows a layered architecture pattern:

Controller → Service → Repository → Database

Each layer has a specific responsibility and communicates only with the adjacent layer.

Package Structure

The project is organized into the following packages:

* controller – Handles incoming REST requests and sends responses
* service – Contains business logic and application rules
* repository – Handles database interactions using Spring Data JPA
* model – Contains entity classes mapped to database tables
* dto – Contains Data Transfer Objects for request validation
* exception – Contains custom exceptions and global exception handlers

Application Flow

1. Client sends a REST API request
2. Request data is validated using DTO constraints
3. Controller forwards the request to the Service layer
4. Service layer processes business logic
5. Repository layer performs database operations
6. Response is returned to the client in JSON format

Database Support

The application supports relational databases such as MySQL and PostgreSQL.
Database connection details are configured using application properties and environment variables for security.

The database stores employee payroll data including personal details, salary, departments, and employment information.

REST API Features

* Create a new employee payroll record
* Retrieve all employee payroll records
* Retrieve a specific employee by ID
* Update existing employee payroll data
* Delete employee payroll data
* Retrieve employees by department

All APIs follow REST principles and return meaningful HTTP status codes.

Validation

Request validation is implemented using Hibernate Validator.
Validation ensures data correctness before processing requests, such as:

* Employee name format
* Salary limits
* Gender values
* Mandatory fields
* Valid start date

Invalid requests return user-friendly error messages.

Exception Handling

The application uses centralized exception handling.
All runtime and validation errors are intercepted and returned as structured responses, improving maintainability and readability.

Configuration Management

* Application properties are externalized
* Environment variables are used for database credentials
* Separate profiles can be configured for development and production

How to Run the Application

* Ensure Java, Maven, and the database are installed
* Configure database credentials
* Build the project using Maven
* Run the Spring Boot application
* Access the APIs using a browser, Postman, or CURL

 Learning Objectives

* Understand Spring Boot layered architecture
* Build RESTful APIs
* Apply validation and exception handling
* Use Spring Data JPA for persistence
* Work with relational databases
* Follow clean backend application design


Employee Payroll Application developed as part of backend development learning using Spring Boot.
