package com.srs.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srs.dao.StudentDAO;
import com.srs.dao.StudentDAOImpl;
import com.srs.model.Student;


@WebServlet("/list")
public class ReadServlet extends HttpServlet {
	
	private StudentDAO studentDAO;
	
	@Override
	public void init() throws ServletException {
		studentDAO = new StudentDAOImpl();
	}
	
	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	List<Student> students = studentDAO.getAllStudents();
    	
    	request.setAttribute("students",students);
    	
    	request.getRequestDispatcher("list.jsp").forward(request,response);
    	
    }

}
