<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Library Management System</title>
</head>
<body class="d-flex flex-column min-vh-100">
	<div class="container my-4">
		<div class="content">
			<h1 class="mb-4">Welcome to the Library Management System</h1>
			<p>Your gateway to a world of books.</p>
			<div id="carouselExampleControlsNoTouching" class="carousel slide"
				data-bs-touch="false" data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img
							src="${pageContext.request.contextPath}/img/placeholder_1920x1080.jpg"
							class="d-block w-100" alt="First slide">
					</div>
					<div class="carousel-item">
						<img
							src="${pageContext.request.contextPath}/img/placeholder_1920x1080.jpg"
							class="d-block w-100" alt="Second slide">
					</div>
					<div class="carousel-item">
						<img
							src="${pageContext.request.contextPath}/img/placeholder_1920x1080.jpg"
							class="d-block w-100" alt="Third slide">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleControlsNoTouching"
					data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleControlsNoTouching"
					data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
			<div class="card my-3">
				<h5 class="card-header">Featured Books This Week!</h5>
				<div class="card-body">
					<div class="row">
						<div class="col-12">
							<div class="row row-cols-1 row-cols-md-3 g-4">
								<div class="col">
									<div class="card h-100">
										<img
											src="${pageContext.request.contextPath}/img/9781551925158.jpg"
											class="card-img-top my-1" alt="Hunger Games">
										<div class="card-body">
											<h5 class="card-title">Hunger Games</h5>
											<p class="card-text">By Best Selling author</p>
											<a href="#" class="btn btn-primary">Go somewhere</a>
										</div>
									</div>
								</div>
								<div class="col">
									<div class="card h-100">
										<img
											src="${pageContext.request.contextPath}/img/placeholderFeaturedBook.png"
											class="card-img-top my-1" alt="Featured Book 2">
										<div class="card-body">
											<h5 class="card-title">Featured Book 2</h5>
											<p class="card-text">By Best Selling author</p>
											<a href="#" class="btn btn-primary">Go somewhere</a>
										</div>
									</div>
								</div>
								<div class="col">
									<div class="card h-100">
										<img
											src="${pageContext.request.contextPath}/img/placeholderFeaturedBook.png"
											class="card-img-top my-1" alt="Featured Book 3">
										<div class="card-body">
											<h5 class="card-title">Featured Book 3</h5>
											<p class="card-text">By Best Selling author</p>
											<a href="#" class="btn btn-primary">Go somewhere</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
