package com.restaurant.utils;

public class Print {
	public static <T> void s(T msg) {
		System.out.println(msg);
	}
	
	public <T> void p(T msg) {
		System.out.println(msg);
	}
	
	public static <T> void se(T msg) {
		System.err.println(msg);
	}
	
	public <T> void e(T msg) {
		System.err.println(msg);
	}
}
