package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.user.User;
import com.revature.util.ConnectionWithPropertiesUtil;

public class UserDaoImpl implements UserDao {

	public boolean insertUser(User user) {
		int index = 0; 
		 
		try (Connection conn = ConnectionWithPropertiesUtil.getConnection()) { 
				CallableStatement stmt = conn.prepareCall("{CALL insert_bank (?, ?, ?, ?, ?, ?, ?)}"); 
				stmt.setString(++index, user.getEmail()); 
				stmt.setDouble(++index, user.getBalance()); 
				stmt.setString(++index, user.getFirstName());
				stmt.setString(++index, user.getLastName());
				if(user.isAdmin() == true) stmt.setInt(++index, 1);
				else stmt.setInt(++index, 0);
				if(user.getNotCustomer() == true) stmt.setInt(++index, 1);
				else stmt.setInt(++index, 0);
				stmt.setString(++index, user.getPassword());
				
				return stmt.executeUpdate() > 0; 
				
		
		} catch (SQLException sqle) { 
			System.err.println(sqle.getMessage()); 
			System.err.println("SQL State: " + sqle.getSQLState()); 
			System.err.println("Error Code: " + sqle.getErrorCode()); 
		} 
		return false; 
	}

	public User getUser(String email) {
		int index = 0;
		try (Connection conn = ConnectionWithPropertiesUtil.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank WHERE email = ?");
			stmt.setString(++index, email);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("account_number"), rs.getString("email"),rs.getDouble("balance"),
								rs.getString("first_name"), rs.getString("last_name"), rs.getInt("is_admin") == 1,
								rs.getInt("not_customer") == 1, rs.getString("password"));
			}
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	public boolean deleteUser(User user) {
		int index = 0; 
		 
		try (Connection conn = ConnectionWithPropertiesUtil.getConnection()) { 
				CallableStatement stmt = conn.prepareCall("{CALL delete_bank_user (?)}"); 
				stmt.setInt(++index, user.getAccountNumber()); 
				
				return stmt.executeUpdate() > 0; 
		
		} catch (SQLException sqle) { 
			System.err.println(sqle.getMessage()); 
			System.err.println("SQL State: " + sqle.getSQLState()); 
			System.err.println("Error Code: " + sqle.getErrorCode()); 
		}  
		return false;
	}


	public boolean updateUserCheckingAccountBalance(User user, double ammountAdded) {
		int index = 0; 
		 
		try (Connection conn = ConnectionWithPropertiesUtil.getConnection()) { 
				CallableStatement stmt = conn.prepareCall("{CALL update_bank_balance (?, ?)}"); 
				stmt.setInt(++index, user.getAccountNumber()); 
				stmt.setDouble(++index, user.getBalance() + ammountAdded); 
				
				return stmt.executeUpdate() > 0; 
				
		
		} catch (SQLException sqle) { 
			System.err.println(sqle.getMessage()); 
			System.err.println("SQL State: " + sqle.getSQLState()); 
			System.err.println("Error Code: " + sqle.getErrorCode()); 
		} 
		return false; 
	}

	public boolean updateIsAdmin(String email, boolean status) {
		int index = 0; 
		 
		try (Connection conn = ConnectionWithPropertiesUtil.getConnection()) { 
				//changing the boolean value of the status to an int value in sql
				int intStatus;
				if (status) intStatus = 1;
				else intStatus = 0;
				
				CallableStatement stmt = conn.prepareCall("{CALL update_bank_is_admin (?, ?)}"); 
				stmt.setString(++index, email); 
				stmt.setInt(++index, intStatus); 
				
				return stmt.executeUpdate() > 0; 
				
		} catch (SQLException sqle) { 
			System.err.println(sqle.getMessage()); 
			System.err.println("SQL State: " + sqle.getSQLState()); 
			System.err.println("Error Code: " + sqle.getErrorCode()); 
		} 
		return false;
	}

	
	public boolean updateNotCustomer(String email, boolean status) {
		int index = 0; 
		 
		try (Connection conn = ConnectionWithPropertiesUtil.getConnection()) { 
				//changing the boolean value of the status to an int value in sql
				int intStatus;
				if (status) intStatus = 1;
				else intStatus = 0;
				
				CallableStatement stmt = conn.prepareCall("{CALL update_bank_not_customer (?, ?)}"); 
				stmt.setString(++index, email); 
				stmt.setInt(++index, intStatus); 
				
				return stmt.executeUpdate() > 0; 
				
		} catch (SQLException sqle) { 
			System.err.println(sqle.getMessage()); 
			System.err.println("SQL State: " + sqle.getSQLState()); 
			System.err.println("Error Code: " + sqle.getErrorCode()); 
		} 
		return false;
	}

