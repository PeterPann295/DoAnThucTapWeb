package model;

public class Product {
	private String productID;
	private String nameProduct;
	private String desription;
	private double price;
	private String imageURL;
	private Category categoryID;
	private Discount discount;
	private String unit;
	private boolean available;
	public Product(String productID, String nameProduct, String desription, double price, String imageURL,
			Category categoryID, String unit, boolean available) {
		super();
		this.productID = productID;
		this.nameProduct = nameProduct;
		this.desription = desription;
		this.price = price;
		this.imageURL = imageURL;
		this.categoryID = categoryID;
		this.discount = null;
		this.unit = unit;
		this.available = available;
	}
	
	public Product(String productID, String nameProduct, String desription, double price, String imageURL,
			Category categoryID, Discount discount, String unit, boolean available) {
		super();
		this.productID = productID;
		this.nameProduct = nameProduct;
		this.desription = desription;
		this.price = price;
		this.imageURL = imageURL;
		this.categoryID = categoryID;
		this.discount = discount;
		this.unit = unit;
		this.available = available;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public String getDesription() {
		return desription;
	}
	public void setDesription(String desription) {
		this.desription = desription;
	}
	public double getPrice() {
			return price;
		
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public Category getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Category categoryID) {
		this.categoryID = categoryID;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public double getFinalPrice() {
		if (discount != null) {
			double pc = (double) discount.getPercent() / 100;
            double discountAmount = price * pc ;
            return price - discountAmount;
        } else {
            return price;
        }
	}
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", nameProduct=" + nameProduct + ", desription=" + desription
				+ ", price=" + price + ", imageURL=" + imageURL + ", categoryID=" + categoryID + ", discount="
				+ discount + "]";
	}
}
