<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="contactDAO" class="database.ContactDAO" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liên hệ</title>
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
					<h3 class="h2">Danh Sách Phản Hồi Từ Khách Hàng</h3>
					<div class="btn-toolbar mb-2 mb-md-0"></div>
				</div>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Tên Người Gửi</th>
							<th scope="col">Số Điện Thoại</th>
							<th scope="col">Email</th>
							<th scope="col">Nội Dung</th>



						</tr>
					</thead>
					<tbody>

						<c:forEach var="p" items="${contactDAO.selectAll()}">
							<tr>
								<th scope="row">${p.contactId}</th>
								<td>${p.name}</td>
								<td>${p.numberPhone}</td>
								<td>${p.email}</td>
								<td>${p.content}</td>
								<td>
								<a href="lienhe?hanhDong=phanHoi&contactID=${p.contactId}" style="text-decoration: none"> <button class="btn btn-success btn-sm"> Phản Hồi </button> </a> </td>
						</c:forEach>

					</tbody>
				</table>

			</main>
		</div>
	</div>

</body>
</html>