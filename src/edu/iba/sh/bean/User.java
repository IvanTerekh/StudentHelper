package edu.iba.sh.bean;

public class User {
	
	private String user;
	
	private String password;
	
	private String role;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/*public User(String user, String password, String role) {
		super();
		this.user = user;
		this.password = password;
		this.role = role;
	}*/

}
