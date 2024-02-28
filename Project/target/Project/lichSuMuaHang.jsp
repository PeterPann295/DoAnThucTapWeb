<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<h2 class="text-success text">Lịch Sử Mua Hàng:</h2>
		<h4 class="text">
			<span> ${emtyOrder} </span>
		</h4>
		<div class="col-md-12">
			<div class="card card-plain">

				<div class="card-body">

					<div class="table-responsive">

						<table class="table table-shopping">
							<tr>

								<th class="text-center">Mã Đơn Hàng</th>
								<th class="text-center">Ngày Đặt</th>
								<th class="text-center">Sản Phẩm</th>
								<th class="text-center">Tổng Tiền</th>

							</tr>

							<c:forEach items="${historyOrder}" var="p">
								<tr>

									<td class="text-center align-middle">${p.orderID}</td>

									<td class="text-center align-middle">${p.orderDate}</td>

									<td><c:forEach items="${p.orderItems}" var="c">

											<p>
												<img style="width: 40px; height: 40px"
													src="${c.getProductID().imageURL}" alt="Logo">
												<b>${c.getProductID().nameProduct}</b> : x${c.quantity}
											</p>

										</c:forEach></td>

									<td><b><fmt:formatNumber value="${p.getTotalPrice()}"
												type="currency" currencyCode="VND" /></b></td>
								</tr>

							</c:forEach>
						</table>

					</div>

				</div>

			</div>



		</div>
	</div>

</body>
</html>