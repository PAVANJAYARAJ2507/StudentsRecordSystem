package com.srs.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srs.dao.StudentDAO;
import com.srs.dao.StudentDAOImpl;
import com.srs.model.Student;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	
	private StudentDAO studentDAO;
	
	@Override
	public void init() throws ServletException {
		
		studentDAO = new StudentDAOImpl();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		
		String email = request.getParameter("email");
		
		int age = Integer.parseInt(request.getParameter("age"));
		
		Student student = new Student(name, email, age);
		
		studentDAO.addStudent(student);
		
		response.sendRedirect("list");
	}

}
