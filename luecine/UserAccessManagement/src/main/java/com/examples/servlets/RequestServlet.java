package com.examples.servlets;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/requestAccess")
public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        
        String softwareId = request.getParameter("softwareId");
        String accessType = request.getParameter("accessType");
        String reason = request.getParameter("reason");

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserAccessDB", "root", "root");
            String query = "SELECT id FROM users WHERE username=?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet resultSet = stmt.executeQuery();
            int userId = 0;
            if (resultSet.next()) {
                userId = resultSet.getInt("id");
            }

            String insertQuery = "INSERT INTO requests (user_id, software_id, access_type, reason) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setInt(1, userId);
            insertStatement.setInt(2, Integer.parseInt(softwareId));
            insertStatement.setString(3, accessType);
            insertStatement.setString(4, reason);
            insertStatement.executeUpdate();
            connection.close();
            response.sendRedirect("requestAccess.jsp?success=Request submitted");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("requestAccess.jsp?error=Request failed");
        }
    }
}

