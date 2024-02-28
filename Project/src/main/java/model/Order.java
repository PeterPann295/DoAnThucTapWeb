package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
	private String orderID;
	private Customer customerID;
	private Date orderDate;
	private List<OrderItem> orderItems;
	public Order(Customer customerID, Date orderDate, List<OrderItem> orderItems) {
		super();
		this.orderID = createOrderID();
		this.customerID = customerID;
		this.orderDate = orderDate;
		this.orderItems = orderItems;
	}
	
	public Order(String orderID, Customer customerID, Date orderDate) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.orderDate = orderDate;
		this.orderItems = new ArrayList<OrderItem>();
	}
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
	
	public String createOrderID() {
		Random rd = new Random();
		int number = rd.nextInt(100);
		String result = "OD"  + String.valueOf(number) + String.valueOf(number);
		return result;
	}
	public double getTotalPrice() {
		double result = 0;
		for (OrderItem orderItem : orderItems) {
			result += orderItem.getQuantity() * orderItem.getProductID().getFinalPrice();
		}
		return result;
	}
	
}
