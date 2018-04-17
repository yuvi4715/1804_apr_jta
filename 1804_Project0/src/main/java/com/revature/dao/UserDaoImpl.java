package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl  implements UserDao {

	@Override
	public boolean activate(String username) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			// Create a Statement Object
			PreparedStatement stmt = conn.prepareStatement("UPDATE bank_user SET is_activated = ? WHERE "
					+ "username = ?");
			stmt.setInt(1, 1);
			stmt.setString(2, username);
			
			stmt.execute();
			
			stmt = conn.prepareStatement("SELECT is_activated FROM bank_user WHERE username = ?");
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			return(rs.getInt("is_activated") > 0);
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return false;
	}

	@Override
	public boolean deactivate(String username) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			// Create a Statement Object
			PreparedStatement stmt = conn.prepareStatement("UPDATE bank_user SET is_activated = 0, "
					+ "is_admin = 0 WHERE username = ?");
			
			stmt.setString(1, username);
			
			stmt.execute();
			
			stmt = conn.prepareStatement("SELECT is_activated FROM bank_user WHERE username = ?");
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			return(rs.getInt("is_activated") == 0);
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return false;
	}

	@Override
	public boolean promoteAdmin(String username) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			// Create a Statement Object
			PreparedStatement stmt = conn.prepareStatement("UPDATE bank_user SET is_activated = 1, is_admin = 1 WHERE "
					+ "username = ?");
			
			stmt.setString(1, username);
			
			stmt.execute();
			
			stmt = conn.prepareStatement("SELECT * FROM bank_user WHERE username = ?");
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			return(rs.getInt("is_activated") > 0 && rs.getInt("is_admin") > 0);
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return false;
	}

	@Override
	public boolean revokeAdmin(String username) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			// Create a Statement Object
			PreparedStatement stmt = conn.prepareStatement("UPDATE bank_user SET is_admin = 0 WHERE "
					+ "username = ?");
			
			stmt.setString(1, username);
			
			stmt.execute();
			
			stmt = conn.prepareStatement("SELECT * FROM bank_user WHERE username = ?");
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			return(rs.getInt("is_admin") == 0);
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return false;
	}

	@Override
	public User deposit(User user, double amount) {
		double balance = user.getBalance();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			// Create a Statement Object
			PreparedStatement stmt = conn.prepareStatement("UPDATE bank_user SET balance = ? WHERE "
					+ "username = ?");
			
			stmt.setDouble(1, (balance + amount));
			stmt.setString(2, user.getUsername());
			
			stmt.execute();
			
			user.setBalance(amount + balance);
			
			return user;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		
		return null;
	}

	@Override
	public User withdraw(User user, double amount) {
		double balance = user.getBalance();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			// Create a Statement Object
			PreparedStatement stmt = conn.prepareStatement("UPDATE bank_user SET balance = ? WHERE "
					+ "username = ?");
			
			stmt.setDouble(1, (balance - amount));
			stmt.setString(2, user.getUsername());
			
			stmt.execute();
			
			user.setBalance(balance - amount);
			
			return user;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
				
		return null;
	}

}
