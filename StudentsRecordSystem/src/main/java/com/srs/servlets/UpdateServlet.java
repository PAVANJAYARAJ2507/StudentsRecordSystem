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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        studentDAO = new StudentDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	int id = Integer.parseInt(request.getParameter("id"));
    	
        Student student = studentDAO.getStudent(id);
        
        request.setAttribute("student", student);
        
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	int id = Integer.parseInt(request.getParameter("id"));
    	
        String name = request.getParameter("name");
        
        String email = request.getParameter("email");
        
        int age = Integer.parseInt(request.getParameter("age"));

        Student student = new Student(id, name, email, age);
         
        studentDAO.updateStudent(student);

        response.sendRedirect("list");
    }
}