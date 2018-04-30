package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Request;
import com.revature.util.ConnectionUtil;



public class RequestDaoImpl implements RequestDao {
	
	private static RequestDaoImpl instance = null;
	private static Logger log = Logger.getLogger(RequestDaoImpl.class);
	
	private RequestDaoImpl() {}
	
	public static RequestDaoImpl getInstance() {
		if (instance == null) {
			instance = new RequestDaoImpl();
		}
		return instance;
	}
	
	@Override
	public boolean insertIntoRequest(Request request) {
		int index = 0; 
		 
		try (Connection conn = ConnectionUtil.getConnection()) { 
				CallableStatement stmt = conn.prepareCall("{CALL insert_request (?, ?, ?, ?, ?)}"); 
				stmt.setDouble(++index, request.getRequestAmount()); 
				stmt.setInt(++index, request.getRequester()); 
				stmt.setInt(++index, request.getReviewedBy());
				stmt.setString(++index, request.getStatusOfRequest());
				stmt.setString(++index, request.getPurpose());
				
				return stmt.executeUpdate() > 0; 
				
		
		} catch (SQLException sqle) { 
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when inserting a request into your sql database"); 
		} 
		return false;
	}

	@Override
	public boolean updateReviewed(int requestId,String statusOfRequest,int reviewedBy) {
		int index = 0; 
		 
		try (Connection conn = ConnectionUtil.getConnection()) { 
				CallableStatement stmt = conn.prepareCall("{CALL update_reviewed(?, ?, ?, ?)}"); 
				stmt.setInt(++index, requestId); 
				stmt.setString(++index, statusOfRequest); 
				stmt.setInt(++index, reviewedBy);
				Timestamp ts = new Timestamp(System.currentTimeMillis());
				stmt.setTimestamp(++index, ts);

				
				return stmt.executeUpdate() > 0; 
				
		
		} catch (SQLException sqle) { 
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when inserting into your sql database"); 
		}  
		 
		return false;
	}

	@Override
	public boolean updateStatusOfRequest(int requestId, String status) {
		int index = 0; 
		 
		try (Connection conn = ConnectionUtil.getConnection()) { 
				CallableStatement stmt = conn.prepareCall("{CALL update_request_status(?, ?)}"); 
				stmt.setInt(++index, requestId); 
				stmt.setString(++index, status); 
				
				return stmt.executeUpdate() > 0; 
				
		
		} catch (SQLException sqle) { 
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when inserting into your sql database"); 
		} 
		return false;
	}

	@Override
	public List<Request> getRequestsByRequesterUsername(String username) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()){
			List<Request> requests = new ArrayList<Request>();
			PreparedStatement stmt = conn.prepareStatement("SELECT request_id,request_amount,requester,reviewed_by,status_of_request,purpose,request_date,review_date FROM request INNER JOIN EMPLOYEE ON request.requester = employee.employee_id WHERE username =  ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				requests.add(new Request(rs.getInt("request_id"), rs.getDouble("request_amount"),
						rs.getInt("requester"),rs.getInt("reviewed_by"),rs.getString("status_of_request")
						,rs.getString("purpose"),rs.getTimestamp("request_date"),rs.getTimestamp("review_date")));
			}
			System.out.println(requests);
			return requests;
		}catch(SQLException sqle) {
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when inserting into your sql database");
		}
		return null;
	}

	@Override
	public List<Request> getAllRequests() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			List<Request> requests = new ArrayList<Request>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				requests.add(new Request(rs.getInt("request_id"), rs.getDouble("request_amount"),
						rs.getInt("requester"),rs.getInt("reviewed_by"),rs.getString("status_of_request")
						,rs.getString("purpose"),rs.getTimestamp("request_date"),rs.getTimestamp("review_date")));
			}
			return requests;
		} catch (SQLException sqle) { 
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when getting all requests"); 
		} 
		return null;
	}
	
	@Override
	public List<Request> getAllPendingRequests() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			List<Request> requests = new ArrayList<Request>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE status_of_request = 'Pending'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				requests.add(new Request(rs.getInt("request_id"), rs.getDouble("request_amount"),
						rs.getInt("requester"),rs.getInt("reviewed_by"),rs.getString("status_of_request")
						,rs.getString("purpose"),rs.getTimestamp("request_date"),rs.getTimestamp("review_date")));
			}
			return requests;
		} catch (SQLException sqle) { 
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when getting all pending requests");; 
		} 
		return null;
	}
	
	@Override
	public List<Request> getAllApprovedRequests() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			List<Request> requests = new ArrayList<Request>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE status_of_request = 'approved'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				requests.add(new Request(rs.getInt("request_id"), rs.getDouble("request_amount"),
						rs.getInt("requester"),rs.getInt("reviewed_by"),rs.getString("status_of_request")
						,rs.getString("purpose"),rs.getTimestamp("request_date"),rs.getTimestamp("review_date")));
			}
			return requests;
		} catch (SQLException sqle) { 
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when getting all approved requests"); 
		} 
		return null;
	}
	//TODO possibly add inner join to this so that employee only sees their own list of requests
	@Override
	public List<Request> getAllDeniedRequests() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			List<Request> requests = new ArrayList<Request>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE status_of_request = 'denied'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				requests.add(new Request(rs.getInt("request_id"), rs.getDouble("request_amount"),
						rs.getInt("requester"),rs.getInt("reviewed_by"),rs.getString("status_of_request")
						,rs.getString("purpose"),rs.getTimestamp("request_date"),rs.getTimestamp("review_date")));
			}
			return requests;
		} catch (SQLException sqle) { 
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when getting all denied requests"); 
		} 
		return null;
	}

	@Override
	public boolean updateRequest(Request request) {
		int index = 0; 
		 
		try (Connection conn = ConnectionUtil.getConnection()) { 
				CallableStatement stmt = conn.prepareCall("{CALL update_request(?, ?, ?, ?, ?, ?, ?, ?)}"); 
				stmt.setInt(++index, request.getRequestId()); 
				stmt.setDouble(++index, request.getRequestAmount()); 
				stmt.setInt(++index, request.getRequester());
				stmt.setInt(++index, request.getReviewedBy());
				stmt.setString(++index, request.getStatusOfRequest());
				stmt.setString(++index, request.getPurpose());
				stmt.setTimestamp(++index, request.getRequestDate());
				stmt.setTimestamp(++index, request.getReviewDate());
				
				
				return stmt.executeUpdate() > 0; 
				
		
		} catch (SQLException sqle) { 
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when fulling updating a request"); 
		} 
		return false;
	}

	@Override
	public List<Request> getRequestsByReviewerUsername(String username) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()){
			List<Request> requests = new ArrayList<Request>();
			PreparedStatement stmt = conn.prepareStatement("SELECT request_id,request_amount,requester,reviewed_by,status_of_request,purpose,request_date,review_date FROM request INNER JOIN EMPLOYEE ON request.reviewed_by = employee.employee_id WHERE username = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				requests.add(new Request(rs.getInt("request_id"), rs.getDouble("request_amount"),
						rs.getInt("requester"),rs.getInt("reviewed_by"),rs.getString("status_of_request")
						,rs.getString("purpose"),rs.getTimestamp("request_date"),rs.getTimestamp("review_date")));
			}
			return requests;
		}catch(SQLException sqle) {
			log.error(sqle.getMessage() + "\nSQL State: " + sqle.getSQLState() + "\nError Code: " + sqle.getErrorCode(), sqle);
			System.out.println("An error occured when getting a request by username");
		}
		return null;
	}
}
