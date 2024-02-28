
function increment() {
		var inputElement = document.getElementById('numberInput');
		var currentValue = parseInt(inputElement.value, 10);
		inputElement.value = currentValue + 1;
	};

	function decrement() {
		var inputElement = document.getElementById('numberInput');
		var currentValue = parseInt(inputElement.value, 10);
		if (currentValue > 1) {
			inputElement.value = currentValue - 1;
		}
	};

$(document).ready(function() {
    $(".add-to-cart-btn").click(function() {
        // Lưu trữ $(this) vào biến để sử dụng trong hàm success
        var addButton = $(this);

        // Kiểm tra session của khách hàng
        $.ajax({
            type: "GET",
            url: "kiemtraSessionKhachHang",
            success: function(response) {
                if (response.isLoggedIn) {
                    // Nếu đã đăng nhập, thực hiện AJAX request để thêm vào giỏ hàng
                    var productId = addButton.data("product-id"); // Sử dụng biến addButton thay vì $(this)
                    var amount = document.getElementById('numberInput').value;
                    $.ajax({
                        type: "POST",
                        url: "themvaogiohang",
                        data: {
                            product: productId,
                            amount: amount
                        },
                        success: function(response) {
                            // Cập nhật kích thước giỏ hàng
                            $("#cart-size").text(response.cartSize);
                        },
                        error: function(error) {
                            console.log("Error: " + error);
                        }
                    });
                } else {
                    // Nếu chưa đăng nhập, chuyển hướng đến trang đăng nhập
                    window.location.href = "dangNhap.jsp";
                }
            },
            error: function(error) {
                console.log("Error: " + error);
            }
        });
    });
});
/**
 * 
 */