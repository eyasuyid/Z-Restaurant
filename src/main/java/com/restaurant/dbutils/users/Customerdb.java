package com.restaurant.dbutils.users;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.utils.Print;
import com.restaurant.users.Customer;
import com.restaurant.dbutils.DBhelper;
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
			Print.se("[ERROR] Failed to get Customers data!");
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
			return true;
		} catch (SQLException e) {
			Print.se("[ERROR] Failed to create an account!");
			Print.s("Try different email address or phone number.");
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
			// create customer object from the data
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
			Print.se("[ERROR] Failed to get customer data!");
			Print.s("Customer doesn't exists!");
			return null;
		}
	}
	
	public boolean updateCustomer(Customer customer) {
		// checking the use exists
		if (checkCustomer(customer.getEmail()) == false) {
			Print.s("Customer doesn't exists!");
			return false;
		}
		// SQL statement
		sql = "UPDATE " + table + " SET fname=?, lname=?, "
		+"phone=?, email=?, hashpwd=? WHERE email=?";
		try {
			// create prepare statement
			pstm = con.prepareStatement(sql);
			// sent data to prepare statement
			pstm.setString(1, customer.getFname());
			pstm.setString(2, customer.getLname());
			pstm.setString(3, customer.getPhone());
			pstm.setString(4, customer.getEmail());
			pstm.setString(5, hash.generateStorngPasswordHash(customer.getHashpwd()));
			pstm.setString(6, customer.getEmail());
			// execute prepare statement
			pstm.execute();
			return true;
		} catch (SQLException e) {
			Print.se("[ERROR] Failed to update a customer!");
			return false;
		}
	}

	public boolean deleteCustomer(String email) {
		// checking the use exists
		if (checkCustomer(email) == false) {
			Print.s("Customer doesn't exists!");
			return false;
		}
		sql = "DELETE FROM " + table + " WHERE email=?";
		try {
			// create prepare statement
			pstm = con.prepareStatement(sql);
			// passing the email to prepared statement
        	pstm.setString(1, email);;
			// execute prepare statement
			pstm.execute();;
			return true;
		} catch (SQLException e) {
			Print.se("[ERROR] Failed to delete customer!");
			return false;
		}
	}
	
	public boolean checkCustomer(String email) {
		if (getCustomer(email) != null) {
			return true;
		}
		return false;
	}
	
	public Customer validCustomer(String email, String password) {
		Customer cus = getCustomer(email);
		if (cus != null) {
			if (hash.validatePassword(password, cus.getHashpwd())) {
				return cus;
			}
		}
		return null;
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
			Print.se("[Error] connection is already closed!");
			return false;
		}

	}
}
