<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="productDAO" class="database.ProductDAO" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sản phẩm</title>
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
					<h3 class="h2">Danh Sách Sản Phẩm</h3>
					<div class="btn-toolbar mb-2 mb-md-0">
						<a href="themSanPhamAdmin.jsp">
							<button type="button" class="btn btn-sm btn-outline-success">
								Thêm Sản Phẩm</button>
						</a>
					</div>
				</div>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col"></th>
							<th scope="col">Tên Sản Phẩm</th>
							<th scope="col">Giá Bán</th>
							<th scope="col">Danh Mục</th>
							<th scope="col">CT Giảm Giá</th>
							<th scope="col">Trình Trạng</th>
							<th scope="col"></th>


						</tr>
					</thead>
					<tbody>

						<c:forEach var="p" items="${productDAO.selectAll()}">
							<tr>
								<th scope="row">${p.productID}</th>
								<td><img style="width: 60px; height: 50px"
									src="${p.imageURL}" alt="Logo" class="logo-image"></td>
								<td>${p.nameProduct}</td>
								<td><fmt:formatNumber value="${p.price}" type="currency"
										currencyCode="VND" /></td>
								<td>${p.categoryID.nameCategory}</td>
								<td><c:choose>
										<c:when test="${p.discount != null}">
							
							${p.discount.nameDiscount }
						

						</c:when>
										<c:otherwise>
							Không 
						</c:otherwise>
									</c:choose></td>
								<td><c:choose>
										<c:when test="${p.available}">
							
							Còn Hàng
						

						</c:when>
										<c:otherwise>
							Hết Hàng
						</c:otherwise>
									</c:choose></td>
								<td><a href="chinhsuasanpham?productID=${p.productID}"
									style="text-decoration: none">
										<button class="btn btn-success btn-sm">Chỉnh Sửa</button>
								</a> <a href="xoasanpham?productID=${p.productID}"
									style="text-decoration: none">
										<button class="btn btn-success btn-sm">Xóa SP</button>
								</a>
							</tr>

						</c:forEach>

					</tbody>
				</table>

			</main>
		</div>
	</div>

</body>
</html>