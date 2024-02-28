<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="common.jsp"%>
<link href="css/styleAdminPage.css" rel="stylesheet">

</head>
<body>
	
   <%@ include file="headerAdmin.jsp" %>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="navMenuAdmin.jsp" %>
			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Dashboard</h1>
					<div class="btn-toolbar mb-2 mb-md-0">
						<div class="btn-group me-2">
							<button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
							<button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
						</div>
						<button type="button"
							class="btn btn-sm btn-outline-secondary dropdown-toggle d-flex align-items-center gap-1">
							<svg class="bi">
								<use xlink:href="#calendar3" /></svg>
							This week
						</button>
					</div>
				</div>

				<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>

				<h2>Section title</h2>
				<div class="table-responsive small">
					<table class="table table-striped table-sm">
						
						
						
					</table>
				</div>
			</main>
		</div>
	</div>
	<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/chart.js@4.3.2/dist/chart.umd.js"
		integrity="sha384-eI7PSr3L1XLISH8JdDII5YN/njoSsxfbrkCTnJrzXt+ENP5MOVBxD+l6sEG4zoLp"
		crossorigin="anonymous"></script>
	<script src="javascript/scriptTable.js"></script>
</body>
</html>