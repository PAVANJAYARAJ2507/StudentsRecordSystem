# Student's Record System

## Description
This web application allows you to perform CRUD operations (Create, Read, Update, Delete) on a student database. It uses Java EE, JDBC, and Servlets to manage student records.

## Requirements
- Java Development Kit (JDK)
- Apache Tomcat or any Java EE-compliant server
- MySQL Database

## Setup Instructions

1. **Database Setup**
   - Create a MySQL database named `student_db`.
   - Execute the SQL commands in `database_setup.sql` to create the `students` table and insert sample data.

2. **Project Setup**
   - Import the project into your IDE (e.g., Eclipse).
   - Ensure the JDBC driver (MySQL Connector/J) is added to `WEB-INF/lib`.

3. **Deploy the Application**
   - Configure your Tomcat server in the IDE.
   - Deploy the `StudentsRecordSystem` project to the Tomcat server.

4. **Access the Application**
   - Open your browser and navigate to `http://localhost:8080/StudentsRecordSystem/home.jsp` to access the home page of the application.

## Files Overview

- **`src/com/srs/utils/DBConnection.java`**: Utility class for managing database connections.

- **`src/com/srs/dao/StudentDAO.java`**: Interface for Student Data Access Object (DAO) operations.
  
- **`src/com/srs/dao/StudentDAOImpl.java`**: Implementation of the StudentDAO interface for CRUD operations.

- **`src/com/srs/model/Student.java`**: Model class representing a student entity.

- **`src/com/srs/servlets/CreateServlet.java`**: Servlet for handling requests to add new students.

- **`src/com/srs/servlets/ReadServlet.java`**: Servlet for handling requests to list students.

- **`src/com/srs/servlets/UpdateServlet.java`**: Servlet for handling requests to update student details.

- **`src/com/srs/servlets/DeleteServlet.java`**: Servlet for handling requests to delete students.

- **`src/com/srs/servlets/SearchServlet.java`**: Servlet for handling search requests for students by name.

- **`WebContent/home.jsp`**: JSP page that provides a link to view student details.

- **`WebContent/list.jsp`**: JSP page for displaying the list of students, with options to add, update, or delete.

- **`WebContent/add.jsp`**: JSP page for adding a new student with validation.

- **`WebContent/update.jsp`**: JSP page for updating student details with validation.

- **`WebContent/search.jsp`**: JSP page for searching students by name, with validation and a link back to the list.

## Notes
- Ensure you update the database connection details in `DBConnection.java` with your MySQL credentials.
- This application assumes a MySQL database running locally on the default port with user `root` and password `password`.

