package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

import org.apache.log4j.Logger;

import com.revature.model.AccountHolder;
import com.revature.util.ConnectionUtil;


public class AccountHolderDao implements TemplateDao<AccountHolder, Integer> {

	final static private Logger log = Logger.getLogger(AccountHolderDao.class);
	
	
	//Insert tested and working.
	@Override
	public boolean insert(AccountHolder t) {
		int index = 0;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			CallableStatement stmt = conn.prepareCall("{CALL insert_account_holder(?, ?, ?)}");
			stmt.setString(++index,  t.getfName());
			stmt.setString(++index,  t.getlName());
			stmt.setString(++index,  t.getPass());
			
			return stmt.executeUpdate() > 0;
		} catch(SQLException sqle) {
			
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
			
			
		}
		return false;
	}

	
	//Get tested and working.
	@Override
	public AccountHolder get(Integer key) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM account_holder WHERE USERID = ?");
			stmt.setInt(1, key);
			ResultSet rs = stmt.executeQuery();
			
			
			if (rs.next()) {
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("MEMBERSINCE"));
				return new AccountHolder(rs.getInt("USERID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), cal, rs.getString("PASSPHRASE"), rs.getInt("STATUSFLAG"));
			}
			
			
		} catch (SQLException sqle) {
			
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
			
			
		}
		
		return null;
	}

	//getAll tested and working
	@Override
	public List<AccountHolder> getAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<AccountHolder> ahList = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM account_holder WHERE STATUSFLAG = 0");
			ResultSet rs = stmt.executeQuery();
			Calendar cal = Calendar.getInstance();
			
			while (rs.next()) {
				cal.setTime(rs.getDate("MEMBERSINCE")); 
				ahList.add(new AccountHolder(rs.getInt("USERID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), cal, rs.getString("PASSPHRASE"), rs.getInt("STATUSFLAG")));
			}
			return ahList;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		return null;
	}

	
	//update tested and working
	@Override
	public boolean update(AccountHolder t) {
		
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			CallableStatement stmt = conn.prepareCall("{CALL update_account_holder(?, ?, ?, ?)}");
			stmt.setInt(++index, t.getUserID());
			stmt.setString(++index,  t.getfName());
			stmt.setString(++index,  t.getlName());
			stmt.setString(++index,  t.getPass());
			
			return stmt.executeUpdate() > 0;
		} catch(SQLException sqle) {
			
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
			
			
		}
		return false;
		
	}
	
	public AccountHolder login(Integer key, String pass) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM account_holder WHERE USERID = ?");
			stmt.setInt(1, key);
			ResultSet rs = stmt.executeQuery();
			
			
			if (rs.next()) {
				
				String str = new String(rs.getString("PASSPHRASE"));
			
				if (str.equals(pass)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("MEMBERSINCE"));
				return new AccountHolder(rs.getInt("USERID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), cal, rs.getString("PASSPHRASE"), rs.getInt("STATUSFLAG"));
				
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
	public boolean delete(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean updateStatus(Integer key) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			CallableStatement stmt = conn.prepareCall("{CALL update_account_holder_status(?, ?)}");
			stmt.setInt(1, key);
			stmt.setInt(2, 1);
			
			return stmt.executeUpdate() > 0;
		} catch(SQLException sqle) {
			
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
			
			
		}
		return false;
		
	}
	
	

}
