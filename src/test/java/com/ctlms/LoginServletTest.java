package com.ctlms;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginServletTest {

    @Mock
    private DBConnCTLMS dbConnCTLMS;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    @Mock
    private RequestDispatcher requestDispatcher;
    private LoginServlet loginServlet;

    @Before
    public void setUp() throws Exception {
        loginServlet = new LoginServlet();
        loginServlet.init();
        
        when(request.getParameter("username")).thenReturn("user");
        when(request.getParameter("password")).thenReturn("pass");
        when(request.getSession()).thenReturn(session);
        when(dbConnCTLMS.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getString("role")).thenReturn("admin");

        loginServlet.setDbConnCTLMS(dbConnCTLMS);
    }

    @Test
    public void testDoPostSuccess() throws ServletException, IOException {
        loginServlet.doPost(request, response);
        verify(session).setAttribute("user", "user");
        verify(session).setAttribute("role", "admin");
        verify(response).sendRedirect(request.getContextPath() + "/dashboard.jsp");
        
    }

    @Test
    public void testDoPostFailure() throws ServletException, IOException, SQLException {
        when(resultSet.next()).thenReturn(false);
        loginServlet.doPost(request, response);
        verify(response).sendRedirect(request.getContextPath() + "/login.jsp?error=true");
    }
    
    @Test
    public void testDoGetUserLoggedIn() throws ServletException, IOException {
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("user")).thenReturn("user");

        loginServlet.doGet(request, response);

        verify(response).sendRedirect(request.getContextPath() + "/dashboard.jsp");
    }

    @Test
    public void testDoGetUserNotLoggedIn() throws ServletException, IOException {
        when(request.getSession(false)).thenReturn(null);
        when(request.getRequestDispatcher("/login.jsp")).thenReturn(requestDispatcher);

        loginServlet.doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }
}
