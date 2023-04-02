package com.restaurant.dbutils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.users.Customer;
import com.restaurant.security.PasswordHash;

public class Customerdb extends DBhelper {
	private PasswordHash hash = new PasswordHash();

	public Customerdb() {
		// call the super DBhelper constructor with the table name
		super("customer");
	}

	public List<Customer> getAll() {
		// a list to save all customer data from the table
		List<Customer> customers = new ArrayList<>();
		// SQL statement
		sql = "SELECT fname, lname, phone, email FROM " + table;
		try {
			stm = con.createStatement();
			// executing statement
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				// adding the result to customers list
				customers.add(new Customer(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
						));
			}
			// return the customers array list
			return customers;
		} catch (SQLException e) {
			System.err.println("[ERROR] Failed to get Customers data!");
			e.printStackTrace();
			return null;
		}
	}

	public boolean createcustomer(Customer customer) {
		// SQL statement
		sql = "INSERT INTO " + table + " (fname, lname, phone, email, hashpwd)"
				+ "VALUE (?,?,?,?,?)";
		try {
			// passing the SQL statement to prepared statement
			pstm = con.prepareStatement(sql);
			// sent data to prepare statement
			pstm.setString(1, customer.getFname());
			pstm.setString(2, customer.getLname());
			pstm.setString(3, customer.getPhone());
			pstm.setString(4, customer.getEmail());
			pstm.setString(5, hash.generateStorngPasswordHash(customer.getHashpwd()));
			// executing prepared statement
			pstm.execute();
			System.out.println("[OK] " + customer.getFname() + "'s account created!");
			return true;
		} catch (SQLException e) {
			System.err.println("[ERROR] Failed to create an account!");
			System.out.println("Try different email address or phone number.");
			return false;
		}
	}
	
	public Customer getCustomer(String email) {
		// SQL statement
		sql = "SELECT * FROM " + table + " WHERE email=?";

		try {
			// create prepare statement
			pstm = con.prepareStatement(sql);
			pstm.setString(1, email);;
			// get result from database
			rs = pstm.executeQuery();
			// create User object from the data
			if (rs.next()) {
				return new Customer(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
						);
			}
			return null;
		} catch (SQLException e) {
			System.err.println("[ERROR] Failed to get customer data!");
			return null;
		}
	}
	
	public boolean close() {
		try {
			if (con != null) {
				con.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (rs != null) {
				rs.close();
			}
			return true;
		} catch (SQLException e) {
			System.err.println("[Error] con is already closed!");
			return false;
		}

	}
}
