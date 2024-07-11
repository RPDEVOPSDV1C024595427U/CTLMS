<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.ctlms.Book"%>
<%@ page import="com.ctlms.BookExtendedInfo"%>
<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Book Information</title>
</head>
</head>
<body class="d-flex flex-column min-vh-100">
	<div class="container my-4">
		<div class="content">
			<h1 class="mb-4">Book Information</h1>
			<p class="lead my-2">Additional Information For ${book.bookTitle}</p>
			<c:choose>
				<c:when test="${not empty book && not empty bookExtendedInfo}">
					<div class="row">
						<div class="col-md-4 text-center">
							<img
								src="${pageContext.request.contextPath}/${bookExtendedInfo.imagePath}"
								class="img-fluid book-cover" alt="${book.bookTitle} cover">
						</div>
						<div class="col-md-8 pt-4">
							<p>
								<strong>ID:</strong> ${book.bookID}
							</p>
							<p>
								<strong>ISBN13:</strong> ${book.bookISBN}
							</p>
							<p>
								<strong>Title:</strong> ${book.bookTitle}
							</p>
							<p>
								<strong>Author:</strong> ${book.bookAuthor}
							</p>
							<p>
								<strong>Quantity:</strong> ${book.bookQuantity}
							</p>
							<p>
								<strong>Shelf Number:</strong> ${book.bookShelf}
							</p>
							<p>
								<strong>Publisher:</strong> ${bookExtendedInfo.bookPublisher}
							</p>
							<p>
								<strong>Year:</strong> ${bookExtendedInfo.bookYear}
							</p>
							<p>
								<strong>Summary:</strong> ${bookExtendedInfo.bookSummary}
							</p>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<p>Book information not found.</p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</body>
</html>
