package com.restaurant.test;

import java.util.Iterator;

import com.restaurant.dbutils.Customerdb;
import com.restaurant.users.Customer;

public class CustomerdbTest {
	public static <T> void print(T msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		Customerdb cus = new Customerdb();
		// testing get all customers
		Iterator it = cus.getAll().listIterator();
		while (it.hasNext()) {
			print(((Customer) it.next()).getEmail());
		}

		// testing create customer
		print(cus.createcustomer(new Customer("Josh", "Yid", "096007670", "joshua@gmail.com", "hacker")));
		
		print(cus.getCustomer("josh@gmail.com").getFname());
		cus.close();
	}

}
