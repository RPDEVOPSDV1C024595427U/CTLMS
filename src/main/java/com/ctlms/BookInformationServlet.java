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
    private DBConnCTLMS dbConnCTLMS;

    @Override
    public void init() throws ServletException {
        super.init();
        String jdbcURL = System.getenv("DB_URL");
        String jdbcUsername = System.getenv("DB_USERNAME");
        String jdbcPassword = System.getenv("DB_PASSWORD");
        dbConnCTLMS = new DBConnCTLMS(jdbcURL, jdbcUsername, jdbcPassword);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        BookExtendedInfo bookExtendedInfo = null;
        Book book = null;
		String query = "SELECT books.bookID, books.bookISBN, books.bookTitle, books.bookAuthor, books.bookQuantity, books.bookShelf, bookextendedinfo.bookSummary, bookextendedinfo.bookPublisher, bookextendedinfo.bookPublisher, bookextendedinfo.bookYear, bookextendedinfo.imagePath "
				+ "FROM books INNER JOIN bookExtendedInfo ON books.bookISBN = bookExtendedInfo.bookISBN WHERE books.bookISBN = ?";
		
		
        if (isbn != null && !isbn.trim().isEmpty()) {
			try (Connection conn = dbConnCTLMS.getConnection();
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
                    String bookSummary = bookRs.getString("bookSummary");
                    String bookPublisher = bookRs.getString("bookPublisher");
                    int bookYear = bookRs.getInt("bookYear");
                    String imagePath = bookRs.getString("imagePath");
                    bookExtendedInfo = new BookExtendedInfo(isbn, bookSummary, bookPublisher, bookYear, imagePath);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        	
        }

        request.setAttribute("book", book);
        request.setAttribute("bookExtendedInfo", bookExtendedInfo);
        request.getRequestDispatcher("/bookinfo.jsp").forward(request, response);
    }
}