	@Override
	public boolean updateBankUser(User user) {
		int index = 0; 
		 
		try (Connection conn = ConnectionWithPropertiesUtil.getConnection()) { 
				
				int intStatusAdmin;
				int intStatusNotCustomer;
				if(user.isAdmin()) intStatusAdmin = 1;
				else intStatusAdmin = 0;
				if(user.getNotCustomer()) intStatusNotCustomer = 1;
				else intStatusNotCustomer = 0;
				
				CallableStatement stmt = conn.prepareCall("{CALL update_bank (?, ?, ?, ?, ?, ?, ?, ?)}"); 
				stmt.setInt(++index, user.getAccountNumber()); 
				stmt.setString(++index, user.getEmail());
				stmt.setDouble(++index, user.getBalance());
				stmt.setString(++index, user.getFirstName());
				stmt.setString(++index, user.getLastName());
				stmt.setInt(++index, intStatusAdmin);
				stmt.setInt(++index, intStatusNotCustomer);
				stmt.setString(++index, user.getPassword());
				
				return stmt.executeUpdate() > 0; 
				
		
		} catch (SQLException sqle) { 
			System.err.println(sqle.getMessage()); 
			System.err.println("SQL State: " + sqle.getSQLState()); 
			System.err.println("Error Code: " + sqle.getErrorCode()); 
		} 
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection()) {
			List<User> users = new ArrayList<User>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				users.add(new User(rs.getInt("account_number"),rs.getString("email"),rs.getDouble("balance"),rs.getString("first_name")
						  ,rs.getString("last_name"),rs.getInt("is_admin") == 1, rs.getInt("not_customer") == 1,rs.getString("password")));
			}
			return users;
		} catch (SQLException sqle) { 
			System.err.println(sqle.getMessage()); 
			System.err.println("SQL State: " + sqle.getSQLState()); 
			System.err.println("Error Code: " + sqle.getErrorCode()); 
		} 
		return null;
	}

	@Override
	public List<String> getAllUserEmails() {
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection()) {
			List<String> emails = new ArrayList<String>();
			PreparedStatement stmt = conn.prepareStatement("SELECT email FROM bank");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				emails.add(rs.getString("email"));
			}
			return emails;
		} catch (SQLException sqle) { 
			System.err.println(sqle.getMessage()); 
			System.err.println("SQL State: " + sqle.getSQLState()); 
			System.err.println("Error Code: " + sqle.getErrorCode()); 
		} 
		return null;
	}

	@Override
	public String checkPassword(String email) {
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection()) {
			int index = 0;
			String password;
			PreparedStatement stmt = conn.prepareStatement("SELECT password FROM bank WHERE email=?");
			stmt.setString(++index, email);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			password = rs.getString("password");
			
			return password;
		} catch (SQLException sqle) { 
			System.err.println(sqle.getMessage()); 
			System.err.println("SQL State: " + sqle.getSQLState()); 
			System.err.println("Error Code: " + sqle.getErrorCode()); 
		} 
		return null;
	}

	@Override
	public boolean checkIfAdmin(String email) {
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection()) {
			int index = 0;
			boolean isAdmin;
			PreparedStatement stmt = conn.prepareStatement("SELECT is_admin FROM bank WHERE email=?");
			stmt.setString(++index, email);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			isAdmin = rs.getInt("is_admin") == 1;
			
			return isAdmin;
		} catch (SQLException sqle) { 
			System.err.println(sqle.getMessage()); 
			System.err.println("SQL State: " + sqle.getSQLState()); 
			System.err.println("Error Code: " + sqle.getErrorCode()); 
		} 
		return false;
	}

	@Override
	public boolean checkIfNotCustomer(String email) {
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection()) {
			int index = 0;
			boolean notCustomer;
			PreparedStatement stmt = conn.prepareStatement("SELECT not_customer FROM bank WHERE email=?");
			stmt.setString(++index, email);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int rsResult = rs.getInt("not_customer");
			notCustomer = (rsResult == 1);

			return notCustomer;
		} catch (SQLException sqle) { 
			System.err.println(sqle.getMessage()); 
			System.err.println("SQL State: " + sqle.getSQLState()); 
			System.err.println("Error Code: " + sqle.getErrorCode()); 
		} 
		return false;
	}

	@Override
	public List<String> findUnvarifiedUser() {
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection()) {
			List<String> notCustomer = new ArrayList<String>();
			PreparedStatement stmt = conn.prepareStatement("SELECT email FROM bank WHERE not_customer=1");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				notCustomer.add(rs.getString("email"));
			}
			return notCustomer;
		} 
		catch (SQLException sqle) { 
			System.err.println(sqle.getMessage()); 
			System.err.println("SQL State: " + sqle.getSQLState()); 
			System.err.println("Error Code: " + sqle.getErrorCode()); 
		} 
		return null;
	}

	@Override
	public List<String> findNonAdminUsers() {
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection()) {
			List<String> notAdmin = new ArrayList<String>();
			PreparedStatement stmt = conn.prepareStatement("SELECT email FROM bank WHERE is_admin=0 AND not_customer=0");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				notAdmin.add(rs.getString("email"));
			}
			return notAdmin;
		} 
		catch (SQLException sqle) { 
			System.err.println(sqle.getMessage()); 
			System.err.println("SQL State: " + sqle.getSQLState()); 
			System.err.println("Error Code: " + sqle.getErrorCode()); 
		} 
		return null;
	}
	
	
}
