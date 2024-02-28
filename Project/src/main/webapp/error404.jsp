<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error 404</title>
<%@ include file="common.jsp"%>
<link rel="stylesheet" type="text/css" href="css/styleDangKi.css">
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container_form">

		<form class="form-container" action="" method="post" style="margin-top: 60px">
			<h1 class="text-center text-success">
				Error 404  <a href="#" class="logo-link"> <img
					style="width: 80px; height: 80px" src="img/rau.png" alt="Logo"
					class="logo-image">
				</a>
			</h1>
			<h4>Trang Bạn Tìm Không Tồn Tại <b> Quay Về  <a class="link-warning" href="trangChu.jsp"> Trang Chủ ! </a> </b></h4>
			
			
		</form>
	</div>
	<footer style="margin-top: 140px">
	<%@ include file="footer.jsp"%>
	</footer>
</body>
</html>