<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thay đổi mật khẩu</title>
<%@ include file="common.jsp"%>
<script src="javascript/script.js"></script>
<link rel="stylesheet" type="text/css" href="css/styleDangKi.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<div class="container_form">
		<form class="form-container" action="thaydoimatkhau" method="get">
			<h1 class="text-center text-success">
				Thay đổi mật khẩu <a href="#" class="logo-link"> <img
					style="width: 80px; height: 80px" src="img/rau.png" alt="Logo"
					class="logo-image">
				</a>
			</h1>
			
				<div class="mb-3">
				<label for="password" class="form-label">Mật khẩu mới</label>
				<div class="input-group">
					<input type="password" class="form-control" id="password"
						name="new-password" placeholder="Nhập mật khẩu mới"
						aria-describedby="button-addon2" value="${password}" required="required">
					<button class="btn btn-outline-secondary border border-start-0"
						type="button" id="button-addon2" onclick="hienThiMatKhau()">
						<img class="size" id="hienThi" alt="" src="img/hidden.png">
					</button>
				</div>
			</div>
			
			<div class="mb-3">
				<label for="confirm-password" class="form-label">Nhập lại
					mật khẩu mới</label>
				<div class="input-group">
					<input type="password" class="form-control" id="confirm-password"
						name="confirm-newPassword" placeholder="Nhập lại mật khẩu mới"
						aria-describedby="button-addon2" required="required">
					<button class="btn btn-outline-secondary border border-start-0"
						type="button" id="button-addon2" onclick="hienThiMatKhau()">
						<img class="size" id="hienThi-confirm" alt="" src="img/hidden.png">
					</button>

				</div>
				<div class="text-danger"> ${err_password} </div>
			</div>
			
			<button type="submit" class="btn btn-primary" style="width: 100%;">Thay đổi mật khẩu</button>
		</form>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>