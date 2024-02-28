<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="productDAO" class="database.ProductDAO" scope="page" />
<jsp:useBean id="parentCategoryDAO" class="database.ParentCategoryDAO"
	scope="page" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="common.jsp"%>
<style>
.card:hover {
	border: 2px solid;
	border-color: #28a745;
}

.discount-percentage {
	position: absolute;
	top: 10px;
	left: 10px;
	background-color: red;
	color: white;
	padding: 5px;
	font-weight: bold;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div>

		<div id="myCarousel" class="carousel slide mb-6"
			data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" style="background-color: green"
					data-bs-target="#myCarousel" data-bs-slide-to="0" class="active"
					aria-current="true" aria-label="Slide 1"></button>
				<button type="button" style="background-color: green"
					data-bs-target="#myCarousel" data-bs-slide-to="1"
					aria-label="Slide 2"></button>
				<button type="button" style="background-color: green"
					data-bs-target="#myCarousel" data-bs-slide-to="2"
					aria-label="Slide 3"></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img alt="" src="img/fresh.png" style="width: 100%; height: 100%">
					<div class="container">
						<div class="carousel-caption text-start">
							<h1>Example headline.</h1>
							<p class="opacity-75 text-success"
								style="font-size: 33px; margin-bottom: 50px;">
								"Hãy yêu thương bản thân <br> mình, bằng những sản <br>
								phẩm chất lượng."
							</p>
							<p style="margin-bottom: 80px;">
								<a class="btn btn-lg btn-primary" href="#">Đăng nhập ngay!</a>
							</p>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<img alt="" src="img/slide2.png" style="width: 100%; height: 100%">
					<div class="container">
						<div class="carousel-caption">
							<p style="margin-right: 50px; margin-bottom: 80px;">
								<a class="btn btn-lg btn-primary" href="#">Xem Ngay</a>
							</p>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<img alt="" src="img/food.png" style="width: 100%; height: 100%">
					<div class="container">
						<div class="carousel-caption text-end"
							style="margin-bottom: 80px; margin-right: 45px;">
							<p style="margin-right: 20px">
								<a class="btn btn-lg btn-primary" href="#">Xem Ngay</a>
							</p>
						</div>
					</div>
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#myCarousel" data-bs-slide="prev">
				<span class="carousel-control-prev-icon"
					style="background-color: green" aria-hidden="true"></span> <span
					class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#myCarousel" data-bs-slide="next">
				<span class="carousel-control-next-icon"
					style="background-color: green" aria-hidden="true"></span> <span
					class="visually-hidden">Next</span>
			</button>


		</div>
		<hr>
	</div>



	<div style="margin: 40px;">

		<h3 class="text-success">Danh Mục Nổi Bật</h3>
		<hr class="border border-success border-1 opacity-75">

		<div class="row" style="margin-left: 10px">
			<c:forEach var="p" items="${parentCategoryDAO.selectAll()}">
				<div class="col-lg-4 col-md-6 mb-4 border-success"
					style="width: 160px; height: 150px">
					<div class="card h-110">
						<a
							href="bolocsanpham?parentCategoryID=${p.parentCategoryID}&hanhDong=parent-category"
							style="text-decoration: none" class="text-success"><img
							class="card-img-top" src="${p.imageURL}" alt="">
							<div class="card-body">
								<h6 class="text-center">${p.name}</h6>
								<p class="card-text">${product.desriptionString}</p>
							</div> </a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>


	<div style="margin: 40px; margin-top: 80px;">
		<h3 class="text-success">Khuyến Mãi Hấp Dẫn</h3>
		<hr class="border border-success border-1 opacity-75">

		<div class="row" style="margin-left: 30px">
			<c:forEach var="product"
				items="${productDAO.selectTop10HasDiscount()}">
				<div class="col-lg-4 col-md-6 mb-4"
					style="width: 216px; height: 355px">

					<div class="card">
						<a href="chitietsanpham?productID=${product.productID}"><img
							class="card-img-top" src="${product.imageURL}" alt=""></a>
						<div class="card-body">
							<h5 class="card-title">
								<a href="#" style="text-decoration: none">
									${product.nameProduct} </a>
							</h5>
							<p class="mt-1">ĐVT: ${product.unit}</p>
							<p>
								<span class="text-success"> <fmt:formatNumber
										value="${product.getFinalPrice()}" type="currency"
										currencyCode="VND" />
								</span> <span style="text-decoration: line-through; padding-left: 5px">
									<fmt:formatNumber value="${product.price}" type="currency"
										currencyCode="VND" />
								</span>
							</p>
							<span class="discount-percentage"> Giảm
								${product.discount.percent}% </span>
							<button class="ms-1 btn btn-success add-to-cart-btn"
								data-product-id="${product.productID}">
								<i class="bi bi-cart3"></i> Thêm Vào Giỏ
							</button>

						</div>

					</div>

				</div>
			</c:forEach>
		</div>
	</div>

	 
	 <input type="hidden" id="numberInput" value="1">
	 
	<div style="margin: 40px; margin-top: 40px;">
		<h3 class="text-success">Sản Phẩm Mới Nhất</h3>
		<hr class="border border-success border-1 opacity-75">

		<div class="row" style="margin-left: 30px">
			<c:forEach var="product" items="${productDAO.selectAllProductNew()}">
				<div class="col-lg-4 col-md-6 mb-4"
					style="width: 216px; height: 355px">

					<c:choose>
						<c:when test="${product.discount != null}">
							<div class="card">
								<a href="chitietsanpham?productID=${product.productID}"><img
									class="card-img-top" src="${product.imageURL}" alt=""></a>
								<div class="card-body">
									<h5 class="card-title">
										<a href="#" style="text-decoration: none">
											${product.nameProduct} </a>
									</h5>
									<p class="mt-1">ĐVT: ${product.unit}</p>
									<p>
										<span class="text-success"> <fmt:formatNumber
												value="${product.getFinalPrice()}" type="currency"
												currencyCode="VND" />
										</span> <span
											style="text-decoration: line-through; padding-left: 5px">
											<fmt:formatNumber value="${product.price}" type="currency"
												currencyCode="VND" />
										</span>
									</p>
									<span class="discount-percentage"> Giảm
										${product.discount.percent}% </span>
									<button class="ms-1 btn btn-success add-to-cart-btn"
										data-product-id="${product.productID}">
										<i class="bi bi-cart3"></i> Thêm Vào Giỏ
									</button>
								</div>

							</div>

						</c:when>
						<c:otherwise>
							<div class="card">
								<a href="chitietsanpham?productID=${product.productID}"><img
									class="card-img-top" src="${product.imageURL}" alt=""></a>
								<div class="card-body">
									<h5 class="card-title">
										<a href="#" style="text-decoration: none">
											${product.nameProduct} </a>
									</h5>
									<p class="mt-1">ĐVT: ${product.unit}</p>
									<p>
										<span class="text-success"> <fmt:formatNumber
												value="${product.getFinalPrice()}" type="currency"
												currencyCode="VND" />
										</span>
									</p>
									<button class="ms-1 btn btn-success add-to-cart-btn"
										data-product-id="${product.productID}">
										<i class="bi bi-cart3"></i> Thêm Vào Giỏ
									</button>
								</div>

							</div>
						</c:otherwise>
					</c:choose>

				</div>
			</c:forEach>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>

	<script src="javascript/scriptAjax.js"></script>



</html>