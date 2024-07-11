<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.srs.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h1>Student List</h1>
    <a href="add.jsp">Add New Student</a>
    <br><br>
     <form action="search" method="get">
        <input type="text" name="name" placeholder="Search by name">
        <input type="submit" value="Search">
    </form>
   	<br>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Age</th>
            <th>Actions</th>
        </tr>
        <% 
            List<Student> students = (List<Student>) request.getAttribute("students");
            if (students != null) {
                for (Student student : students) {
        %>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getEmail() %></td>
            <td><%= student.getAge() %></td>
            <td>
                <a href="/StudentsRecordSystem/update?id=<%= student.getId() %>">Update</a>
                <a href="/StudentsRecordSystem/delete?id=<%= student.getId() %>">Delete</a>
            </td>
        </tr>
        <% 
                }
            } else { 
        %>
        <tr>
            <td colspan="5">No students found.</td>
        </tr>
        <% 
            }
        %>
        
    </table>
</body>
</html>
