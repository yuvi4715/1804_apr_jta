package com.revature.dao;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private static EmployeeDaoImpl instance = null;
	private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);
	
	private EmployeeDaoImpl() {}
	
	public static EmployeeDaoImpl getInstance() {
		if (instance == null) {
			instance = new EmployeeDaoImpl();
		}
		return instance;
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		int index = 0; 
		 
		try (Connection conn = ConnectionUtil.getConnection()) { 
				CallableStatement stmt = conn.prepareCall("{CALL insert_employee (?, ?, ?, ?, ?, ?, ?)}"); 
				stmt.setString(++index, employee.getEmail()); 
				stmt.setString(++index, employee.getUserName()); 
				stmt.setString(++index, employee.getPassword());
				stmt.setString(++index, employee.getFirstName());
				stmt.setString(++index, employee.getLastName());
				int manager;
				int employed;
				if (employee.getManagerStatus()) manager = 1;
				else manager = 0;
				stmt.setInt(++index, manager);
				if (employee.getEmploymentStatus()) employed = 1;
				else employed = 0;
				stmt.setInt(++index, employed);
				
				return stmt.executeUpdate() > 0; 
				
		
		} catch (SQLException sqle) { 
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when inserting an employee into your sql database"); 
		} 
		return false;
	}

	@Override
	public Employee getEmployee(String username) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee WHERE username = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Employee(rs.getInt("employee_id"),rs.getString("email"),rs.getString("username"),
						rs.getString("password"),rs.getString("first_name"), rs.getString("last_name"), 1 == rs.getInt("manager_status")
								,1 == rs.getInt("employment_status"));
			}
		}catch(SQLException sqle) {
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when inserting an employee into your sql database");
		}
		return null;
	}

	@Override
	public String getEmployeePassword(String username) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()){
			String password;
			PreparedStatement stmt = conn.prepareStatement("SELECT password FROM employee WHERE username=?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			password = rs.getString("password");
			
			return password;
		}catch(SQLException sqle) {
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when getting user password");
		}
		return null;
	}

	@Override
	public List<String> getAllUsernames() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			List<String> usernames = new ArrayList<String>();
			PreparedStatement stmt = conn.prepareStatement("SELECT username FROM employee");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				usernames.add(rs.getString("username"));
			}
			return usernames;
		} catch (SQLException sqle) { 
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when getting usernames");
		} 
		return null;
	}

	@Override
	public boolean updatePassword(String username, String password) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			int index = 0;
			CallableStatement stmt = conn.prepareCall("{CALL update_employee_password(?,?)}");
			stmt.setString(++index, username);
			stmt.setString(++index, password);
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) { 
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when changing employee password");
		} 		
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			List<Employee> employees = new ArrayList<Employee>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				employees.add(new Employee(rs.getInt("employee_id"),rs.getString("email"),rs.getString("username")
						,rs.getString("password"),rs.getString("first_name"),rs.getString("last_name"),
						rs.getInt("manager_status") == 1,rs.getInt("employment_status") == 1));
			}
			return employees;
		} catch (SQLException sqle) { 
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when getting all employees"); 
		} 
		return null;
	}

	@Override
	public boolean updateEmploymentStatus(String username, boolean status) {
		int index = 0; 
		 
		try (Connection conn = ConnectionUtil.getConnection()) { 
				CallableStatement stmt = conn.prepareCall("{CALL update_employment_status(?, ?)}"); 
				stmt.setString(++index, username); 
				int employmentStatus;
				if (status)	employmentStatus = 1;
				else employmentStatus = 10;
				stmt.setInt(++index, employmentStatus); 
				
				return stmt.executeUpdate() > 0; 
				
		
		} catch (SQLException sqle) { 
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when updating employment status"); 
		} 
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		int index = 0; 
		 
		try (Connection conn = ConnectionUtil.getConnection()) { 
				CallableStatement stmt = conn.prepareCall("{CALL update_employee(?, ?, ?, ?, ?, ?, ?, ?)}"); 
				stmt.setInt(++index, employee.getEmployeeId()); 
				stmt.setString(++index, employee.getEmail()); 
				stmt.setString(++index, employee.getUserName());
				stmt.setString(++index, employee.getPassword());
				stmt.setString(++index, employee.getFirstName());
				stmt.setString(++index, employee.getLastName());
				int employment;
				int manager;
				if (employee.getManagerStatus()) manager = 1;
				else manager = 0;
				if (employee.getEmploymentStatus()) employment = 1;
				else employment = 0;
				stmt.setInt(++index, manager);
				stmt.setInt(++index, employment);
				
				
				
				return stmt.executeUpdate() > 0; 
				
		
		} catch (SQLException sqle) { 
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when fulling updating an employee"); 
		} 
		return false;
	}

	@Override
	public boolean updateImage(int requestId, Blob image) {
		int index = 0; 
		 
		try (Connection conn = ConnectionUtil.getConnection()) { 
				CallableStatement stmt = conn.prepareCall("{CALL update_image(?, ?)}"); 
				stmt.setInt(++index, requestId);
				stmt.setBlob(++index, image); 
				
				
				return stmt.executeUpdate() > 0; 
				
		
		} catch (SQLException sqle) { 
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured while storing image"); 
		} 
		return false;
	}

	
}
