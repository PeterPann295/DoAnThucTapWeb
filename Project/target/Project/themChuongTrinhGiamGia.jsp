<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="common.jsp"%>
<link href="css/styleAdminPage.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/styleDangKi.css">
</head>
<body>
	<%@ include file="headerAdmin.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="navMenuAdmin.jsp"%>
			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div class="container_form" style="margin-top: 60px;">
					<form class="form-container" action="themctgiamgia" method="get"
						enctype="multipart/form-data">
						<h1 class="text-center text-success" >Thêm Chương Trình Giảm Giá</h1>
						<div class="mb-3">
							<label for="discountID" class="form-label">Mã Giảm Giá: </label> <input
								type="text" class="form-control" id="discountID" name="discountID"
								placeholder="Nhập mã danh mục">

						</div>
						<div class="mb-3">
							<label for="discountName" class="form-label">Tên Chương Trình: </label>
							<input type="text" class="form-control" id="discountName"
								name="discountName" placeholder="Nhập tên danh mục ">

						</div>

						<div class="mb-3">
							<label for="discountPercent" class="form-label">% Giảm Giá: </label> <input
								type="number" class="form-control" id="discountPercent" name="discountPercent"
								>
						</div>
						
						<div class="mb-3">
							<button type="submit" class="btn btn-primary width-btn">Thêm Chương Trình Giảm Giá</button>
						</div>
					</form>
				</div>
			</main>
		</div>
	</div>

</body>
</html>