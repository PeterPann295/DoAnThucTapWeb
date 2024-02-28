<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết hóa đơn</title>
<%@ include file="common.jsp"%>
<script src="javascript/script.js"></script>
<link rel="stylesheet" type="text/css" href="css/styleDangKi.css">
</head>
<body>
	<%@ include file="headerAdmin.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="navMenuAdmin.jsp"%>
			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">

				<div class="container_form">
					<form class="form-container">
						<table class="table">

							<tr>
								<th colspan="2" style="text-align: center;">
									<h3 class="text-success">Chi Tiết Hóa Đơn</h3>
								</th>
							</tr>
							<tr>
								<td>Mã Hóa Đơn</td>
								<td>${orderDetail.orderID}</td>
							</tr>
							<tr>
								<td>Ngày Đặt Hàng</td>
								<td><fmt:formatDate
										value="${orderDetail.orderDate}" pattern="dd/MM/yyyy" /></td>
							</tr>
							<tr>
								<td>Tên Khách Hàng</td>
								<td>${orderDetail.getCustomerID().nameCustomer}</td>
							</tr>
							<tr>
								<td>Số Điện Thoại</td>
								<td>${orderDetail.getCustomerID().numberPhone}</td>
							</tr>
							<tr>
								<td>Email</td>
								<td>${orderDetail.getCustomerID().email}</td>
							</tr>
							<tr>
								<td>Địa Chỉ Nhận Hàng</td>
								<td>${orderDetail.getCustomerID().address}</td>
							</tr>
							<tr>
								<td>Sản Phẩm</td>
								<td><c:forEach var="p" items="${orderDetail.orderItems}">
										<p>
											<img style="width: 40px; height: 40px"
												src="${p.getProductID().imageURL}" alt="Logo">
											<b>${p.getProductID().nameProduct}</b> : 
											 <fmt:formatNumber value="${p.getProductID().getFinalPrice()}"
												type="currency" currencyCode="VND" />
											x${p.quantity}
										</p>
									</c:forEach></td>
							</tr>
							<tr>
								<td>
									<h5>Tổng tiền thanh toán</h5>
								</td>
								<td><b><fmt:formatNumber
											value="${orderDetail.getTotalPrice()}" type="currency"
											currencyCode="VND" /></b></td>
							</tr>
						</table>
						<a href="hoadonadmin" style="text-decoration: none">
							<button type="button" class="btn btn-primary"
								style="width: 100%;">Quay Về Danh Sách Hóa Đơn</button>
						</a>
					</form>
				</div>

			</main>
		</div>
	</div>
</body>
</html>