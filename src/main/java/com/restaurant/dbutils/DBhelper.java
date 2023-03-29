package com.restaurant.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBhelper {
	private String reg = "com.mysql.jdbc.Driver";
	private String host = "jdbc:mysql://localhost:3306/smart";
	private String user = "restaurant";
	private String password = "smart";
	protected Connection con;
	protected Statement stm;
	protected PreparedStatement pstm;
	protected ResultSet rs;
	protected String sql;
	protected String table;
	
	protected DBhelper() {
		try {
			// register MYSQL JDBC driver
			Class.forName(reg);
			// create a connection
			con = DriverManager.getConnection(host, user, password);
			System.out.println("[OK] database connected!");
		} catch (SQLException e) {
			System.err.println("[ERROR] Failed to connect with database!");
		} catch (Exception e) {
			System.err.println("[ERROR] Failed to register mysql driver!");
		}
	}
}
