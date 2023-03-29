package com.restaurant.services;

public class Delivery {
	int did,oid, dmid;
	String dtime, address;

	public Delivery(int did, int oid, int dmid, String dtime, String address) {
		super();
		this.did = did;
		this.oid = oid;
		this.dmid = dmid;
		this.dtime = dtime;
		this.address = address;
	}

	public Delivery(int oid, int dmid, String dtime, String address) {
		super();
		this.oid = oid;
		this.dmid = dmid;
		this.dtime = dtime;
		this.address = address;
	}

	public Delivery() {
		super();
	}

	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getDmid() {
		return dmid;
	}
	public void setDmid(int dmid) {
		this.dmid = dmid;
	}
	public String getDtime() {
		return dtime;
	}
	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
