package com.ranieri.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ranieri.model.Employee;
import com.ranieri.util.ConnectionWProp;
import com.ranieri.model.*;


public class EmployeeDaoImpl implements EmployeeDao{
	
	
private static EmployeeDaoImpl instance;
	
	private EmployeeDaoImpl() {}
	
	public static EmployeeDaoImpl getInstance() {
		if(instance == null) {
			instance = new EmployeeDaoImpl();
		}
		return instance;
	}
	
	public Employee getEmployee(String email, String password) {
		try(Connection conn = ConnectionWProp.getConnection()){
			System.out.println("Successfully connected");
			
			PreparedStatement stmt = conn.prepareCall("SELECT email, password, authorization FROM employee WHERE email = ? and password = ?");
			stmt.setString(1, email );
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Employee(rs.getString("email"), rs.getString("password"),rs.getInt("authorization"));
			}

								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("from inside the dao impl");
			e.printStackTrace();
		}
		return null;
	}

}
