package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.BankAdmin;
import com.revature.util.ConnectionUtil;

public class BankAdminDao implements TemplateDao<BankAdmin, Integer> {
	
	final static private Logger log = Logger.getLogger(AccountHolderDao.class);

	@Override
	public BankAdmin login(Integer key, String pass) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank_admin WHERE ADMINID = ?");
			stmt.setInt(1, key);
			ResultSet rs = stmt.executeQuery();
			
			
			if (rs.next()) {
				
				String str = new String(rs.getString("PASSPHRASE"));
			
				if (str.equals(pass)) {

					return new BankAdmin(key, rs.getString("USERNAME"), pass);
				
				} else {
				
					System.err.println("Password was incorrect.");
				}
				
			} else {
				
				System.out.println("User ID not found.");
				
			}
			
			
			
		} catch(SQLException sqle) {
			
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
			
		}
		
		
		
		
		
		return null;
	}

	@Override
	public boolean insert(BankAdmin t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BankAdmin get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(BankAdmin t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BankAdmin> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStatus(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
