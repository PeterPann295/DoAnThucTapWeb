<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="categoryDAO" class="database.CategoryDAO" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh Mục</title>
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

				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h3 class="h2">Danh Sách Danh Mục</h3>
					<div class="btn-toolbar mb-2 mb-md-0">
						<a href="themDanhMuc.jsp">
							<button type="button" class="btn btn-sm btn-outline-success">
								Thêm Danh Mục</button>
						</a>
					</div>
				</div>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col" >Tên Danh Mục</th>
							<th scope="col">Tên Danh Mục Cha</th>

						</tr>
					</thead>
					<tbody>

						<c:forEach var="p" items="${categoryDAO.selectAll()}">
							<tr>
								<th scope="row"> ${p.categoryID}  </th>
								<td> ${p.nameCategory} </td>
								<td> ${p.parent.name}  </td>

						</c:forEach>

					</tbody>
				</table>

			</main>
		</div>
	</div>

</body>
</html>