<%@ include file="navbar.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ctlms.Book"%>
<!DOCTYPE html>
<html>
<head>
<title>Books</title>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap5.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap5.min.js"></script>
</head>
<body class="d-flex flex-column min-vh-100">
	<div class="container my-4">
		<h1 class="mb-4">Book List</h1>
		<p class="lead">Browse Our Collection Of Books!</p>
		<table id="booksTable" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Quantity</th>
					<th>Shelf Number</th>
				</tr>
			</thead>
			<tbody id="bookTableBody">
				<c:forEach var="book" items="${books}">
					<tr>
						<td>${book.bookID}</td>
						<td><a
							href="${pageContext.request.contextPath}/bookinfo?isbn=${book.bookISBN}">${book.bookTitle}</a></td>
						<td>${book.bookQuantity}</td>
						<td>${book.bookShelf}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@ include file="footer.jsp"%>
</body>
<script>
    $(document).ready(function() {
        $('#booksTable').DataTable();
    });  
    </script>
</html>
