package com.examples.servlets;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/approveRequest")
public class ApprovalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        String action = request.getParameter("action"); // "approve" or "reject"

        String status = action.equals("approve") ? "Approved" : "Rejected";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserAccessDB", "root", "root");
            String sql = "UPDATE requests SET status=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, status);
            statement.setInt(2, requestId);
            statement.executeUpdate();
            connection.close();
            response.sendRedirect("pendingRequests.jsp?success=Request " + status);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("pendingRequests.jsp?error=Failed to update request");
        }
    }
}


