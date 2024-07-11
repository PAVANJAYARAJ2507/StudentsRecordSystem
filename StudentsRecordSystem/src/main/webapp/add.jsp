<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
    <h1>Add New Student</h1>
    <form action="create" method="post">
        Name: <input type="text" name="name" required/><br/><br>
        Email: <input type="text" name="email" required pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$" title="Please enter a valid email address (e.g., example@example.com)"/><br/><br>
        Age: <input type="number" name="age" required min="1" max="99"/><br/><br>
        <input type="submit" value="Add Student"/>
    </form>
    <br>
    <a href="list">Back to List</a>
</body>
</html>