<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
<%@ include file="common.jsp"%>
<style type="text/css">
.size {
	width: 100px;
	height: 100px;
}

.icon {
	color: white;
	width: 40px;
	height: 40px;
}

.text {
	margin-top: 20px;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<h2 class="text-success text">Thông Tin Giỏ Hàng:  </h2>
		<h4 class="text"> <span> ${cartEmpty} </span> </h4>
		<div class="col-md-12">
			<div class="card card-plain">

				<div class="card-body">

					<div class="table-responsive">

						<table class="table table-shopping">
							<tr>

								<th class="text-center">Tên Sản Phẩm</th>
								<th class="text"></th>
								<th class="text-center">Số Lượng</th>
								<th class="text-center">Đơn Vị Tính</th>
								<th class="text-center">Đơn Giá</th>
								<th class="text-center">Thành Tiền</th>

							</tr>
							
							<c:forEach items="${cartOrder}" var="p">
								<tr>

									<td class="text-center align-middle">${p.getProductID().nameProduct}</td>
									<td>
										<div class="img-container">
											<img class="size" src="${p.getProductID().imageURL}" alt="">
										</div>
									</td>

									<td class="text-center align-middle">${p.quantity}
										<div class="btn-group">
											<button class="btn btn-info btn-sm">
												<a href="MinusSanPham?product=${p.getProductID().productID}"><i
													class="bi bi-dash icon"></i></a>
											</button>
											<button class="btn btn-info btn-sm">
												<a href="PlusSanPham?product=${p.getProductID().productID}"><i
													class="bi bi-plus icon"></i></a>
											</button>
										</div>
									</td>
									<td class="text-center align-middle">${p.getProductID().unit}</td>
									<c:choose>
										<c:when test="${p.getProductID().discount != null}">
											<td class="text-center align-middle"><span
												class="text-success"> <fmt:formatNumber
														value="${p.getProductID().getFinalPrice()}"
														type="currency" currencyCode="VND" />
											</span> <span
												style="text-decoration: line-through; padding-left: 5px">
													<fmt:formatNumber value="${p.getProductID().price}"
														type="currency" currencyCode="VND" />
											</span></td>
										</c:when>
										<c:otherwise>
										<td class="text-center align-middle"><fmt:formatNumber value="${p.getProductID().getFinalPrice()}"
												type="currency" currencyCode="VND" /> </td>	
										</c:otherwise>
									</c:choose>

									<td class="text-center align-middle"><fmt:formatNumber
											value="${p.getProductID().getFinalPrice() * p.quantity}"
											type="currency" currencyCode="VND" /></td>
								</tr>
							</c:forEach>
						</table>
						<div style="text-align: right; margin-right: 20px;">
							<p>
								Tổng Tiền:
								<fmt:formatNumber value="${totalPrice}" type="currency"
									currencyCode="VND" />
							</p>
							<a href="xacNhanDatHang.jsp">
								<button class="btn btn-success">Thanh Toán</button>
							</a>
						</div>
					</div>

				</div>

			</div>



		</div>
	</div>

</body>
</html>