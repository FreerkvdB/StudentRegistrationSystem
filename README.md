# Student Registration System

<p align="center">
  <img src="screenshots/dashboard.png" width="800">
</p>

<h1 align="center">Student Registration System</h1>

<p align="center">
A Jakarta EE web application for managing students, courses, and enrollments.
</p>

---

## Table of Contents

* [Overview](#overview)
* [Features](#features)
* [Technologies Used](#technologies-used)
* [System Architecture](#system-architecture)
* [Project Structure](#project-structure)
* [Screenshots](#screenshots)
* [Database Setup](#database-setup)
* [Database Configuration](#database-configuration)
* [Running the Application](#running-the-application)
* [Demo Login Credentials](#demo-login-credentials)
* [Database Relationships](#database-relationships)
* [Known Limitations](#known-limitations)
* [Future Improvements](#future-improvements)
* [Author](#author)

---

# Overview

The **Student Registration System** is a Jakarta EE based web application developed to manage student registrations, courses, and student-course enrollments.

The system demonstrates the implementation of:

* Jakarta Servlets
* JSP (JavaServer Pages)
* JDBC database connectivity
* PostgreSQL relational database design
* MVC architecture principles

The application provides authentication, student management, course management, and enrollment functionality through a web-based interface.

---

# Features

## User Management

* User registration
* User login authentication
* User logout functionality
* Session-based authentication

## Student Management

Users can:

* Add new students
* View registered students
* Store student information:

  * Student number
  * First name
  * Last name
  * Email
  * Phone number

## Course Management

Users can:

* Add courses
* View available courses
* Store course information:

  * Course code
  * Course name
  * Credits

## Enrollment Management

Users can:

* Enroll students into courses
* Manage student-course relationships
* View current enrollments
* Use relational database foreign key relationships

---

# Technologies Used

## Backend

* Java
* Jakarta Servlets
* JDBC
* MVC Architecture

## Frontend

* JSP (JavaServer Pages)
* HTML5
* CSS
* JavaScript

## Database

* PostgreSQL

## Application Server

* Apache Tomcat 10

## Development Environment

* Apache NetBeans

---

# System Architecture

The project follows the MVC (Model-View-Controller) architecture.

```
User Interface (JSP)
        |
        |
Controllers (Servlets)
        |
        |
DAO Layer (Database Operations)
        |
        |
PostgreSQL Database
```

## Model

Contains Java classes representing system entities:

* User
* Student
* Course
* Enrollment

## View

JSP pages responsible for displaying information:

* Login page
* Registration page
* Dashboard
* Student management
* Course management
* Enrollment management

## Controller

Servlets responsible for handling requests:

* LoginServlet
* RegisterServlet
* LogoutServlet
* StudentServlet
* CourseServlet
* EnrollmentServlet

---

# Project Structure

```
StudentRegistrationSystem
│
├── src/java
│   └── com.student
│       ├── controller
│       ├── dao
│       ├── model
│       └── util
│
├── web
│   ├── JSP pages
│   ├── CSS
│   └── JavaScript
│
├── database
│   ├── create_database.sql
│   └── sample_data.sql
│
├── screenshots
│   ├── login.png
│   ├── register.png
│   ├── dashboard.png
│   ├── students.png
│   ├── courses.png
│   └── enrollment.png
│
└── README.md
```

---

# Screenshots

## Login Page

![Login Page](screenshots/login.png)

---

## Registration Page

![Registration Page](screenshots/register.png)

---

## Dashboard

![Dashboard](screenshots/dashboard.png)

---

## Student Management

![Student Management](screenshots/students.png)

---

## Course Management

![Course Management](screenshots/courses.png)

---

## Enrollment Management

![Enrollment Management](screenshots/enrollment.png)

---

# Database Setup

The project uses PostgreSQL as the database management system.

## 1. Create Database

Create a PostgreSQL database:

```
StudentRegistrationSystem
```

---

## 2. Run SQL Scripts

Navigate to:

```
database/
```

Execute:

```
create_database.sql
```

This creates:

* users table
* students table
* courses table
* enrollments table
* primary keys
* foreign keys
* database constraints

Optional sample data:

```
sample_data.sql
```

can be executed to insert example users, students, courses, and enrollments.

---

# Database Configuration

Database settings are located in:

```
src/java/com/student/util/DBConnection.java
```

Update the following values:

```java
private static final String URL =
"jdbc:postgresql://localhost:5432/StudentRegistrationSystem";

private static final String USER = "postgres";

private static final String PASSWORD = "YOUR_PASSWORD";
```

Replace:

```
YOUR_PASSWORD
```

with your local PostgreSQL password.

---

# Running the Application

## Requirements

Install:

* Java JDK 21+
* PostgreSQL
* Apache Tomcat 10
* Apache NetBeans

---

## Installation Steps

### 1. Clone Repository

```bash
git clone https://github.com/FreerkvdB/StudentRegistrationSystem.git
```

---

### 2. Open Project

Open Apache NetBeans:

```
File
→ Open Project
→ Select StudentRegistrationSystem
```

---

### 3. Configure Database

Ensure PostgreSQL is running.

Update:

```
DBConnection.java
```

with your database credentials.

---

### 4. Configure Tomcat

Add Apache Tomcat:

```
Tools
→ Servers
→ Add Server
```

Select:

```
Apache Tomcat 10
```

---

### 5. Run Application

In NetBeans:

```
Right Click Project
→ Run
```

The application will launch in your browser.

---

# Demo Login Credentials

For demonstration purposes, the application includes the following account:

| Username | Password |
| -------- | -------- |
| admin    | admin123 |

Use these credentials on the login page to access the dashboard.

> Security Note: This project uses plain-text passwords for demonstration purposes only. A production system should implement password hashing (such as BCrypt), salting, and secure session management.

---

# Database Relationships

The application uses relational database design principles.

## Student Relationship

One student can have multiple enrollments.

```
students
    |
    |
enrollments
```

## Course Relationship

One course can contain multiple students.

```
courses
    |
    |
enrollments
```

The enrollment table connects both entities:

```
student_id → students.student_id

course_id → courses.course_id
```

---

# Known Limitations

Current limitations:

* Passwords are not encrypted
* No update functionality
* No delete functionality
* No role-based access control
* Basic input validation
* Limited UI styling

These features can be added in future versions.

---

# Future Improvements

Possible improvements:

* Implement BCrypt password hashing
* Add student search functionality
* Add update and delete operations
* Add role-based permissions
* Improve UI/UX design
* Add pagination for large datasets
* Add REST API integration
* Deploy application to cloud hosting

---

# Author

**Freerk Van Den Bos**

Bachelor of Computing
Software Engineering

---

# License

This project is developed for educational and portfolio purposes.
