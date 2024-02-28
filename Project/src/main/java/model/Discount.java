package model;

public class Discount {
	private String discountID;
	private String nameDiscount;
	private int percent;
	
	
	public Discount(String discountID, String nameDiscount, int percent) {
		super();
		this.discountID = discountID;
		this.nameDiscount = nameDiscount;
		this.percent = percent;
	}


	public String getDiscountID() {
		return discountID;
	}


	public void setDiscountID(String discountID) {
		this.discountID = discountID;
	}


	public String getNameDiscount() {
		return nameDiscount;
	}


	public void setNameDiscount(String nameDiscount) {
		this.nameDiscount = nameDiscount;
	}


	public int getPercent() {
		return percent;
	}


	public void setPercent(int percent) {
		this.percent = percent;
	}


	@Override
	public String toString() {
		return "Discount [discountID=" + discountID + ", nameDiscount=" + nameDiscount + ", percent=" + percent + "]";
	}
	
}
