package com.revature.bankDao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import com.revature.bankModel.Admin;
import com.revature.bankModel.Customer;
import com.revature.bankUtil.establishConnection;

public class BankDaoImp implements BankDao{

	@Override
	public boolean createCustomer(Customer customer) {
		int index = 0;
		try (Connection conn = establishConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL insert_Account(?,?,?,?,?)}");
			stmt.setString(++index, customer.getFirstName());
			stmt.setString(++index, customer.getLastName());
			stmt.setString(++index, customer.getUserName());
			stmt.setString(++index, customer.getPassWord());
			return stmt.executeUpdate() > 0;
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}
	
	@Override
	public Customer loginCustomer(String userName, String passWord) {
		try (Connection conn = establishConnection.getConnection()){
			PreparedStatement stmt = 
						conn.prepareStatement("SELECT * FROM User_Account WHERE User_Name = ? AND User_Password = ? AND Approval = 1");
			stmt.setString(1, userName);
			stmt.setString(2, passWord);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Customer customer = new Customer(rs.getString("User_Name"), rs.getString("User_Password"), 
						rs.getString("First_Name"), rs.getString("Last_Name"));
				return customer;
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public Admin loginAdmin(String userName, String passWord) {
		try (Connection conn = establishConnection.getConnection()){
			PreparedStatement stmt = 
					conn.prepareStatement("SELECT * FROM Admin_Account WHERE User_Name = ? AND Admin_Password = ?");
			stmt.setString(1, userName);
			stmt.setString(2, passWord);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Admin admin = new Admin(rs.getString("User_Name"), rs.getString("Admin_Password"), 
						rs.getString("First_Name"), rs.getString("Last_Name"));
				return admin;
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}
	
	
	@Override
	public List<String> getAllCustomers() {
		try (Connection conn = establishConnection.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USER_ACCOUNT");
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData(); 
		    int columnsNumber = rsmd.getColumnCount();
		    //	System.out.format("ID)
				while (rs.next()) {
					for (int i = 1; i <= columnsNumber; i++) {
						if (i > 1) {
							String columnValue = rs.getString(i);
							System.out.format("|%20s|", columnValue);
							}
					}
			   
				}
	    return null;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean getAdmin(String admin_user_name) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean addTransaction(String userName, BigDecimal amount) {

		try (Connection conn = establishConnection.getConnection()){
			CallableStatement stmt = conn.prepareCall("{CALL insert_Transaction(?,?)}");
			stmt.setString(1, userName);
			stmt.setBigDecimal(2, amount);
			return stmt.executeUpdate() > 0;
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}
	
	@Override
	public boolean viewTransactions(String userName) {
		
		try (Connection conn = establishConnection.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USER_ACCOUNT WHERE User_Name = ?");
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				for (int i = 1; i <= columnsNumber; i++) {
//					if (i > 1) {
//						String columnValue = rs.getString(i);
//						System.out.format("|%20s|", columnValue);
//						}
//				}
//		   
//			}			
			return stmt.executeUpdate() > 0;
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	@Override
	public long checkAccountBalance(String userName) {
		try (Connection conn = establishConnection.getConnection()){
			PreparedStatement stmt = 
			conn.prepareStatement("SELECT BALANCE FROM User_Account WHERE User_Name = ?");
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getLong("Balance");
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}

		return 0;
	}



}
