<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="customerDAO" class="database.CustomerDAO" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Khách hàng</title>
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
					<h3 class="h2">Danh Sách Khách Hàng</h3>
					<div class="btn-toolbar mb-2 mb-md-0"></div>
				</div>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Tên Đăng Nhập</th>
							<th scope="col">Tên Khách Hàng</th>
							<th scope="col">Số Điện Thoại</th>
							<th scope="col">Email</th>
							<th scope="col">Địa Chỉ</th>
							<th scope="col"></th>

						</tr>
					</thead>
					<tbody>

						<c:forEach var="p" items="${customerDAO.selectAll()}">
							<tr>
								<th scope="row">${p.id}</th>
								<td>${p.username}</td>
								<td>${p.nameCustomer}</td>
								<td>${p.numberPhone}</td>
								<td>${p.email}</td>
								<td> ${p.address} </td>
								
							</tr>

						</c:forEach>

					</tbody>
				</table>

			</main>
		</div>
	</div>

</body>
</html>