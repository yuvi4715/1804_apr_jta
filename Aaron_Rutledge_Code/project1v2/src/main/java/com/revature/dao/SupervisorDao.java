package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class SupervisorDao extends EmployeeDao {
	
	final static private Logger log = Logger.getLogger(EmployeeDao.class);
	
	@Override
	public Employee login(String email, String pass) {
		
		Employee sv = super.login(email, pass);
		if (sv.getStatus() != (1)) {
			return sv;
		}
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM supervisor WHERE managerid = ?");
			stmt.setInt(1, sv.getUserid());
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				sv.setStatus(3);
				return sv;
			} else {
				Employee emp = new Employee(0, email, pass);
				emp.setfName(sv.getfName() + " is not a manager.");
				return emp;
			}
			
			
			
		} catch (SQLException sqle) {
			
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
			return new Employee();
			
		}
	}
	
	
	
}