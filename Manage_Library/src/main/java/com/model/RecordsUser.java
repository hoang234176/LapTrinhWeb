package com.model;

public class RecordsUser {
	private String fname;
	private String title;
	private String borrow_date;
	private String return_date;
	private String status;
	
	public RecordsUser() {
		super();
	}

	public RecordsUser(String fname, String title, String borrow_date, String return_date, String status) {
		super();
		this.fname = fname;
		this.title = title;
		this.borrow_date = borrow_date;
		this.return_date = return_date;
		this.status = status;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBorrow_date() {
		return borrow_date;
	}

	public void setBorrow_date(String borrow_date) {
		this.borrow_date = borrow_date;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
