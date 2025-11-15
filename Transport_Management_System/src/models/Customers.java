package models;

public class Customers {
	private int id;
	private String name;
	private long phone;
	private String email;
	
	public Customers() {
	}
	public Customers(String name,long phone,String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public long getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}

