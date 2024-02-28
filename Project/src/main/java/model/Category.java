package model;

public class Category {

	private String categoryID;
	private String nameCategory;
	private ParentCategory parent;

	public Category(String categoryID, String nameCategory, ParentCategory parent) {
		super();
		this.categoryID = categoryID;
		this.nameCategory = nameCategory;
		this.parent = parent;
	}

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public ParentCategory getParent() {
		return parent;
	}

	public void setParent(ParentCategory parent) {
		this.parent = parent;
	}

}
