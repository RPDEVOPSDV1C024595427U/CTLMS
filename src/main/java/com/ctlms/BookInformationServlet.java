package com.ctlms;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookinfo")
public class BookInformationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        BookExtendedInfo bookExtendedInfo = null;
        Book book = null;
		String query = "SELECT * FROM books WHERE bookISBN = ?";
		
        if (isbn != null && !isbn.trim().isEmpty()) {
        	try (Connection conn = DBConnCTLMS.getConnection();
            		PreparedStatement stmt = conn.prepareStatement(query);) {

                stmt.setString(1, isbn);
                ResultSet bookRs = stmt.executeQuery();
                if (bookRs.next()) {
                    int bookID = bookRs.getInt("bookID");
                    String bookTitle = bookRs.getString("bookTitle");
                    String bookAuthor = bookRs.getString("bookAuthor");
                    int bookQuantity = bookRs.getInt("bookQuantity");
                    String bookShelf = bookRs.getString("bookShelf");
                    book = new Book(bookID, isbn, bookTitle, bookQuantity, bookShelf, bookAuthor);
                }

                String extendedQuery = "SELECT * FROM bookExtendedInfo WHERE bookISBN = ?";
                PreparedStatement extendedStmt = conn.prepareStatement(extendedQuery);
                extendedStmt.setString(1, isbn);
                ResultSet extendedRs = extendedStmt.executeQuery();
                if (extendedRs.next()) {
                    String bookSummary = extendedRs.getString("bookSummary");
                    String bookPublisher = extendedRs.getString("bookPublisher");
                    int bookYear = extendedRs.getInt("bookYear");
                    String imagePath = extendedRs.getString("imagePath");
                    bookExtendedInfo = new BookExtendedInfo(isbn, bookSummary, bookPublisher, bookYear, imagePath);
                }

                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("book", book);
        request.setAttribute("bookExtendedInfo", bookExtendedInfo);
        request.getRequestDispatcher("/bookinfo.jsp").forward(request, response);
    }
}
