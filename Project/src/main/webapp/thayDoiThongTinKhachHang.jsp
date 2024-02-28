<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thay đổi thông tin</title>
<%@ include file="common.jsp"%>
<script src="javascript/script.js"></script>
<link rel="stylesheet" type="text/css" href="css/styleDangKi.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<div class="container_form">
		<form class="form-container" action="thaydoithongtinkhachhang" method="get">
			<h1 class="text-center text-success">
				Thay đổi thông tin <a href="#" class="logo-link"> <img
					style="width: 80px; height: 80px" src="img/rau.png" alt="Logo"
					class="logo-image">
				</a>
			</h1>
			
			<div class="mb-3">
				<label for="full-name" class="form-label">Họ và tên</label> <input
					type="text" class="form-control" id="full-name" name="full-name"
					placeholder="Nhập họ và tên" value="${customer.nameCustomer}" required="required">
			</div>
			<div class="mb-3">
				<label for="phone" class="form-label">Số điện thoại</label> <input
					type="tel" class="form-control" id="phone" name="phone"
					placeholder="Nhập số điện thoại" value="${customer.numberPhone}" required="required">
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email</label> <input
					type="email" class="form-control" id="email" name="email"
					placeholder="Nhập email" value="${customer.email}" required="required">
			</div>
			<div class="mb-3">
				<label for="address" class="form-label">Địa chỉ</label>
				<textarea class="form-control" id="address" name="address" rows="3"
					placeholder="Nhập địa chỉ" required="required">${customer.address}</textarea>
			</div>
			<button type="submit" class="btn btn-primary" style="width: 100%;">Thay đổi thông tin</button>
		</form>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>