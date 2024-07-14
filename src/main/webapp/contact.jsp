<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Contact Us</title>
</head>
<body class="d-flex flex-column min-vh-100">
	<div class="col-md-12">
		<c:if test="${param.success != null}">
			<div class="container">
				<div
					class="text-center m-4 alert alert-success alert-dismissible fade show"
					role="alert">
					Your inquiry has been submitted successfully.
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>
			</div>
		</c:if>
		<c:if test="${param.error != null}">
			<div class="container">
				<div
					class="text-center m-4 alert alert-danger alert-dismissible fade show"
					role="alert">
					There was an error submitting your inquiry. Please try again.
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>
			</div>
		</c:if>
		<div class="container col-md-12">
			<h2 class="mb-4">Questions?</h2>
			<p class="mb-4">We'll get back to you asap!</p>
			<form action="${pageContext.request.contextPath}/submitInquiry"
				method="post">
				<div class="mb-3 row">
					<label for="email" class="col-sm-2 col-form-label">Email:</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="email" name="email"
							required>
					</div>
				</div>
				<div class="mb-3 row">
					<label for="question" class="col-sm-2 col-form-label">Question:</label>
					<div class="col-sm-10">
						<textarea class="form-control" id="question" name="question"
							rows="6" required></textarea>
					</div>
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
