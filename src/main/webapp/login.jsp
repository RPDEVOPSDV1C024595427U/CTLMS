<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login.css">
	    <script>
        window.onload = function() {
            <c:if test="${sessionScope.user != null}">
                window.location.href = "${pageContext.request.contextPath}/dashboard.jsp";
            </c:if>
        };
    </script>
</head>
<body class="d-flex flex-column min-vh-100">
	<div class="container login-container">
		<div class="login-form">
			<h3 class="text-center mb-4">Login</h3>
			<c:if test="${param.error != null}">
                <div class="alert alert-danger" role="alert">
                    Invalid Username or Password. Please try again.
                </div>
            </c:if>
			<form action="${pageContext.request.contextPath}/Login" method="post">
				<div class="mb-3">
					<label for="username" class="form-label">Username</label> <input
						type="text" class="form-control" id="username" name="username"
						required>
				</div>
				<div class="mb-3">
					<label for="password" class="form-label">Password</label> <input
						type="password" class="form-control" id="password" name="password"
						required>
				</div>
				<div class="d-flex justify-content-between align-items-center mb-3">
					<a href="#" class="text-decoration-none">Forgot password?</a>
				</div>
				<button type="submit" class="btn btn-primary w-100">Login</button>
			</form>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
