package com.restaurant.users;

public class Employee extends User {
	int eid;
	String position, status, shift;

	public Employee(String fname, String lname, String phone, String email, String hashpwd, int eid, String position,
			String status, String shift) {
		super(fname, lname, phone, email, hashpwd);
		this.eid = eid;
		this.position = position;
		this.status = status;
		this.shift = shift;
	}
	
	public Employee(String fname, String lname, String phone, String email, String hashpwd, String position,
			String status, String shift) {
		super(fname, lname, phone, email, hashpwd);
		this.position = position;
		this.status = status;
		this.shift = shift;
	}

	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
}
