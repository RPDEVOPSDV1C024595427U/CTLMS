package com.ctlms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/submitInquiry")
public class ContactFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	private static final String INSERT_USERINQUIRIES_SQL = "INSERT INTO userInquiries (email, inquiry) VALUES (?, ?);";
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String email = request.getParameter("email");
        String inquiry = request.getParameter("question");

        if (inquiry != null && !inquiry.trim().isEmpty()) {
        	String query = INSERT_USERINQUIRIES_SQL;
        	
			try (Connection conn = DBConnCTLMS.getConnection();
            		PreparedStatement stmt = conn.prepareStatement(query);) {                
                
                if (email != null && !email.trim().isEmpty()) {
                    stmt.setString(1, email);
                } else {
                    stmt.setNull(1, java.sql.Types.VARCHAR);
                }
                stmt.setString(2, inquiry);

                stmt.executeUpdate();
                conn.close();

                response.sendRedirect(request.getContextPath() + "/contact.jsp?success=true");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/contact.jsp?error=true");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/contact.jsp?error=true");
        }
    }
    
}
