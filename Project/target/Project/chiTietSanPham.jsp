<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
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

	<div class="row ms-4 mt-4">

		<div class="col-lg-4  mt-4">

			<div class="container">
				<img alt="" src="${productDetail.imageURL}"
					style="width: 390px; height: 390px">

				<h5 class="mt-4">Mô Tả</h5>

				<h6 class="mt-4">${productDetail.nameProduct}</h6>

				<p class="mt-4 lh-base" style="text-align: justify;">${productDetail. desription}</p>
			</div>

		</div>

		<div class="col-lg-8">



			<table class="table">
				<thead>

					<tr>
						<th>
							<h3>${productDetail.nameProduct}</h3>
						</th>
					</tr>


				</thead>
				<tbody>

					<tr>
						<td>Giá Bán</td>
						<td><c:choose>
								<c:when test="${productDetail.discount != null}">
									<span class="text-success"> <fmt:formatNumber
											value="${productDetail.getFinalPrice()}" type="currency"
											currencyCode="VND" />
									</span>
									<span style="text-decoration: line-through; padding-left: 5px">
										<fmt:formatNumber value="${productDetail.price}"
											type="currency" currencyCode="VND" />
									</span>
								</c:when>
								<c:otherwise>
									<fmt:formatNumber value="${productDetail.price}"
										type="currency" currencyCode="VND" />
								</c:otherwise>
							</c:choose></td>
					</tr>


					<tr>
						<td>Tình Trạng</td>
						<td>Còn hàng</td>
					</tr>

					<tr>
						<td>Vận chuyển</td>
						<td>Miễn phí giao hàng cho đơn từ 300.000đ. Giao hàng trong 2
							giờ.</td>
					</tr>

					<tr>
						<td>Đơn vị tính</td>
						<td>${productDetail.unit}</td>
					</tr>

					<tr>
						<td>Số lượng</td>
						<td>
							<div class="btn-group">
								<button type="button" class="btn btn-info btn-sm"
									onclick="decrement()">
									<a><i class="bi bi-dash icon"></i></a>
								</button>
								<input type="text" class="form-control text-center input-sm"
									id="numberInput" name="amount" value="1" min="1" size="1">
								<button type="button" class="btn btn-info btn-sm"
									onclick="increment()">
									<a><i class="bi bi-plus icon"></i></a>
								</button>
							</div>
						</td>
					</tr>


				</tbody>
			</table>

			<button class="ms-1 btn btn-success add-to-cart-btn"
				data-product-id="${productDetail.productID}">
				<i class="bi bi-cart3"></i> Thêm Vào Giỏ
			</button>




			<table class="table mt-4">
				<thead>
					<tr>
						<th>
							<h5>Thông tin</h5>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Xuất xứ</td>
						<td>Việt Nam</td>
					</tr>
					<tr>
						<td>Thành phần</td>
						<td>Đang cập nhật</td>
					</tr>
					<tr>
						<td>Hướng dẫn sử dụng</td>
						<td>Đang cập nhật</td>
					</tr>
					<tr>
						<td>Bảo quản</td>
						<td>Đang cập nhật</td>
					</tr>
				</tbody>

			</table>
		</div>
	</div>

	<div class="ms-4 mt-4">

		<h4 style="margin-left: 20px">Sản phẩm liên quan</h4>

		<div class="row" style="margin-left: 30px">
			<c:forEach var="product" items="${productRelate}">
				<div class="col-lg-4 col-md-6 mb-4"
					style="width: 216px; height: 355px">

					<c:choose>
						<c:when test="${product.discount != null}">
							<div class="card">
								<a href="chitietsanpham?productID=${product.productID}"><img class="card-img-top"
									src="${product.imageURL}" alt=""></a>
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
									<button class="ms-1 btn btn-success add-to-cart-btn-one"
										data-product-id="${product.productID}">
										<i class="bi bi-cart3"></i> Thêm Vào Giỏ
									</button>
								</div>

							</div>

						</c:when>
						<c:otherwise>
							<div class="card">
								<a href="chitietsanpham?productID=${product.productID}"><img class="card-img-top"
									src="${product.imageURL}" alt=""></a>
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
									<button class="ms-1 btn btn-success add-to-cart-btn-one"
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
<script src="javascript/scriptAjax3.js"></script>
</html>