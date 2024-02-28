package model;

public class Contact {
	private int contactId;
	private String name;
	private String numberPhone;
	private String email;
	private String content;
	public Contact(int contactId, String name, String numberPhone, String email, String content) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.numberPhone = numberPhone;
		this.email = email;
		this.content = content;
	}
	public Contact( String name, String numberPhone, String email, String content) {
		super();
		this.name = name;
		this.numberPhone = numberPhone;
		this.email = email;
		this.content = content;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", name=" + name + ", numberPhone=" + numberPhone + ", email="
				+ email + ", content=" + content + "]";
	}
	
}
