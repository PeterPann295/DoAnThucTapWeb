/**
 * 
 */

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
		var productId = $(this).data("product-id");
		var amount = document.getElementById('numberInput').value;
		$.ajax({
			type: "POST",
			url: "themvaogiohang",
			data: {
				product: productId,
				amount: amount
			},
			success: function(response) {
				// Update cart size
				$("#cart-size").text(response.cartSize);
			},
			error: function(error) {
				console.log("Error: " + error);
			}
		});
	});
});

$(document).ready(function() {
	$(".add-to-cart-btn-one").click(function() {
		var productId = $(this).data("product-id");
		var amount = 1;
		$.ajax({
			type: "POST",
			url: "themvaogiohang",
			data: {
				product: productId,
				amount: amount
			},
			success: function(response) {
				// Update cart size
				$("#cart-size").text(response.cartSize);
			},
			error: function(error) {
				console.log("Error: " + error);
			}
		});
	});
});
