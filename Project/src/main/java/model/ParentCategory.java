package model;

public class ParentCategory {
	private String parentCategoryID;
	private String name;
	private String imageURL;
	
	public ParentCategory(String parentCategoryID, String name, String image) {
		super();
		this.parentCategoryID = parentCategoryID;
		this.name = name;
		this.imageURL = image;
	}
	public String getParentCategoryID() {
		return parentCategoryID;
	}
	public void setParentCategoryID(String parentCategoryID) {
		this.parentCategoryID = parentCategoryID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String image) {
		this.imageURL = image;
	}
	@Override
	public String toString() {
		return "ParentCategory [parentCategoryID=" + parentCategoryID + ", name=" + name + ", image=" + imageURL + "]";
	}

	
	
}
