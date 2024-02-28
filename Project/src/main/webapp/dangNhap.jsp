<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>

<%@ include file="common.jsp"%>

<link rel="stylesheet" type="text/css" href="css/styleDangNhap.css">


</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container_form content">
		<form action="DangNhap" method="post" class="form-container">
			<h1 class="text-center mb-3 text-success ">
				Đăng Nhập <a href="#" class="logo-link"> <img
					style="width: 60px; height: 60px" src="img/rau.png" alt="Logo"
					class="logo-image">
				</a>
			</h1>
			<div class="text-danger mb-3">${error_login}</div>
			<div class="form-group mb-2">
				<label class="margin-label" for="username">Tên đăng nhập:</label> <input
					type="text" class="form-control" id="username" name="username"
					placeholder="Nhập tên đăng nhập">
			</div>
			<div class="form-group mb-2">
				<label class="margin-label" for="password">Mật khẩu:</label> <input
					type="password" class="form-control" id="password" name="password"
					placeholder="Nhập mật khẩu">
			</div>
			<button type="submit" class="btn btn-primary mb-2 margin-button">Đăng
				Nhập</button>
			<div class="">
				<p>
					Nếu bạn chưa có tài khoản, hãy <a class="primary-link"
						href="dangKiTaiKhoan.jsp"> đăng kí </a>
						, hoặc bạn <a class="primary-link"
						href="quenMatKhau.jsp"> quên mật khẩu </a>
				</p>
			</div>
		</form>
	</div>
</body>

<footer>
	<%@ include file="footer.jsp"%>
</footer>

</html>