<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.srs.model.Student" %>
<!DOCTYPE html>
<html>
<body>
    <h1>Search Results</h1>
    <a href="list">Back to List</a>
    <br><br>
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
            if (students != null && !students.isEmpty()) {
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
            <td colspan="5">No such student found.</td>
        </tr>
        <% 
            }
        %>
    </table>
</body>
</html>