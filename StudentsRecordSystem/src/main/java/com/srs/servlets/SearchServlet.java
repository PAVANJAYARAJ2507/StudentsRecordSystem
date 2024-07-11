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


@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	
	public StudentDAO stduentDAO= new StudentDAOImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		
		List<Student> students = stduentDAO.searchStudentsByName(name);
		
		req.setAttribute("students", students);
		
		req.getRequestDispatcher("/search.jsp").forward(req, resp);
	}
}