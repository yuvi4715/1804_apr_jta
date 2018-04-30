/*
 *	Author: Michael Sikorski
 *	Date: 4/29/2018
 *
 *	Project One - Reimbursement Request System
 */

package com.revature.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.*;
import com.revature.util.ConnectionWithProperties;
import com.revature.util.LogUtil;

// The implementation for EmployeeDAO interface
public class EmployeeDAOImplement implements EmployeeDAO {

	private static EmployeeDAOImplement instance;

	private EmployeeDAOImplement() {
	}

	public static EmployeeDAOImplement getInstance() {
		if (instance == null) {
			instance = new EmployeeDAOImplement();
		}
		return instance;
	}

	@Override
	public boolean createNewEmployee(String email, String username, String password, String first, String last) {
		boolean created = false;
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{call insert_employee(?,?,?,?,?)}");
			stmt.setString(1, email);
			stmt.setString(2, username);
			stmt.setString(3, password);
			stmt.setString(4, first);
			stmt.setString(5, last);
			if (stmt.executeUpdate() > 0) {
				created = true;
				LogUtil.logger
						.info("A new Employee has been registered with the following email address: " + email);
			} else {
				LogUtil.logger.error("There was an issue registering a new Employee with the following email address: " + email);
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return created;
	}

	@Override
	public Employee getEmployee(String email) {
		Employee employee = null;
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE e_email=?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				employee = new Employee(email, rs.getString("e_username"), rs.getString("e_first_name"), rs.getString("e_last_name"));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return employee;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> all = new ArrayList<>();
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEE");
			ResultSet rs = stmt.executeQuery();
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					all.add(new Employee(rs.getString("e_email"), rs.getString("e_username"), rs.getString("e_first_name"), rs.getString("e_last_name")));
				}
			} else {
				all.add(new Employee("","","There are no employees in the system",""));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return all;
	}

	@Override
	public boolean updateEmployee(String email, String newUsername, String newFirst, String newLast) {
		boolean updated = false;
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{call update_employee(?,?,?,?)}");
			stmt.setString(1, email);
			stmt.setString(2, newUsername);
			stmt.setString(3, newFirst);
			stmt.setString(4, newLast);
			if (stmt.executeUpdate() > 0) {
				updated = true;
				LogUtil.logger
						.info("The Employee with email address " + email + " has successfully updated their info");
			} else {
				LogUtil.logger.error("There was an issue updating the information of the Employee with email address of : " + email);
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return updated;
	}

}
