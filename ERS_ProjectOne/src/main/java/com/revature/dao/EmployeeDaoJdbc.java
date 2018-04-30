package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoJdbc implements EmployeeDao {

	//create employee in sql
	@Override
	public boolean insertEmployee(Employee inputEmployee) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL insert_employee(?,?,?,?,?)}");
			stmt.setString(++index, inputEmployee.getEmail());
			stmt.setString(++index, inputEmployee.getPassword());
			stmt.setString(++index, inputEmployee.getFirstName());
			stmt.setString(++index, inputEmployee.getLastName());
			stmt.setString(++index, inputEmployee.getUserName());
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	//find employee from sql
	@Override
	public Employee getEmployee(String username, String password) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee WHERE user_name = ? AND password = ?");
			stmt.setString(++index, username);
			stmt.setString(++index, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Employee(rs.getString("email"),
						rs.getString("password"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("user_name"));
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	//see all employee in sql
	@Override
	public List<Employee> getAllEmployee() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Employee> employees = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				employees.add(new Employee(rs.getString("email"),
						rs.getString("password"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("user_name")));
			}
			return employees;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	//edit employee information in sql
	@Override
	public boolean updateEmployee(Employee inputEmployee) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL e_all( ?, ?, ?, ?, ?)}");
			stmt.setString(++index, inputEmployee.getUserName());
			stmt.setString(++index, inputEmployee.getEmail());
			stmt.setString(++index, inputEmployee.getFirstName());
			stmt.setString(++index, inputEmployee.getLastName());
			stmt.setString(++index, inputEmployee.getPassword());
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}
}
