package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	private static EmployeeDaoImpl instance;
	
	private EmployeeDaoImpl() {
		
	}
	
	public static EmployeeDaoImpl getInstance() {
		
		if (instance == null) {
			instance = new EmployeeDaoImpl();
		}
		
		return instance;
	}
	
	@Override
	public Employee login(String email, String pass) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			// Create a Statement Object
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee WHERE email = ?");
			stmt.setString(1, email);
			
			ResultSet rs = stmt.executeQuery();
			
			Employee emp;
			
			if(rs.next()) {
				
				String actualPass = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				
				if (pass.equals(actualPass)) {
					
					emp = new Employee(email, firstname, lastname, "Success");
				} else {
					emp = new Employee("Incorrect Password");
				}
				
			}else {
				
				emp = new Employee("Not a valid account email");
			}
			
			return emp;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return new Employee("Login Failed");
	}

	public Employee managerLogin(String email, String pass) {
		
try (Connection conn = ConnectionUtil.getConnection()) {
			
			// Create a Statement Object
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM manager WHERE email = ?");
			stmt.setString(1, email);
			
			ResultSet rs = stmt.executeQuery();
			
			Employee emp;
			
			if(rs.next()) {
				
				String actualPass = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				
				if (pass.equals(actualPass)) {
					
					emp = new Employee(email, firstname, lastname, "Success");
				} else {
					emp = new Employee("Incorrect Password");
				}
				
			}else {
				
				emp = new Employee("Not a valid account email");
			}
			
			return emp;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return new Employee("Login Failed");
	}
}
