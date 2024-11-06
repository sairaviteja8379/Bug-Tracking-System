package com.day7.controller;

import java.io.IOException;

import com.day7.dao.BugDAO;
import com.day7.model.Bug;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet") // Map the servlet to "/LoginServlet"
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BugDAO bugDAO = new BugDAO();
    public void setBugDAO(BugDAO bugDAO) {
        this.bugDAO = bugDAO;
    }

    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        if (title == null || title.isEmpty() || description == null || description.isEmpty()) {
            response.getWriter().write("Title and description are required");
            return;
        }

        // Create a new Bug object
        Bug bug = new Bug(title, description);
        bugDAO.create(bug); // Save bug to database

        response.getWriter().write("Bug added successfully");
    }
}
