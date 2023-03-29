package com.restaurant.services;

public class Menu {
	int mid, catid;
	String mname, image;
	float price;
	String desc, quality;

	public Menu(int mid, int catid, String mname, String image, float price, String desc, String quality) {
		super();
		this.mid = mid;
		this.catid = catid;
		this.mname = mname;
		this.image = image;
		this.price = price;
		this.desc = desc;
		this.quality = quality;
	}
	
	public Menu(int catid, String mname, String image, float price, String desc, String quality) {
		super();
		this.catid = catid;
		this.mname = mname;
		this.image = image;
		this.price = price;
		this.desc = desc;
		this.quality = quality;
	}

	public Menu() {
		super();
	}

	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
}
