package model;

public class OrderItem {
	private Order orderID;
	private Product productID;
	private int quantity;
	public OrderItem( Order orderID, Product productID, int quantity) {
		super();
		
		this.orderID = orderID;
		this.productID = productID;
		this.quantity = quantity;
	}
	public Order getOrderID() {
		return orderID;
	}
	public void setOrderID(Order orderID) {
		this.orderID = orderID;
	}
	public Product getProductID() {
		return productID;
	}
	public void setProductID(Product productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
