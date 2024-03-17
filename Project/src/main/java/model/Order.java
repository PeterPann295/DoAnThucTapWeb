package model;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
    private String orderID;
    private Customer customerID;
    private Date orderDate;
    private List<OrderItem> orderItems;
    private String orderStatus;

    public Order(Customer customerID, Date orderDate, List<OrderItem> orderItems) {
        this.orderID = createOrderID();
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
        this.orderStatus = "Chưa duyệt"; // Mặc định đơn hàng mới chưa được duyệt
    }

    public Order(String orderID, Customer customerID, Date orderDate) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.orderItems = new ArrayList<>();
        this.orderStatus = "Chưa duyệt"; // Mặc định đơn hàng mới chưa được duyệt
    }

    // Getters and setters

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
	public double getTotalPrice() {
		double result = 0;
		for (OrderItem orderItem : orderItems) {
			result += orderItem.getQuantity() * orderItem.getProductID().getFinalPrice();
		}
		return result;
	}

    // Tạo mã đơn hàng
    private String createOrderID() {
        Random rd = new Random();
        int number = rd.nextInt(100);
        return "OD" + number + number;
    }

    // Cập nhật trạng thái của đơn hàng
    public void updateOrderStatus() {
        switch (orderStatus) {
            case "Chưa duyệt":
                if (isOrderOverdue()) {
                    orderStatus = "Thành công";
                }
                break;
            case "Chờ xác nhận":
                if (isOrderCancelled()) {
                    orderStatus = "Hủy";
                }
                break;
            // Xử lý các trạng thái khác nếu cần
            default:
                break;
        }
    }

    // Kiểm tra xem đơn hàng đã quá thời gian 10 phút chưa
    private boolean isOrderOverdue() {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime orderTime = orderDate.toLocalDate().atStartOfDay();
        Duration duration = Duration.between(orderTime, currentTime);
        return duration.toMinutes() >= 10;
    }

    // Kiểm tra xem người dùng đã hủy đơn hàng chưa
    private boolean isOrderCancelled() {
        // Logic kiểm tra xem người dùng đã hủy đơn hàng hay không
        return false; // Đây chỉ là ví dụ, cần thay bằng logic phù hợp
    }
}
