package com.ctlms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> books = new ArrayList<>();
        String query = "SELECT bookID, bookISBN, bookTitle, bookQuantity, bookShelf FROM books";
        try (Connection conn = DBConnCTLMS.getConnection();
        		PreparedStatement stmt = conn.prepareStatement(query);) {  
           
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int bookID = rs.getInt("bookID");
                String bookISBN = rs.getString("bookISBN");
                String bookTitle = rs.getString("bookTitle");
                int bookQuantity = rs.getInt("bookQuantity");
                String bookShelf = rs.getString("bookShelf");
                books.add(new Book(bookID, bookISBN, bookTitle, bookQuantity, bookShelf));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("books", books);
        request.getRequestDispatcher("/books.jsp").forward(request, response);
    }

}
