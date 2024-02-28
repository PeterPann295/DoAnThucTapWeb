<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="productDAO" class="database.ProductDAO" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Top 5 sản phẩm bán chạy nhất </title>
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
					<h3 class="h2">Top 5 Sản Phẩm Bán Chạy Nhất</h3>
					<div class="btn-toolbar mb-2 mb-md-0">
						
					</div>
				</div>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col" ></th>
							<th scope="col">Tên Sản Phẩm</th>
							<th scope="col">Giá Bán</th>
							<th scope="col">Danh Mục</th>
							<th scope="col">CT Giảm Giá</th>
							<th scope="col">Tổng Số Lượng Đã Bán</th>

						</tr>
					</thead>
					<tbody>

						<c:forEach var="p" items="${productDAO.selectTop5BestSeller()}">
							<tr>
								<th scope="row"> ${p.productID}  </th>
								<td> <img
						style="width: 60px; height: 50px" src="${p.imageURL}" alt="Logo"
						class="logo-image"> </td>
								<td> ${p.nameProduct} </td>
								<td>  <fmt:formatNumber value="${p.price}" type="currency" currencyCode="VND" /> </td>
								<td> ${p.categoryID.nameCategory} </td>
								<td> 
								
										<c:choose>
						<c:when test="${p.discount != null}">
							
							${p.discount.nameDiscount }
						

						</c:when>
						<c:otherwise>
							Không 
						</c:otherwise>
					</c:choose>
								
								 </td>
								<td class="text-center align-middle"> ${productDAO.tongSoBanDuoc(p.productID)} </td>
							</tr>

						</c:forEach>

					</tbody>
				</table>

			</main>
		</div>
	</div>

</body>
</html>