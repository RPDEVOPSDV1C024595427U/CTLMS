<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>About Us</title>
<style>
.about-section {
	padding: 60px 0;
}

.about-section h2 {
	margin-bottom: 30px;
}

.about-section .row+.row {
	margin-top: 30px;
}
</style>
</head>
<body class="d-flex flex-column min-vh-100">
	<div class="container about-section">
		<h1 class="text-center">
			Who we are
			</h2>
			<p class="text-center m-4">Lorem ipsum dolor sit amet et delectus
				accommodare his consul copiosae legendos at vix ad putent delectus
				delicata usu. Vidit dissenti eos cu eum an brute copiosae hendrerit.
				Eos erant dolorum an. Per facer affert ut. Mei iisque mentitum
				moderatius cu. Sit munere facilis accusam eu dicat falli consulatu
				at vis. Te facilisis mnesarchum qui posse omnium mediocritatem est
				cu. Modus argumentum ne qui tation efficiendi in eos. Ei mea falli
				legere efficiantur et tollit aliquip debitis mei. No deserunt
				mediocritatem mel. Lorem ipsum dolor sit amet et delectus
				accommodare his consul copiosae legendos at vix ad putent delectus
				delicata usu. Vidit dissenti eos cu eum an brute copiosae hendrerit.
				Eos erant dolorum an.</p>

			<div class="row">
				<div class="col-md-6">
					<h4 class="text-center">Our Vision</h4>
					<p class="m-4">Lorem ipsum dolor sit amet et delectus
						accommodare his consul copiosae legendos at vix ad putent delectus
						delicata usu. Vidit dissenti eos cu eum an brute copiosae
						hendrerit. Eos erant dolorum an. Per facer affert ut. Mei iisque.
					</p>
					<img
						src="${pageContext.request.contextPath}/img/placeholder_600x400.jpg"
						class="img-fluid m-2" alt="Vision">
				</div>
				<div class="col-md-6">
					<h4 class="text-center">Our Mission</h4>
					<p class="m-4">Lorem ipsum dolor sit amet et delectus
						accommodare his consul copiosae legendos at vix ad putent delectus
						delicata usu. Vidit dissenti eos cu eum an brute copiosae
						hendrerit. Eos erant dolorum an. Per facer affert ut. Mei iisque.
					</p>
					<img
						src="${pageContext.request.contextPath}/img/placeholder_600x400.jpg"
						class="img-fluid m-2" alt="Mission">
				</div>
			</div>

			<div class="row">
				<div class="col-md-6">
					<img
						src="${pageContext.request.contextPath}/img/placeholder_600x400.jpg"
						class="img-fluid m-2" alt="Extra 1">
				</div>
				<div class="col-md-6">
					<h4 class="text-center">Additional Information</h4>
					<p class="m-4">Lorem ipsum dolor sit amet et delectus
						accommodare his consul copiosae legendos at vix ad putent delectus
						delicata usu. Vidit dissenti eos cu eum an brute copiosae
						hendrerit. Eos erant dolorum an. Per facer affert ut. Mei iisque.
					</p>
				</div>
			</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>

