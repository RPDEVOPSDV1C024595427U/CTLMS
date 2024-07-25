package com.ctlms;

import static org.mockito.Mockito.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BookServletTest {
	
    @Mock
    private DBConnCTLMS dbConnCTLMS;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher dispatcher;

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private BookServlet bookServlet;

	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
        when(dbConnCTLMS.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
    }

    @Test
    public void testDoGet() throws ServletException, IOException, SQLException {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "1234567890", "Book Title", 10, "Shelf A"));

        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getInt("bookID")).thenReturn(1);
        when(resultSet.getString("bookISBN")).thenReturn("1234567890");
        when(resultSet.getString("bookTitle")).thenReturn("Book Title");
        when(resultSet.getInt("bookQuantity")).thenReturn(10);
        when(resultSet.getString("bookShelf")).thenReturn("Shelf A");

        bookServlet.doGet(request, response);

        verify(request).setAttribute(eq("books"), anyList());
        verify(dispatcher).forward(request, response);
    }
    
    @Test
    public void testDoGetDatabaseError() throws ServletException, IOException, ClassNotFoundException, SQLException {
        when(dbConnCTLMS.getConnection()).thenThrow(new RuntimeException("Database error"));

        bookServlet.doGet(request, response);

        verify(response).sendError(eq(HttpServletResponse.SC_INTERNAL_SERVER_ERROR), anyString());
    }

}
