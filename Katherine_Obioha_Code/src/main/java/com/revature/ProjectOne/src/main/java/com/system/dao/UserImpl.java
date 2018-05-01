package com.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.system.util.ConnectionProperties;
import com.system.model.User;

public class UserImpl implements UserInterface {

	private static UserImpl instance;

	private UserImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static UserImpl getInstance() {
		if (instance == null) {
			instance = new UserImpl();
		}
		return instance;
	}

	public User getUser(String username, String role, int id) {
		// TODO Auto-generated method stub
		
		
		try(Connection conn = ConnectionProperties.getConnection())
		{
		 if(id > 0)
		 {
			if(role.equalsIgnoreCase("manager"))
			{
				PreparedStatement stmt = conn.prepareStatement("SELECT firstname, "
						+ "lastname, email, password, managerid, role FROM Manager WHERE managerid = ?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next())
				{
				
				 User person = new User();
				 person.setEmail(rs.getString("email")); person.setFirstname(rs.getString("firstname")); person.setLastname(rs.getString("lastname"));
				 person.setID(rs.getInt("managerid")); person.setRole(rs.getString("role")); person.setUsername(username); person.setPassword(rs.getString("password"));
			
				 return person;
					
				}
				else
				{		
					return null;
				}
			}
			else if(role.equalsIgnoreCase("employee"))
				{PreparedStatement stmt = conn.prepareStatement("SELECT firstname, "
						+ "lastname, email, password, employeeid, role FROM Employee WHERE employeeid = ?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next())
				{
				
				 User person = new User();
				 person.setEmail(rs.getString("email")); person.setFirstname(rs.getString("firstname")); person.setLastname(rs.getString("lastname"));
				 person.setID(rs.getInt("employeeid")); person.setRole(rs.getString("role")); person.setUsername(username); person.setPassword(rs.getString("password"));
			
				 return person;
					
				}
				else
				{		
					return null;
				}
				}
		  }
			else 
				{
					if (role.equalsIgnoreCase("employee"))
					{
						PreparedStatement stmt = conn.prepareStatement("SELECT firstname, "
								+ "lastname, email, password, employeeid, role FROM EMPLOYEE WHERE username = ?");
						stmt.setString(1, username);
						ResultSet rs = stmt.executeQuery();
						
						if(rs.next())
						{
						
						 User person = new User();
						 person.setEmail(rs.getString("email")); person.setFirstname(rs.getString("firstname")); person.setLastname(rs.getString("lastname"));
						 person.setID(rs.getInt("employeeid")); person.setRole(rs.getString("role")); person.setUsername(username); person.setPassword(rs.getString("password"));
					
						 return person;
							
						}
						else
						{		
							return null;
						}
					}
					else if(role.equalsIgnoreCase("manager"))
					{
						PreparedStatement stmt = conn.prepareStatement("SELECT firstname, "
								+ "lastname, email, password, managerid, role FROM Manager WHERE username = ?");
						stmt.setString(1, username);
						ResultSet rs = stmt.executeQuery();
						
						if(rs.next())
						{
						
						 User person = new User();
						 person.setEmail(rs.getString("email")); person.setFirstname(rs.getString("firstname")); person.setLastname(rs.getString("lastname"));
						 person.setID(rs.getInt("managerid")); person.setRole(rs.getString("role")); person.setUsername(username); person.setPassword(rs.getString("password"));
					
						 return person;
							
						}
						else
						{		
							return null;
						}
					}
				}
		
		
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
			e.printStackTrace();
		}
		return null;
	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
