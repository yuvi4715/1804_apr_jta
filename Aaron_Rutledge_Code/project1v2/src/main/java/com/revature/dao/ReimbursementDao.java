package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.service.EmployeeService;
import com.revature.util.ConnectionUtil;

public class ReimbursementDao implements TemplateDao<Reimbursement, Integer>{
	
	final static private Logger log = Logger.getLogger(EmployeeDao.class);
	

	@Override
	public boolean insert(Reimbursement t) {
		
		int index = 0;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			CallableStatement stmt = conn.prepareCall("{CALL insert_request(?, ?, ?, ?)}");
			stmt.setDouble(++index, t.getAmmount());
			stmt.setInt(++index, t.getRequesterid());
			stmt.setString(++index,  t.getImageURL());
			stmt.setString(++index,  t.getPurpose());
			
			return stmt.executeUpdate() > 0;
		} catch(SQLException sqle) {
			
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
			
		}
		
			
		return false;
	}

	@Override
	public Reimbursement get(Integer key) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE requestid = ?");
			stmt.setInt(1, key);
			ResultSet rs = stmt.executeQuery();
			
			
			
			
			if (rs.next()) {
				
				//first new is requester, then reviewer, then status string
				
				Employee emp;
				Employee sv;
				
				emp = EmployeeService.get(rs.getInt("requester"));
				
				if(rs.getInt("reviewer") != 0) {
					
					sv = EmployeeService.get(rs.getInt("reviewer"));
					
				} else {
					
					sv = new Employee();
					
				}
			
				return new Reimbursement(key, rs.getInt("requester"), rs.getInt("reviewer"), emp, sv, rs.getInt("status"), rs.getTimestamp("req_date"), rs.getTimestamp("rev_date"), rs.getString("purpose"), rs.getString("image"), rs.getDouble("ammount"));
			}
			
			
		} catch (SQLException sqle) {
			
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Reimbursement> getAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Reimbursement> riList = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				riList.add(new Reimbursement(rs.getInt("requestid"), rs.getInt("requester"), rs.getInt("reviewer"), 
						EmployeeService.get(rs.getInt("requester")), EmployeeService.get(rs.getInt("reviewer")), 
						rs.getInt("status"), rs.getTimestamp("req_date"), rs.getTimestamp("rev_Date"), 
						rs.getString("purpose"), rs.getString("image"), rs.getDouble("ammount")));
			}
			return riList;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		return null;
}

	@Override
	public boolean update(Reimbursement t) {
		// TODO Auto-generated method stub
		int index = 0;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			CallableStatement stmt;
			
			if (t.getStatus() == 1) {
				
				stmt = conn.prepareCall("{CALL approve_request(?, ?)}");
				stmt.setInt(++index, t.getReqid());
				stmt.setInt(++index, t.getReviewerid());
				return stmt.executeUpdate() > 0;
			}
			if (t.getStatus() == 2) {
				
				stmt = conn.prepareCall("{CALL deny_request(?, ?)}");
				stmt.setInt(++index, t.getReqid());
				stmt.setInt(++index, t.getReviewerid());
				return stmt.executeUpdate() > 0;
			}
			
			return false;
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
	public Reimbursement login(String email, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateStatus(Integer key, int newStatus) {
		// TODO Auto-generated method stub
		
		
		
		
		return false;
	}

	@Override
	public List<Reimbursement> getBy(String colName, Integer num) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Reimbursement> riList = new ArrayList<>();
			int numUnBox = num;
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE status =?");
			//stmt.setString(1, colName);
			stmt.setInt(1, numUnBox);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				riList.add(new Reimbursement(rs.getInt("requestid"), rs.getInt("requester"), rs.getInt("reviewer"), 
						EmployeeService.get(rs.getInt("requester")), EmployeeService.get(rs.getInt("reviewer")), 
						rs.getInt("status"), rs.getTimestamp("req_date"), rs.getTimestamp("rev_Date"), 
						rs.getString("purpose"), rs.getString("image"), rs.getDouble("ammount"))); 
			}
			
			return riList;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		return null;
	}

	@Override
	public List<Reimbursement> getBy(String colName, String str) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Reimbursement> riList = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE requester =?");
			//stmt.setString(1, colName);
			
			int num = Integer.parseInt(str);
			
			
			stmt.setInt(1, num);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				riList.add(new Reimbursement(rs.getInt("requestid"), rs.getInt("requester"), rs.getInt("reviewer"), 
						EmployeeService.get(rs.getInt("requester")), EmployeeService.get(rs.getInt("reviewer")), 
						rs.getInt("status"), rs.getTimestamp("req_date"), rs.getTimestamp("rev_Date"), 
						rs.getString("purpose"), rs.getString("image"), rs.getDouble("ammount"))); //TODO populate constructor
			}
			return riList;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		return null;
	}

	@Override
	public boolean updateEmail(Reimbursement t) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}


