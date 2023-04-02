package com.restaurant.users;

public class Customer extends User{
	int cid;

	public Customer(int cid, String fname, String lname, String phone, String email, String hashpwd) {
		super(fname, lname, phone, email, hashpwd);
		this.cid = cid;
	}
	
	public Customer(String fname, String lname, String phone, String email, String hashpwd) {
		super(fname, lname, phone, email, hashpwd);
	}
	
	public Customer(String fname, String lname, String phone, String email) {
		super(fname, lname, phone, email);
	}

	public Customer() {
		super();
	}
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
}
