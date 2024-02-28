<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hóa đơn</title>
<style>
td, th {
	vertical-align: middle; /* Căn giữa theo chiều dọc */
}
</style>
</head>
<body>

	<%@ include file="headerAdmin.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="navMenuAdmin.jsp"%>
			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">

				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h3 class="h2">Danh Sách Hóa Đơn</h3>
					<div class="btn-toolbar mb-2 mb-md-0">
					<a href="hoadonadmin?sort=ngay">
							<button type="button" class="btn btn-sm btn-outline-success">
								Sắp Xếp Theo Ngày</button>
						</a>
						<a href="hoadonadmin?sort=gia">
							<button type="button" class="btn btn-sm btn-outline-success">
								Sắp Xếp Theo Tổng Hóa Đơn</button>
						</a>
					</div>
				</div>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">Mã Hóa Đơn</th>
							<th scope="col">Ngày Đặt</th>
							<th scope="col">Người Đặt</th>
							<th scope="col">Tổng Tiền</th>
							<th scope="col"></th>

						</tr>
					</thead>
					<tbody>

						<c:forEach items="${hoaDon}" var="p">
							<tr>

								<td><b> ${p.orderID} </b>
								</td>

								<td><fmt:formatDate
										value="${p.orderDate}" pattern="dd/MM/yyyy" /></td>

								<td>${p.customerID.username }</td>

								<td><b><fmt:formatNumber
											value="${p.getTotalPrice()}" type="currency"
											currencyCode="VND" /></b></td>
								<td><a
									href="chitiethoadonadmin?orderID=${p.orderID}"
									style="text-decoration: none">
										<button class="btn btn-success btn-sm">Chi tiết hóa đơn</button>
								</a></td>

							</tr>
						</c:forEach>

					</tbody>
				</table>

			</main>
		</div>
	</div>

</body>
</html>