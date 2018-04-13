package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Customer;
import com.revature.util.ConnectionsWithPropertiesUtil;

public class CustomerDaoImpl implements CustomerDao {

	private static CustomerDaoImpl instance;
	
	private CustomerDaoImpl() {}
	
	public static CustomerDaoImpl getInstance() {
		if (instance == null) {
			instance = new CustomerDaoImpl();
		}
		return instance;
	}
	

	@Override
	public boolean insertCustomer(Customer customer) {
		int index = 0;
		try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO customer "
					+ "(customerid, firstname, lastname, email) VALUES (?, ?, ?, ?)");
			stmt.setInt(++index, 63);
			stmt.setString(++index, customer.getFirstName());
			stmt.setString(++index, customer.getLastName());
			stmt.setString(++index, customer.getEmail());
			if (!stmt.execute())
				// executeUpdate returns the number of rows modified from the DML statement
				return stmt.getUpdateCount() > 0;
			
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public Customer getCustomer(String email) {
		int index = 0;
		try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT firstname, "
					+ "lastname, email FROM customer WHERE email = ?");
			stmt.setString(++index, email);
			ResultSet rs = stmt.executeQuery();
			// Can use if-statement instead of while-loop if you only expect one record
			if (rs.next()) {
				return new Customer(rs.getString("firstname"), rs.getString("lastname"), 
						rs.getString("email"));
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// Try-with-Resources will automatically close your resources,
		// In the reverse order in which you declared them
		// ***Available since Java 7
		try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
			// 1. Create a List<Customer>
			List<Customer> customers = new ArrayList<>();
			
			// 2. Create a Statement Object
			PreparedStatement stmt = conn.prepareStatement("SELECT firstname, lastname, email FROM customer");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				customers.add(new Customer(rs.getString("firstname"), rs.getString(2), rs.getString("email")));
			}
			// Return the populated list
			return customers;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		} 
		return null;
	}

	@Override
	public boolean updateCustomer(String originalEmail, Customer customer) {
		int index = 0;
		try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("UPDATE customer SET firstname = ?, lastname = ?, email = ? WHERE email = ?");
			stmt.setString(++index, customer.getFirstName());
			stmt.setString(++index, customer.getLastName());
			stmt.setString(++index, customer.getEmail());
			stmt.setString(++index, originalEmail);
			if (!stmt.execute()) {
				return stmt.getUpdateCount() > 0;
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(String email) {
		int index = 0;
		try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM customer WHERE email = ?");
			stmt.setString(++index, email);
			if (!stmt.execute()) {
				return stmt.getUpdateCount() > 0;
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}
}
