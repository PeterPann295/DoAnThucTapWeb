<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu thành công</title>
<%@ include file="common.jsp"%>
<link rel="stylesheet" type="text/css" href="css/styleDangKi.css">
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container_form">

		<form class="form-container" action="" method="post" style="margin-top: 60px">
			<h1 class="text-center text-success">
				Quên Mật Khẩu <a href="#" class="logo-link"> <img
					style="width: 80px; height: 80px" src="img/rau.png" alt="Logo"
					class="logo-image">
				</a>
			</h1>
			
			<b> Chúng tôi đã gửi mật khẩu về email: ${email},  <a class="link-warning" href="dangNhap.jsp"> Đăng Nhập Ngay ! </a> </b>
			
		</form>
	</div>
	<footer style="margin-top: 140px">
	<%@ include file="footer.jsp"%>
	</footer>
</body>
</html>