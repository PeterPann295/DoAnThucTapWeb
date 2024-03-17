<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>

<%@ include file="common.jsp"%>

<link rel="stylesheet" type="text/css" href="css/styleDangNhap.css">


</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container_form content">
		<form action="quenmatkhau" method="get" class="form-container">
			<h1 class="text-center mb-3 text-success ">
				Quên Mật Khẩu <a href="#" class="logo-link"> <img
					style="width: 60px; height: 60px" src="img/rau.png" alt="Logo"
					class="logo-image">
				</a>
			</h1>
			<div class="text-danger mb-3">${error}</div>
			<div class="form-group mb-2">
				<label class="margin-label" for="username"> Vui lòng nhập tên đăng nhập:</label> <input
					type="text" class="form-control" id="username" name="username"
					placeholder="Nhập tên đăng nhập">
			</div>
			<button type="submit" class="btn btn-primary mb-2 margin-button">
				Lấy lại mật khẩu</button>
			
		</form>
	</div>
</body>

<footer>
	<%@ include file="footer.jsp"%>
</footer>

</html>