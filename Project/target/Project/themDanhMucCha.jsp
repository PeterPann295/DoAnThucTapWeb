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
					<form class="form-container" action="themdanhmuccha" method="post"
						enctype="multipart/form-data">
						<h1 class="text-center text-success" >Thêm Danh Mục Lớn</h1>
						<div class="mb-3">
							<label for="parentCateID" class="form-label">Mã Danh Mục: </label> <input
								type="text" class="form-control" id="parentCateID" name="parentCateID"
								placeholder="Nhập mã danh mục">

						</div>
						<div class="mb-3">
							<label for="parentCateName" class="form-label">Tên Danh Mục: </label>
							<input type="text" class="form-control" id="parentCateName"
								name="parentCateName" placeholder="Nhập tên danh mục ">

						</div>

						<div class="mb-3">
							<label for="imgCate" class="form-label">Hình Ảnh Danh Mục</label> <input
								type="file" class="form-control" id="imgCate" name="imgCate"
								>
						</div>
						
						<div class="mb-3">
							<button type="submit" class="btn btn-primary width-btn">Thêm Danh Mục Lớn</button>
						</div>
					</form>
				</div>
			</main>
		</div>
	</div>

</body>
</html>