package com.restaurant.dbutils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.users.Customer;


public class Customerdb extends DBhelper {
	public Customerdb() {
		super();
	}

	public List<Customer> getAll() {
		// create array to store Customers data from db
		List<Customer> Customers = new ArrayList<>();
		sql = "SELECT * FROM " + table;
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				Customers.add(new Customer(
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
						));
			}
		} catch (SQLException e) {
			System.err.println("[ERROR] Failed to get all Customers data!");
		} finally {
			try {
				con.close();
				stm.close();
				rs.close();
			} catch(Exception e) {
				System.out.println("[ERROR] Failed to close cons!");
			}
		}
		return Customers;
	}
	
	
	
}
