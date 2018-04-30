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

public class EmployeeDAOImpl implements EmployeeDAO
{

	@Override
	public boolean insertEmployee(Employee em) 
	{
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) 
		{
			CallableStatement stmt = conn.prepareCall("{CALL insert_employee_user(?, ?, ?, ?)}");
			stmt.setString(++index, em.getEmail());
			stmt.setString(++index, em.getPassword());
			stmt.setString(++index, em.getFirstName());
			stmt.setString(++index, em.getLastName());
			return stmt.executeUpdate() > 0;
		}
		catch (SQLException sqle)
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public Employee getEmployee(String username) 
	{

		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employee_user WHERE em_email = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) 
			{
				return new Employee(rs.getString("em_email"), rs.getString("em_password"),
						rs.getString("em_first_name"), rs.getString("em_last_name"),rs.getInt("is_manager"));
			}
		} 
		catch (SQLException sqle)
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() 
	{
		try (Connection conn = ConnectionUtil.getConnection())
		{
			List<Employee> users = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employee_user");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				users.add(new Employee(rs.getString("em_email"), rs.getString("em_password"),
						rs.getString("em_first_name"), rs.getString("em_last_name"),rs.getInt("is_manager")));
			}
			return users;
		} 
		catch (SQLException sqle) 
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	

	@Override
	public boolean updateManager(Employee em) 
	{
		int index = 0;
		int approved = em.getIs_manager()==0? 1 : 0;
		try (Connection conn = ConnectionUtil.getConnection()) 
		{
			CallableStatement stmt = conn.prepareCall("{CALL update_information(?, ?)}");
			stmt.setInt(++index, approved );	
			stmt.setString(++index, em.getEmail());
			return stmt.executeUpdate() > 0;
		} 
		catch (SQLException sqle) 
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean updateUserInformation(Employee em) 
	{
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) 
		{
			CallableStatement stmt = conn.prepareCall("{CALL update_information(?, ?, ?, ?)}");
			stmt.setString(++index, em.getEmail());
			stmt.setString(++index, em.getPassword());
			stmt.setString(++index, em.getFirstName());
			stmt.setString(++index, em.getLastName());
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean deleteUser(String username)
	{
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) 
		{
			CallableStatement stmt = conn.prepareCall("{CALL delete_Employee_user(?)}");
			stmt.setString(++index, username);
			return stmt.executeUpdate() > 0;
		} 
		catch (SQLException sqle) 
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

}
