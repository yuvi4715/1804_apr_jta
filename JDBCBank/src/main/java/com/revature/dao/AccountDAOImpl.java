package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.model.Account;
import com.revature.util.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO 
{

	@Override
	public boolean insertAccount(Account account) 
	{
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) 
		{
			CallableStatement stmt = conn.prepareCall("{CALL insert_account(?, ?, ?)}");
			stmt.setInt(++index, account.getUserID());
			stmt.setString(++index, account.getAccountName());
			stmt.setInt(++index, account.getBalance());
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
	public Account getAccount(int userID, String accountName)
	{
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM account WHERE user_id = ? AND account_name = ?");
			stmt.setInt(++index, userID);
			stmt.setString(++index, accountName);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) 
			{
				return new Account(rs.getInt("user_id"), rs.getInt("account_id"), rs.getString("account_name"),
						rs.getInt("balance"));
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
	public List<Account> getAllAccounts() 
	{
		try (Connection conn = ConnectionUtil.getConnection())
		{
			List<Account> account = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM account");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				account.add(new Account(rs.getInt("user_id"), rs.getInt("account_id"), 
						rs.getString("account_name"), rs.getInt("balance")));
			}
			return account;
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
	public boolean updateAccount(int userID,int accountID, int newbalance) 
	{
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) 
		{
			CallableStatement stmt = conn.prepareCall("{CALL update_account(?, ?, ?)}");
			stmt.setInt(++index, userID);
			stmt.setInt(++index, accountID);
			stmt.setInt(++index, newbalance);
			stmt.executeUpdate();
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
	public boolean deleteAccount(int accountID) 
	{
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) 
		{
			CallableStatement stmt = conn.prepareCall("{CALL delete_account(?)}");
			stmt.setInt(++index, accountID);
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
