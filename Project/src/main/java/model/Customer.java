package model;

public class Customer {
	private int id;
	private String username;
	private String password;
	private String nameCustomer;
	private String numberPhone;
	private String email;
	private String address;
	private boolean role;

	public Customer(String username, String password, String nameCustomer, String numberPhone, String email,
			String address) {
		super();
		this.id = 0;
		this.username = username;
		this.password = password;
		this.nameCustomer = nameCustomer;
		this.numberPhone = numberPhone;
		this.email = email;
		this.address = address;
		this.role = false;
	}

	public Customer(int id, String username, String password, String nameCustomer, String numberPhone, String email,
			String address, boolean role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nameCustomer = nameCustomer;
		this.numberPhone = numberPhone;
		this.email = email;
		this.address = address;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Customers [username=" + username + ", password=" + password + ", nameCustomer=" + nameCustomer
				+ ", numberPhone=" + numberPhone + ", email=" + email + ", address=" + address + "]";
	}

}
