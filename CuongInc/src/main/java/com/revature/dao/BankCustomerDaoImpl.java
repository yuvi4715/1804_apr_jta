package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.BankCustomer;
import com.revature.util.ConnectDatabase;

public class BankCustomerDaoImpl implements BankCustomerDao {
	
	//Method to create new Bank customer to database
	@Override
	public boolean insertBankCustomer(BankCustomer inputCustomer) {
		int index = 0;
		try (Connection conn = ConnectDatabase.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL insert_bc(?, ?, ?, ?, ?, ?, ?)}");
			stmt.setString(++index, inputCustomer.getAccountType());
			stmt.setString(++index, inputCustomer.getFirstName());
			stmt.setString(++index, inputCustomer.getLastName());
			stmt.setString(++index, inputCustomer.getUsername());
			stmt.setString(++index, inputCustomer.getPassword());
			stmt.setInt(++index, inputCustomer.getAccesslevel());
			stmt.setDouble(++index, inputCustomer.getBalance());
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public BankCustomer getBankCustomer(String username) {
		int index = 0;
		try (Connection conn = ConnectDatabase.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank_customer WHERE username = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new BankCustomer(rs.getString("accounttype"),
						rs.getString("firstname"), rs.getString("lastname"),
						rs.getString("username"), rs.getString("password"),
						rs.getInt("accesslevel"), rs.getFloat("balance"));
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
}

	@Override
	public List<BankCustomer> getAllBankCustomer() {
		try (Connection conn = ConnectDatabase.getConnection()) {
			List<BankCustomer> bankcustomer = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank_customer");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				bankcustomer.add(new BankCustomer(rs.getString("accounttype"),
						rs.getString("firstname"), rs.getString("lastname"),
						rs.getString("username"), rs.getString("password"),
						rs.getInt("accesslevel"), rs.getFloat("balance")));
			}
			return bankcustomer;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public boolean updateBankCustomer(BankCustomer inputCustomer) {
		int index = 0;
		try (Connection conn = ConnectDatabase.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL transaction( ?, ?)}");
			stmt.setString(++index, inputCustomer.getUsername());
			stmt.setDouble(++index, inputCustomer.getBalance());
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean deleteBankCustomer(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approveBankCustomer(BankCustomer inputCustomer) {
		int index = 0;
		try (Connection conn = ConnectDatabase.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL approve( ?, ?)}");
			stmt.setString(++index, inputCustomer.getUsername());
			stmt.setDouble(++index, inputCustomer.getAccesslevel());
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}
}
