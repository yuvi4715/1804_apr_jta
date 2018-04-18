package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class BankDaoImp implements BankDao {
	@Override
	public boolean insertUser(User user) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL insert_user" + "(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			stmt.setString(++index, user.getUsername());
			stmt.setString(++index, user.getPassword());
			stmt.setString(++index, user.getFirstname());
			stmt.setString(++index, user.getLastname());
			stmt.setInt(++index, user.getApproved());
			stmt.setInt(++index, user.getAdminPrivilege());
			stmt.setInt(++index, user.getAccountNumber());
			stmt.setDouble(++index, user.getAccountBalance());
			stmt.setString(++index, user.getAccountType());
			return stmt.executeUpdate() > 0;

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;

	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL delete_user" + "(?)}");
			stmt.setString(++index, user.getUsername());
			return stmt.executeUpdate() > 0;

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	public boolean deposit(User user, double amount) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL deposit" + "(?, ?)}");
			stmt.setString(++index, user.getUsername());
			stmt.setDouble(++index, amount);
			return stmt.executeUpdate() > 0;

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;

	}

	public boolean withdraw(User user, double amount) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL withdraw" + "(?, ?)}");
			stmt.setString(++index, user.getUsername());
			stmt.setDouble(++index, amount);
			return stmt.executeUpdate() > 0;

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;

	}

	// add procedure to SQL
	// find username in table then change approved = 0 to approved = 1;
	@Override
	public boolean approveUser(String username) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL approve_user(?)}");
			stmt.setString(++index, username);
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean usernameTaken(String username) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user_info WHERE username = ?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean findUser(String username, String password) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM user_info WHERE username = ?" + " AND password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;

	}

	@Override
	public User userInfo(User user, String username) {

		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {

			// get user info
			PreparedStatement stmt = conn.prepareStatement(
					"SELECT password, firstname, lastname, approved, admin " + "FROM user_info WHERE username = ?");
			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();
			// Can use if-STatement instead of while-loop if you can only expect one record
			String pass = null, fn = null, ln = null, at = null;
			int an = 0, appr = 0, adm = 0;
			double ab = 0;
			if (rs.next()) {
				pass = rs.getString("password");
				fn = rs.getString("firstname");
				ln = rs.getString("lastname");
				appr = rs.getInt("approved");
				adm = rs.getInt("admin");
			}
			// get bank info
			stmt = conn.prepareStatement(
					"SELECT accountnumber, accountbalance, accounttype " + "FROM bank WHERE username = ?");
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			// Can use if-STatement instead of while-loop if you can only expect one record
			if (rs.next()) {
				an = rs.getInt("accountnumber");
				ab = rs.getDouble("accountbalance");
				at = rs.getString("accounttype");

			}
			user = new User(username, pass, fn, ln, adm, appr, an, ab, at);
			return user;

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return user;
	}

	@Override
	public User userBalance(User user) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT accountbalance " + "FROM bank WHERE username = ?");
			stmt.setString(1, user.getUsername());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				user.setAccountBalance(rs.getDouble("accountbalance"));
			}
			return user;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return user;
	}

}
