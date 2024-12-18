package com.model;

public class User {
	private String fname;
	private String email;
	private String password;
	private String role;
	
	public User() {
		super();
	}

	public User(String fname, String email, String password, String role) {
		super();
		this.fname = fname;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}