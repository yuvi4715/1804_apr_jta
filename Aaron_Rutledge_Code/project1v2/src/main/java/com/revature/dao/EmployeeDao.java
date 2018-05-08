package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import java.sql.Timestamp;
import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDao implements TemplateDao<Employee, Integer> {

	final static private Logger log = Logger.getLogger(EmployeeDao.class);
	
	
	public boolean insert(Employee t) {
		int index = 0;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			CallableStatement stmt = conn.prepareCall("{CALL insert_employee(?, ?, ?, ?)}");
			stmt.setString(++index,  t.getfName());
			stmt.setString(++index,  t.getlName());
			stmt.setString(++index,  t.getPassphrase());
			stmt.setString(++index,  t.getEmail());
			
			return stmt.executeUpdate() > 0;
		} catch(SQLException sqle) {
			
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		
			
		return false;
	}

	public Employee get(Integer key) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee WHERE USERID = ?");
			stmt.setInt(1, key);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				return new Employee(rs.getInt("userid"), rs.getString("email"), rs.getString("first_name"), rs.getString("last_name"), rs.getTimestamp("hire_date"), rs.getString("pass_phrase"));
			}
			
			
		} catch (SQLException sqle) {
			
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		
		return null;
	}


	public List<Employee> getAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Employee> eList = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = stmt.executeQuery();
				
			while (rs.next()) {
				eList.add( new Employee(rs.getInt("userid"), rs.getString("email"), rs.getString("first_name"), 
										rs.getString("last_name"), rs.getTimestamp("hire_date"), rs.getString("pass_phrase")));
			}
			return eList;
			} catch (SQLException sqle) {
				log.error(sqle.getMessage());
				log.error("SQL State: " + sqle.getSQLState());
				log.error("Error Code: " + sqle.getErrorCode());
			}
			
		return null;
	}
	

	public boolean update(Employee t) {
		
		int index = 0;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL update_employee(?, ?, ?, ?)}");
			
			stmt.setString(++index,  t.getfName());
			stmt.setString(++index,  t.getlName());
			stmt.setString(++index,  t.getPassphrase());
			stmt.setInt(++index,  t.getUserid());
			
			return stmt.executeUpdate() > 0;
			
			
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		
		
		
		return false;
	}
	
	public boolean updateEmail(Employee t) {
		
		int index = 0;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL update_employee_email(?, ?)}");
			
			stmt.setString(++index,  t.getEmail());
			stmt.setInt(++index,  t.getUserid());
			
			return stmt.executeUpdate() > 0;
			
			
		} catch (SQLException sqle) {
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		
		
		
		return false;
	}
	

	public boolean delete(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}

	public Employee login(String email, String pass) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee WHERE email = ?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				//System.out.println("in rs.next if");
				//System.out.println(rs.getString("pass_phrase"));
				//System.out.println(pass);
				String str = new String(rs.getString("pass_phrase"));
				
				if (str.equals(pass)) {
					Employee emp = new Employee(rs.getInt("userid"), rs.getString("email"), rs.getString("first_name"), rs.getString("last_name"), rs.getTimestamp("hire_date"), str);
					//System.out.println(emp.getStatus());
					return emp;
				} else {
				
					log.error("Someone specified the inccorect password with: " + email + " " + pass);
					Employee emp = new Employee(0, email, pass);
					emp.setfName("Incorrect password. Please try again.");
					return emp;
					
				}
			} else {
				log.error("Someone specified faulty username: " + email + " " + pass);
				Employee emp = new Employee(0, email, pass);
				emp.setfName("Email address not found. Please try again.");
				return emp;
			}
		} catch(SQLException sqle) {
			
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
			return new Employee();
		}
	}
	

	public boolean updateStatus(Integer key, int newStatus) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> getBy(String colName, Integer num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getBy(String colName, String str) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	



}
