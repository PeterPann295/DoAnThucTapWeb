<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<script src="javascript/script.js"></script>
<link rel="stylesheet" type="text/css" href="css/styleDangKi.css">
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

				<div class="container_form">
		<form class="form-container" action="dangkitaikhoanadmin" method="post">
			<h1 class="text-center text-success">
				Thêm Admin <a href="#" class="logo-link"> <img
					style="width: 80px; height: 80px" src="img/rau.png" alt="Logo"
					class="logo-image">
				</a>
			</h1>
			<div class="mb-3">
				<label for="username" class="form-label">Tên đăng nhập</label> <input
					type="text" class="form-control" id="username" name="username"
					placeholder="Nhập tên đăng nhập" value="${username}" required="required">
				<div class="text-danger"> ${requestScope.err_username} </div>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Mật khẩu</label>
				<div class="input-group">
					<input type="password" class="form-control" id="password"
						name="password" placeholder="Nhập mật khẩu"
						aria-describedby="button-addon2" value="${password}" required="required">
					<button class="btn btn-outline-secondary border border-start-0"
						type="button" id="button-addon2" onclick="hienThiMatKhau()">
						<img class="size" id="hienThi" alt="" src="img/hidden.png">
					</button>
				</div>
			</div>
			<div class="mb-3">
				<label for="confirm-password" class="form-label">Nhập lại
					mật khẩu</label>
				<div class="input-group">
					<input type="password" class="form-control" id="confirm-password"
						name="confirm-password" placeholder="Nhập mật khẩu"
						aria-describedby="button-addon2" required="required">
					<button class="btn btn-outline-secondary border border-start-0"
						type="button" id="button-addon2" onclick="hienThiMatKhau()">
						<img class="size" id="hienThi-confirm" alt="" src="img/hidden.png">
					</button>

				</div>
				<div class="text-danger"> ${err_password} </div>
			</div>
			<div class="mb-3">
				<label for="full-name" class="form-label">Họ và tên</label> <input
					type="text" class="form-control" id="full-name" name="full-name"
					placeholder="Nhập họ và tên" value="${fullName}" required="required">
			</div>
			<div class="mb-3">
				<label for="phone" class="form-label">Số điện thoại</label> <input
					type="tel" class="form-control" id="phone" name="phone"
					placeholder="Nhập số điện thoại" value="${phone}" required="required">
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email</label> <input
					type="email" class="form-control" id="email" name="email"
					placeholder="Nhập email" value="${email}" required="required">
			</div>
			<div class="mb-3">
				<label for="address" class="form-label">Địa chỉ</label>
				<textarea class="form-control" id="address" name="address" rows="3"
					placeholder="Nhập địa chỉ" required="required">${address}</textarea>
			</div>
			<button type="submit" class="btn btn-primary" style="width: 100%;">Đăng ký</button>
		</form>
	</div>

			</main>
		</div>
	</div>

</body>
</html>