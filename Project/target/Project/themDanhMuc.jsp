<%@page import="database.ParentCategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="parentCategoryDAO" class="database.ParentCategoryDAO" scope="session"/>

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
					<form class="form-container" action="themdanhmuc" method="get"
						enctype="multipart/form-data">
						<h1 class="text-center text-success">Thêm Danh Mục</h1>
						<div class="mb-3">
							<label for="categoryID" class="form-label">Mã Danh Mục: </label>
							<input type="text" class="form-control" id="categoryID"
								name="categoryID" placeholder="Nhập mã danh mục">

						</div>
						<div class="mb-3">
							<label for="categoryName" class="form-label">Tên Danh
								Mục: </label> <input type="text" class="form-control" id="categoryName"
								name="categoryName" placeholder="Nhập tên danh mục ">

						</div>

						<div class="mb-3">
							<label for="parent" class="form-label">Chọn Thể Loại
								Sản Phẩm</label> <select class="form-select" id="category"
								name="category">
								<c:forEach var="p" items="${parentCategoryDAO.selectAll()}">
									<option value="${p.parentCategoryID}">${p.name}</option>
								</c:forEach>
							</select>

						</div>

						<div class="mb-3 mt-4">
							<button type="submit" class="btn btn-primary width-btn">Thêm
								Danh Mục</button>
						</div>
					</form>
				</div>
			</main>
		</div>
	</div>

</body>
</html>