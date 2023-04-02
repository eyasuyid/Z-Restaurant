package com.restaurant.users;

public class User {
	String fname, lname, phone, email, hashpwd;

	public User(String fname, String lname, String phone, String email, String hashpwd) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.email = email;
		this.hashpwd = hashpwd;
	}
	
	public User(String fname, String lname, String phone, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.email = email;
	}
	
	public User() {
		super();
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashpwd() {
		return hashpwd;
	}

	public void setHashpwd(String hashpwd) {
		this.hashpwd = hashpwd;
	}
}
