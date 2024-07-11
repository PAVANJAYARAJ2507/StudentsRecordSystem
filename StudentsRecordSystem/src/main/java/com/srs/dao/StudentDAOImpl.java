package com.srs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.srs.model.Student;
import com.srs.util.DBConnection;

public class StudentDAOImpl implements StudentDAO {

	// Implemented method for adding the student data to database
	@Override
	public void addStudent(Student student) {
		
		try(Connection con = DBConnection.getConnection())
		{
			//A query to add the values to the database
			String addStds = "INSERT INTO students(name,email,age) VALUES(?,?,?)";
			
			//To execute the same query multiple times
			PreparedStatement stmt = con.prepareStatement(addStds);
			
			stmt.setString(1,student.getName());
			stmt.setString(2, student.getEmail());
			stmt.setInt(3, student.getAge());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
	
	//Implemented method for getting the student data from database with id 
	@Override
	public Student getStudent(int id) {
		
		Student student = null;
		
		try(Connection con = DBConnection.getConnection())
		{
			//A query to get the student by their id
			String getStd = "SELECT * FROM students WHERE id=?";
			
			//To execute the same query multiple times
			PreparedStatement stmt = con.prepareStatement(getStd);
			stmt.setInt(1, id);
			
			//To fetch the data from database
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
			{
				String name = rs.getString("name");
				String email = rs.getString("email");
				int age = rs.getInt("age");
				
				student = new Student(id, name, email, age);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return student;
	}
	
	//Implemented method to fetch the data of all Students
	@Override
	public List<Student> getAllStudents() {
		
		List<Student> students = new ArrayList<>();
		
		try(Connection con = DBConnection.getConnection())
		{
			//A query to fetch the all students
			String getAllStd="SELECT * FROM students";
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(getAllStd);
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				int age = rs.getInt("age");
				
				students.add(new Student(id, name, email, age));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return students;
	}

	
	//Implemented method to update the students data 
	@Override
	public void updateStudent(Student student) {
		
		try(Connection con = DBConnection.getConnection())
		{
			
			//A query to update the data
			String updateStd = "UPDATE students SET name = ?,email = ? , age = ? WHERE id = ?";
			
			PreparedStatement stmt = con.prepareStatement(updateStd);
			
			stmt.setString(1, student.getName());
			stmt.setString(2, student.getEmail());
			stmt.setInt(3, student.getAge());
			stmt.setInt(4, student.getId());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	////Implemented method to delete the student data by id
	@Override
	public void deleteStudent(int id) {

		try(Connection con = DBConnection.getConnection())
		{
			//A query to delete the data
			String deleteStd ="DELETE FROM students WHERE id=?";
			
			PreparedStatement stmt = con.prepareStatement(deleteStd);
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//Implemented method for fetching the particular student details
	@Override
	public List<Student> searchStudentsByName(String name) {
		
		List<Student> students = new ArrayList<>();
		try(Connection con = DBConnection.getConnection())
		{
			//Query to fetch the data
			
			String srchStd = "SELECT * FROM students WHERE name LIKE ?";
			PreparedStatement stmt = con.prepareStatement(srchStd);
			
			stmt.setString(1, name);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
			{
				Student student = new Student();
				
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				student.setAge(rs.getInt("age"));
				
				students.add(student);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return students;
	}

}
