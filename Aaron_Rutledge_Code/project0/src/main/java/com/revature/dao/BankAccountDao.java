package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.BankAccount;
import com.revature.util.ConnectionUtil;

public class BankAccountDao implements TemplateDao<BankAccount, Integer>{

	final static private Logger log = Logger.getLogger(BankAccountDao.class);
	
	@Override
	public boolean insert(BankAccount t) {
		// TODO Auto-generated method stub
		int index = 0;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			CallableStatement stmt = conn.prepareCall("{CALL insert_bank_Account(?, ?, ?)}");
			//(1, 1, 50.0)
			stmt.setInt(++index, t.getHolder());
			stmt.setInt(++index, t.getAccountType());
			stmt.setFloat(++index, (float) t.getBalance());
			
			return stmt.executeUpdate() > 0;
			
		} catch (SQLException sqle) {
			
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
			
		}

		return false;
	}

	@Override
	public BankAccount get(Integer key) {
		// TODO Auto-generated method stub
		
		int key1, key2;
		//int index = 0;
		
		key1 = key%10;
		
		key2 = key/10;
		//System.out.println(key1);
		//System.out.println(key2);
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank_account WHERE ACCOUNTTYPE = ? AND HOLDER = ?");
			
			stmt.setInt(1, 1);
			stmt.setInt(2, key2);
			
			ResultSet rs = stmt.executeQuery();
			
			//System.out.println(rs.toString());
			
			if(rs.next()) {
				
				BankAccount ba = new BankAccount(rs.getInt("ACCOUNTTYPE"), rs.getInt("HOLDER"), rs.getFloat("BALANCE"));
				//System.out.println(ba.toString());
				
				return ba;
				
			}
		} catch (SQLException sqle) {
			
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		
		
		return null;
	}

	@Override
	public List<BankAccount> getAll() {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			List<BankAccount> baList = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM account_holder");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				baList.add(new BankAccount(rs.getInt("ACCOUNTTYPE"), rs.getInt("HOLDER"), rs.getFloat("BALANCE")));
				
			}
			
			
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		
		
		
		return null;
		
	}

	@Override
	public boolean update(BankAccount t) {
		// TODO Auto-generated method stub
		int index = 0;
		double temp = 0;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			PreparedStatement stmt1 = conn.prepareStatement("SELECT * FROM bank_account WHERE ACCOUNTTYPE = ? AND HOLDER = ?");
			stmt1.setInt(++index, t.getAccountType());
			stmt1.setInt(++index, t.getHolder());
			
			ResultSet rs1 = stmt1.executeQuery();
			if (rs1.next()) {
				
				temp = rs1.getFloat("BALANCE");
				
			}
			index = 0;
			CallableStatement stmt2 = conn.prepareCall("{CALL deposit_or_withdrawl(?, ?, ?, ?, ?)}");
			//ident, atype, amt, curbalance, comments
			stmt2.setInt(++index, t.getHolder());
			stmt2.setInt(++index, t.getAccountType());
			stmt2.setFloat(++index, (float) (t.getBalance() - temp));
			stmt2.setFloat(++index, (float) temp);
			stmt2.setString(++index, t.toString());
			
			
			
			return stmt2.executeUpdate() > 0;
			
		} catch(SQLException sqle) {
			
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
			
			
		}
		return false;
	}

	@Override
	public boolean delete(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BankAccount login(Integer key, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateStatus(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
