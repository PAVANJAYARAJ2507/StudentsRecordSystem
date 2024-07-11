package com.srs.dao;

import java.util.List;

import com.srs.model.Student;

public interface StudentDAO {
	
	void addStudent(Student student);
	Student getStudent(int id);
	List<Student> getAllStudents();
	void updateStudent(Student student);
	void deleteStudent(int id);
	List<Student> searchStudentsByName(String name);
	
}
