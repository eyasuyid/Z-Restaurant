package com.restaurant.services;

public class OrderInfo {
	int oid, cid;
	String time, type;
	float tprice;

	public OrderInfo(int oid, int cid, String time, String type, float tprice) {
		super();
		this.oid = oid;
		this.cid = cid;
		this.time = time;
		this.type = type;
		this.tprice = tprice;
	}

	public OrderInfo(int cid, String time, String type, float tprice) {
		super();
		this.cid = cid;
		this.time = time;
		this.type = type;
		this.tprice = tprice;
	}

	public OrderInfo() {
		super();
	}

	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getTprice() {
		return tprice;
	}
	public void setTprice(float tprice) {
		this.tprice = tprice;
	}
}
