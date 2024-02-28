<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<jsp:useBean id="orderDAO" class="database.OrderDAO" scope="page" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bảng thống kê</title>
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
					<h3 >Tổng doanh thu cửa hàng: <fmt:formatNumber value="${orderDAO.totalRevenue()}" type="currency"
										currencyCode="VND" /> </h3>
					<h5> <span>${dashBoard}</span> </h5>
					<div class="btn-toolbar mb-2 mb-md-0">
						<div class="btn-group me-2">
							<a href="dashBoard2.jsp"><button type="button" class="btn btn-sm btn-outline-success">Theo Năm</button> </a>
							<a href="dashBoard.jsp"><button type="button" class="btn btn-sm btn-outline-secondary">7 Ngày Gần Nhất</button></a>
						</div>
						
					</div>
				</div>
					<h5 class="text-success" style="margin-left: 40px;">Biểu Đồ Doanh Thu 7 Ngày Bán Hàng Gần Nhất</h5>

				<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>
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
	<script src="javascript/scriptTable2.js"></script>
</body>
</html>