<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
    <h1>Update Student</h1>
    <form action="update" method="post">
        <input type="hidden" name="id" value="${student.id}"/>
        Name: <input type="text" name="name" value="${student.name}" required /><br/><br>
        Email: <input type="text" name="email" value="${student.email}" required pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$" title="Please enter a valid email address (e.g., example@example.com)"/><br/><br>
        Age: <input type="number" name="age" value="${student.age}" required min="1" max="99"/><br/><br>
        <br>
        <input type="submit" value="Update Student"/>
    </form>
    <br>
    <a href="list">Back to List</a>
</body>
</html>