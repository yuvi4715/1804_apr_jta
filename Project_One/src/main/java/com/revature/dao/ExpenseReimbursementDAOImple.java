package com.revature.dao;
import org.apache.log4j.Logger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.util.List;

import com.revature.model.Reimbursements;
import com.revature.model.Users;
import com.revature.util.ConnectionUtil;

public class ExpenseReimbursementDAOImple implements ExpenseReimbursementDAO {
	
    final static Logger logger = Logger.getLogger(ExpenseReimbursementDAO.class); 


	@Override
	public boolean insert_users(Users users_id) {
		
		int in = 0;
        try (Connection conn = ConnectionUtil.getConnection()){
			
            CallableStatement stmt = conn.prepareCall("{CALL insert_users(?,?,?,?,?,?)}");
            stmt.setString(++in, users_id.getUsername());
            stmt.setString(++in, users_id.getPassword());
            stmt.setString(++in, users_id.getFirst_name());
            stmt.setString(++in, users_id.getLast_name());
            stmt.setString(++in, users_id.getEmail());
            stmt.setInt(++in, users_id.getIsManager());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
			System.out.println("The Database could not be reached at this moment.");
			logger.error(e.getMessage());
			logger.error("SQL State: " + e.getSQLState());
			logger.error("Error Code: " + e.getErrorCode());
        }
		
		return false;
	}

	@Override
	public boolean insert_requests(Reimbursements reimb_request) {
		
		int in = 0;
        try (Connection conn = ConnectionUtil.getConnection()){
			
            CallableStatement stmt = conn.prepareCall("{CALL insert_requests(?,?,?)}");
            stmt.setDouble(++in, reimb_request.getReimb_amount());
            stmt.setInt(++in, reimb_request.getReimb_requester());
            stmt.setString(++in, reimb_request.getReimb_purpose());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
			System.out.println("The Database could not be reached at this moment.");
			logger.error(e.getMessage());
			logger.error("SQL State: " + e.getSQLState());
			logger.error("Error Code: " + e.getErrorCode());
        }
		
		return false;
	}

	@Override
	public boolean modify_requests(Reimbursements reimb_request, Users users_id) {
		
		int in = 0;
        try (Connection conn = ConnectionUtil.getConnection()){
			
            CallableStatement stmt = conn.prepareCall("{CALL modify_requests(?,?)}");
            stmt.setInt(++in, reimb_request.getReimb_id());
            stmt.setInt(++in, reimb_request.getReimb_status());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
			System.out.println("The Database could not be reached at this moment.");
			logger.error(e.getMessage());
			logger.error("SQL State: " + e.getSQLState());
			logger.error("Error Code: " + e.getErrorCode());
        }
		
		return false;
	}

	@Override
	public boolean modify_users(Users users_id) {
		
		int in = 0;
        try (Connection conn = ConnectionUtil.getConnection()){
			
			CallableStatement stmt = conn.prepareCall("{CALL modify_user(?,?,?,?,?,?)}");
			stmt.setInt(++in, users_id.getUsers_id());
			stmt.setString(++in, users_id.getUsername());
			stmt.setString(++in, users_id.getPassword());
			stmt.setString(++in, users_id.getFirst_name());
			stmt.setString(++in, users_id.getLast_name());
			stmt.setString(++in, users_id.getEmail());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
			System.out.println("The Database could not be reached at this moment.");
			logger.error(e.getMessage());
			logger.error("SQL State: " + e.getSQLState());
			logger.error("Error Code: " + e.getErrorCode());
        }
		
		
		return false;
	}

	@Override
	public List<Reimbursements> emp_view_pending_requests(Users users_id, int reimb_status) {
		
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()){
	
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement_request WHERE reimb_requester = ? AND reimb_status = ?");
			stmt.setInt(++index, users_id.getUsers_id());
			stmt.setInt(++index, reimb_status);

			ResultSet rs = stmt.executeQuery();
			index = -1;
			List<Reimbursements> requestList = new ArrayList<>();
			while(rs.next()){
				requestList.add(++index, new Reimbursements(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"), rs.getDate("reimb_request"), 
						rs.getDate("reimb_review"), rs.getString("reimb_purpose"), rs.getInt("reimb_requester"), rs.getInt("reimb_reviewer"), 
						rs.getInt("reimb_status")));
			}
			return requestList;
		} catch (SQLException e){
			System.out.println("The Database could not be reached at this moment.");
            logger.error(e.getMessage());
			logger.error("SQL State: " + e.getSQLState());
			logger.error("Error Code: " + e.getErrorCode());
		}
		
		return null;
	}

	@Override
	public List<Reimbursements> emp_view_resolved_requests(Users users_id, int reimb_status) {
		return null;
	}

	@Override
	public List<Reimbursements> man_view_all_requests() {
		
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()){
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement_request");

			ResultSet rs = stmt.executeQuery();
			index = -1;
			List<Reimbursements> requestList = new ArrayList<>();
			while(rs.next()){
				requestList.add(++index, new Reimbursements(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"), rs.getDate("reimb_request"), 
						rs.getDate("reimb_review"), rs.getString("reimb_purpose"), rs.getInt("reimb_requester"), rs.getInt("reimb_reviewer"), 
						rs.getInt("reimb_status")));
			}
			return requestList;
		} catch (SQLException e){
			System.out.println("The Database could not be reached at this moment.");
            logger.error(e.getMessage());
			logger.error("SQL State: " + e.getSQLState());
			logger.error("Error Code: " + e.getErrorCode());
		}
		
		return null;
	}

	@Override
	public List<Reimbursements> man_view_pending_requests(int status) {
		
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()){
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement_request WHERE reimb_status = ?");
			stmt.setInt(++index, status);

			ResultSet rs = stmt.executeQuery();
			index = -1;
			List<Reimbursements> requestList = new ArrayList<>();
			while(rs.next()){
				requestList.add(++index, new Reimbursements(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"), rs.getDate("reimb_request"), 
						rs.getDate("reimb_review"), rs.getString("reimb_purpose"), rs.getInt("reimb_requester"), rs.getInt("reimb_reviewer"), 
						rs.getInt("reimb_status")));
			}
			return requestList;
		} catch (SQLException e){
			System.out.println("The Database could not be reached at this moment.");
            logger.error(e.getMessage());
			logger.error("SQL State: " + e.getSQLState());
			logger.error("Error Code: " + e.getErrorCode());
		}
		
		
		return null;
	}

	@Override
	public List<Reimbursements> man_view_emp_requests(int reimb_requester) {
		
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()){
	
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement_request WHERE reimb_requester = ?");
			stmt.setInt(++index, reimb_requester);

			ResultSet rs = stmt.executeQuery();
			index = -1;
			List<Reimbursements> requestList = new ArrayList<>();
			while(rs.next()){
				requestList.add(++index, new Reimbursements(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"), rs.getDate("reimb_request"), 
						rs.getDate("reimb_review"), rs.getString("reimb_purpose"), rs.getInt("reimb_requester"), rs.getInt("reimb_reviewer"), 
						rs.getInt("reimb_status")));
			}
			return requestList;
		} catch (SQLException e){
			System.out.println("The Database could not be reached at this moment.");
            logger.error(e.getMessage());
			logger.error("SQL State: " + e.getSQLState());
			logger.error("Error Code: " + e.getErrorCode());
		}
		
		
		return null;
	}

}
