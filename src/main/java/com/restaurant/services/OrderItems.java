package com.restaurant.services;

public class OrderItems {
	int oid, mid;
	String status;
	public OrderItems(int oid, int mid, String status) {
		super();
		this.oid = oid;
		this.mid = mid;
		this.status = status;
	}

	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
