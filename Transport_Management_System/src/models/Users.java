package models;

public class Users {
	private int id;
	private String username;
	private String password;
	private String role;
	
	public Users() {
		
	}
	public Users(String username,String password,String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return username;
	}
	public String getPass() {
		return password;
	}
	public String getRole() {
		return role;
	}
	public void setName(String username) {
		this.username = username;
	}
	public void setPass(String password) {
		this.password = password;
	}
	public void setRole(String role) {
		this.role = role;
	}

}

