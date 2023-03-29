package com.restaurant.services;

public class Category {
	int catid;
	String cname;

	public Category(int catid, String cname) {
		super();
		this.catid = catid;
		this.cname = cname;
	}

	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}
