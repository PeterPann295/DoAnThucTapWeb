<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xác nhận đặt hàng</title>
<%@ include file="common.jsp"%>
<script src="javascript/script.js"></script>
<link rel="stylesheet" type="text/css" href="css/styleDangKi.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<div class="container_form">
		<form class="form-container" action="xacnhandathang" method="get">
			<table class="table">
			
			<tr>
			<th colspan="2" style="text-align: center;"> <h3 class="text-success">Xác Nhận Mua Hàng</h3> </th>
			</tr>
			<tr>
			<td>Tên Khách Hàng</td>
			<td> ${order.getCustomerID().nameCustomer} </td>
			</tr>
			<tr>
			<td> Số Điện Thoại </td>
			<td> ${order.getCustomerID().numberPhone} </td>
			</tr>
			<tr>
			<td> Email </td>
			<td> ${order.getCustomerID().email} </td>
			</tr>
			<tr>
			<td> Địa Chỉ Nhận Hàng </td>
			<td> ${order.getCustomerID().address} </td>
			</tr>
			<tr>
			<td> Sản Phẩm </td>
			<td> <c:forEach var="p" items="${order.orderItems}"> 	
					<p> <img
					style="width: 40px; height: 40px" src="${p.getProductID().imageURL}" alt="Logo"
					> <b>${p.getProductID().nameProduct}</b>  : x${p.quantity} </p>
					</c:forEach>
			 </td>
			</tr>
			<tr>
			<td> <h5> Tổng tiền thanh toán </h5> </td>
			<td> <b><fmt:formatNumber value="${order.getTotalPrice()}" type="currency"
										currencyCode="VND" /></b> </td>
			</tr>
			</table>
			<button type="submit" class="btn btn-primary" style="width: 100%;">Xác Nhận Đặt Hàng</button>
		</form>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>