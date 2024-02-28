<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.card-hover:hover {
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
	<jsp:include page="header.jsp" />

	<div class="row mt-4">

		<jsp:include page="boLocSanPham.jsp"></jsp:include>

		<div class="col-lg-9">
			<h3 style="text-align: center;"> <span> ${emtyProduct} </span> </h3>
			<div class="row" style="margin-left: 30px">
				<c:forEach var="product" items="${productList}">
					<div class="col-lg-4 col-md-6 mb-4"
						style="width: 216px; height: 355px">

						<c:choose>
							<c:when test="${product.discount != null}">
								<div class="card card-hover">
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
											${product.discount.percent}% </span> <button class="ms-1 btn btn-success add-to-cart-btn-one"
										data-product-id="${product.productID}">
										<i class="bi bi-cart3"></i> Thêm Vào Giỏ
									</button>
									</div>

								</div>

							</c:when>
							<c:otherwise>
								<div class="card card-hover">
									<a href="#"><img class="card-img-top"
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

	</div>

</body>
<script src="javascript/scriptAjax.js"></script>

</html>