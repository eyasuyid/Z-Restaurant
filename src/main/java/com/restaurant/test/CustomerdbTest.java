package com.restaurant.test;

import java.util.Iterator;


import com.restaurant.utils.Print;
import com.restaurant.dbutils.users.Customerdb;
import com.restaurant.users.Customer;

public class CustomerdbTest {

	public static void main(String[] args) {
		Customerdb cus = new Customerdb();

		// testing get all customers
		Print.s("\nGetting all customers data");
		Iterator<Customer> it = cus.getAll().listIterator();
		while (it.hasNext()) {
			Print.s(((Customer) it.next()).getEmail());
		}

		// testing create customer
		Print.s("\nCreating new customer");
		Print.s(cus.createcustomer(new Customer("Josh", "Yid", "0960yyyyxxx", "jogmail.com", "hacker")));

		// testing get customer with email
		Print.s("\nGetting customer with email");
		Print.s(cus.getCustomer("joshiii@gmail.com"));
		
		// testing update customer with email
		Print.s("\nUpdating customer with email");
		Print.s(cus.updateCustomer(new Customer("Joshua", "Yid", "0000000", "joshiii@gmail.com", "thehacker")));
		
		// testing delete customer with email
		Print.s("\nDeleting customer with email");
		Print.s(cus.deleteCustomer("joshiii@gmail.com"));
		
		// closing the database connections
		Print.s("\nconnection closed!");
		cus.close();
	}

}
