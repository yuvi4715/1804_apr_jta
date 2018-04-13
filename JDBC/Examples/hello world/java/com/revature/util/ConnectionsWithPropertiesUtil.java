package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionsWithPropertiesUtil {

	private ConnectionsWithPropertiesUtil() {}
	
	public static Connection getConnection() {
		InputStream in = null;
		try {
			Properties props = new Properties();
			in = new FileInputStream("src/main/resources/db.properties");
			props.load(in);
			return DriverManager.getConnection(props.getProperty("jdbc.url"),
					props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		} finally {
			try {
				in.close();
			} catch (IOException ioe) {
				System.err.println("When closing InputStream: " + ioe.getMessage());
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		System.out.println(ConnectionsWithPropertiesUtil.getConnection());
	}
	
	public static void selectAllCustomers() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1. Create a connection
			conn = ConnectionsWithPropertiesUtil.getConnection();
			
			// 2. Create a Statement
			stmt = conn.createStatement();
			
			// 3. Execute the Statement
			rs = stmt.executeQuery("SELECT firstname, lastname, customerid FROM customer");
			
			//4. Iterate through the ResultSet
			while (rs.next()) {
				// Selecting the data by column index number
//				System.out.println(rs.getInt(3) + ": " + rs.getString(2) + ", "
//							     + rs.getString(1));
				
				// Selecting the data by column index name
				System.out.println(rs.getInt("customerid") + ": "+
					rs.getString("lastname") + ", " + rs.getString("firstname"));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				System.err.println("SQL State: " + e.getSQLState());
				System.err.println("Error Code: " + e.getErrorCode());
			}
		}
	}
	
	public static void updateCustomer() {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// 1. Create a Connection
			conn = ConnectionsWithPropertiesUtil.getConnection();
			
			// 2. Create a PreparedStatement
			stmt = conn.prepareStatement("UPDATE customer SET firstname = ?, lastname = ?"
					+ "WHERE firstname = 'Emma' AND lastname = 'Jones'");
			
			// 3. Set the values 
			stmt.setString(1, "Julie");
			stmt.setString(2, "Smith");
			
			// 4. Execute the query and assign the rows modified
			int rowsModified = stmt.executeUpdate();
			
			// 5. Test if the update was successful
			if (rowsModified > 0) {
				System.out.println("Update was successful");
			} else {
				System.out.println("Update was NOT successful");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				System.err.println("SQL State: " + e.getSQLState());
				System.err.println("Error Code: " + e.getErrorCode());
			}
		}
		
	}
}
