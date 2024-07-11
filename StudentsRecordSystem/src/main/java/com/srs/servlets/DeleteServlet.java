package com.srs.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srs.dao.StudentDAO;
import com.srs.dao.StudentDAOImpl;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        studentDAO = new StudentDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	int id = Integer.parseInt(request.getParameter("id"));
    	
        studentDAO.deleteStudent(id);

        response.sendRedirect("list");
    }
}