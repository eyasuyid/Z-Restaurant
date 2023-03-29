package com.restaurant.services;

public class Table {
	int tid;
	String status;
	float psize;

	public Table(int tid, String status, float psize) {
		super();
		this.tid = tid;
		this.status = status;
		this.psize = psize;
	}
	
	public Table(String status, float psize) {
		super();
		this.status = status;
		this.psize = psize;
	}
	
	public Table() {
		super();
	}

	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getPsize() {
		return psize;
	}
	public void setPsize(float psize) {
		this.psize = psize;
	}
}
