<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
	    <script>
        window.onload = function() {
            <c:if test="${sessionScope.user == null}">
                window.location.href = "${pageContext.request.contextPath}/index.jsp";
            </c:if>
        };
    </script>
</head>
<body>
<body class="d-flex flex-column min-vh-100">
	<div class="col-md-12">
		<div class="container">
			<div class="container col-md-12">
				<h2 class="mb-4">Hello, ${sessionScope.user}!</h2>
				<c:if test="${sessionScope.role == 'administrator'}">
					<p>Welcome, Administrator!</p>
				</c:if>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>