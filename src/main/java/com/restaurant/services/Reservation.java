package com.restaurant.services;

public class Reservation {
	int rid, oid, tid;
	String rtime, psize;

	public Reservation(int rid, int oid, int tid, String rtime, String psize) {
		super();
		this.rid = rid;
		this.oid = oid;
		this.tid = tid;
		this.rtime = rtime;
		this.psize = psize;
	}

	public Reservation(int oid, int tid, String rtime, String psize) {
		super();
		this.oid = oid;
		this.tid = tid;
		this.rtime = rtime;
		this.psize = psize;
	}

	public Reservation() {
		super();
	}

	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getRtime() {
		return rtime;
	}
	public void setRtime(String rtime) {
		this.rtime = rtime;
	}
	public String getPsize() {
		return psize;
	}
	public void setPsize(String psize) {
		this.psize = psize;
	}
}
