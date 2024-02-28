<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thay đổi mật khẩu thành công</title>
<%@ include file="common.jsp"%>
<link rel="stylesheet" type="text/css" href="css/styleDangKi.css">
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container_form">

		<form class="form-container" action="" method="post" style="margin-top: 60px">
			<h1 class="text-center text-success">
				Thay Đổi Mật Khẩu <a href="#" class="logo-link"> <img
					style="width: 80px; height: 80px" src="img/rau.png" alt="Logo"
					class="logo-image">
				</a>
			</h1>
			
			<b>  Thay đổi mật khẩu thành công, vui lòng  <a class="link-warning" href="dangNhap.jsp"> Đăng Nhập Lại ! </a> </b>
			
		</form>
	</div>
	<footer style="margin-top: 140px">
	<%@ include file="footer.jsp"%>
	</footer>
</body>
</html>