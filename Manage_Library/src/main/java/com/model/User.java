package com.model;

public class User {
	private int user_id;
	private String fname;
	private String password;
	private String email;
	private String role;
	
	public User() {
		super();
	}

	public User(int user_id, String fname, String password, String email, String role) {
		super();
		this.user_id = user_id;
		this.fname = fname;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
