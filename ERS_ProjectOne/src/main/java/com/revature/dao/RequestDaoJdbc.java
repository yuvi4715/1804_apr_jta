package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Request;
import com.revature.util.ConnectionUtil;

public class RequestDaoJdbc implements RequestDao {
	
	//new request made
	@Override
	public boolean insertRequest(Request inputRequest) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL insert_request(?,?,?,?,?,?)}");
			stmt.setFloat(++index, inputRequest.getRequestAmount());
			stmt.setString(++index, inputRequest.getRequester());
			stmt.setString(++index, inputRequest.getReviewedBy());
			stmt.setString(++index, inputRequest.getStatus());
			stmt.setString(++index, inputRequest.getPurpose());
			stmt.setString(++index, inputRequest.getReviewDate());
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}
	

	//Manager viewing requests
	@Override
	public List<Request> getAllRequest(String employeeUser) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Request> employeeRequests = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE requester = ?");
			stmt.setString(1, employeeUser);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				employeeRequests.add(new Request(rs.getInt("request_id"), rs.getFloat("request_amount"),
						rs.getString("requester"),
						rs.getString("reviewed_by"), rs.getString("status"),
						rs.getString("purpose"), rs.getString("request_date"), rs.getString("review_date")
						));
			}
			return employeeRequests;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}
	@Override
	public List<Request> getAllPendingRequest() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Request> pendingRequests = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE status = ?");
			stmt.setString(1, "pending");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pendingRequests.add(new Request(rs.getInt("request_id"), rs.getFloat("request_amount"),
						rs.getString("requester"),
						rs.getString("reviewed_by"), rs.getString("status"),
						rs.getString("purpose"), rs.getString("request_date"), rs.getString("review_date")
						));
			}
			return pendingRequests;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Request> getAllResolvedRequest() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Request> resolvedRequests = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE (status = 'resolved' OR status = 'denied')");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				resolvedRequests.add(new Request(rs.getInt("request_id"), rs.getFloat("request_amount"),
						rs.getString("requester"),
						rs.getString("reviewed_by"), rs.getString("status"),
						rs.getString("purpose"), rs.getString("request_date"), rs.getString("review_date")
						));
			}
			return resolvedRequests;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}
	
//Employee viewing their requests
	@Override
	public List<Request> getAllPendingRequest(String employeeUser) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Request> employeePendingRequests = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE requester = ? AND status = 'pending'");
			stmt.setString(1, employeeUser);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				employeePendingRequests.add(
						new Request(rs.getInt("request_id"), rs.getFloat("request_amount"), rs.getString("requester"),
								rs.getString("reviewed_by"), rs.getString("status"), rs.getString("purpose"),
								rs.getString("request_date"), rs.getString("review_date")));
			}
			return employeePendingRequests;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}
	
	public static void main(String[] args) {
		RequestDao rd = new RequestDaoJdbc();
		System.out.println(rd.getAllPendingRequest("username"));
	}

	@Override
	public List<Request> getAllResolvedRequest(String employeeUser) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Request> employeeResolvedRequests = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE requester = ? AND (status = 'resolved' OR status = 'denied')");
			stmt.setString(1, employeeUser);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				employeeResolvedRequests.add(
						new Request(rs.getInt("request_id"), rs.getFloat("request_amount"), rs.getString("requester"),
								rs.getString("reviewed_by"), rs.getString("status"), rs.getString("purpose"),
								rs.getString("request_date"), rs.getString("review_date")));
			}
			return employeeResolvedRequests;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public boolean approveRequest(int inputID, String username) {
		int index = 0;
		int input = inputID;
		String name = username;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL approve_request(?, ?)}");
			stmt.setInt(++index, input);
			stmt.setString(++index, name);
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean denyRequest(int inputID, String username) {
		int index = 0;
		int input = inputID;
		String name = username;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL deny_request(?, ?)}");
			stmt.setInt(++index, input);
			stmt.setString(++index, name);
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}
}
