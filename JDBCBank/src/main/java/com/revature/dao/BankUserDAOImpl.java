package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.BankUser;
import com.revature.util.ConnectionUtil;

public class BankUserDAOImpl implements BankUserDAO 
{

	@Override
	public boolean insertUser(BankUser user)
	{
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) 
		{
			CallableStatement stmt = conn.prepareCall("{CALL insert_bank_user(?, ?, ?, ?)}");
			stmt.setString(++index, user.getFisrtName());
			stmt.setString(++index, user.getLastName());
			stmt.setString(++index, user.getUsername());
			stmt.setString(++index, user.getPassword());
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
	public BankUser getUser(int userID) 
	{
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank_user WHERE user_id = ?");
			stmt.setInt(++index, userID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) 
			{
				return new BankUser(rs.getInt("user_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("username"), rs.getString("password"));
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
	public List<BankUser> getAllUsers() 
	{
		try (Connection conn = ConnectionUtil.getConnection())
		{
			List<BankUser> users = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank_user");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				users.add(new BankUser(rs.getInt("user_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("username"), rs.getString("password")));
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
	public boolean updateUserStatus(BankUser user) 
	{
		int index = 0;
		int approved = user.isApproved()? 0 : 1;
		try (Connection conn = ConnectionUtil.getConnection()) 
		{
			CallableStatement stmt = conn.prepareCall("{CALL update_user_approved(?, ?)}");
			stmt.setInt(++index, approved );	
			stmt.setInt(++index, user.getUserID());
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
	public boolean updateUserAmin(BankUser user) 
	{
		int index = 0;
		int approved = user.isAdmin()? 0 : 1;
		try (Connection conn = ConnectionUtil.getConnection()) 
		{
			CallableStatement stmt = conn.prepareCall("{CALL update_admin(?, ?)}");
			stmt.setInt(++index, approved );
			stmt.setInt(++index, user.getUserID());
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
	public boolean deleteUser(int userID) 
	{
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) 
		{
			CallableStatement stmt = conn.prepareCall("{CALL delete_bank_user(?)}");
			stmt.setInt(++index, userID);
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
