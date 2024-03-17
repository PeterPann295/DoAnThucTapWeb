<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đơn hàng</title>
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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('.cancel-order-btn').click(function() {
            var orderId = $(this).data('order-id');
            cancelOrder(orderId);
        });
    });

    function cancelOrder(orderId) {
        $.ajax({
            url: 'cancelOrderServlet',
            type: 'POST',
            data: {
                orderId: orderId
            },
            success: function(data) {
                // Cập nhật trạng thái của đơn hàng trên trang
                $('#order-status-' + orderId).text('Đã hủy');
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
            }
        });
    }
</script>
</head>
<body>
    <%@ include file="header.jsp"%>
    <div class="container">
        <h2 class="text-success text">Lịch Sử Mua Hàng:</h2>
        <h4 class="text">
            <span> ${emptyOrder} </span>
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
                                <th class="text-center">Trạng Thái</th>
                                <th class="text-center">Hành Động</th>
                            </tr>
                            <c:forEach items="${historyOrder}" var="p">
                                <tr>
                                    <td class="text-center align-middle"> <b> ${p.orderID} </b> </td>
                                    <td class="text-center align-middle"><fmt:formatDate value="${p.orderDate}" pattern="dd/MM/yyyy" /></td>
                                    <td class="text-center"><c:forEach items="${p.orderItems}" var="c">
                                            <p>
                                                <img style="width: 40px; height: 40px"
                                                    src="${c.getProductID().imageURL}" alt="Logo">
                                                <b>${c.getProductID().nameProduct}</b> :<fmt:formatNumber value="${c.getProductID().getFinalPrice()}"
                                                    type="currency" currencyCode="VND" /> x${c.quantity}
                                            </p>
                                        </c:forEach></td>
                                    <td class="text-center align-middle"><b><fmt:formatNumber value="${p.getTotalPrice()}"
                                                type="currency" currencyCode="VND" /></b></td>
                                    <td id="order-status-${p.orderID}" class="text-center align-middle">${p.orderStatus}</td>
                                    <td class="text-center align-middle">
                                        <c:if test="${p.orderStatus != 'Thành công'}">
                                            <button class="btn btn-danger cancel-order-btn" data-order-id="${p.orderID}">Hủy đơn hàng</button>
                                        </c:if>
                                    </td>
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
