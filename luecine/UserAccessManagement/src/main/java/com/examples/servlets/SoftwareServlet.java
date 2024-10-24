package com.examples.servlets;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createSoftware")
public class SoftwareServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String softwareName = request.getParameter("softwareName");
        String description = request.getParameter("description");
        String accessLevels = request.getParameter("accessLevels");

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserAccessDB", "root", "root");
            String query = "INSERT INTO software (name, description, access_levels) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, softwareName);
            statement.setString(2, description);
            statement.setString(3, accessLevels);
            statement.executeUpdate();
            connection.close();
            response.sendRedirect("createSoftware.jsp?success=Software created");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("createSoftware.jsp?error=Creation failed");
        }
    }
}

