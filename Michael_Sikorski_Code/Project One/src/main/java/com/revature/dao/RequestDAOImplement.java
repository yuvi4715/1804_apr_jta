/*
 *	Author: Michael Sikorski
 *	Date: 4/29/2018
 *
 *	Project One - Reimbursement Request System
 */

package com.revature.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.revature.model.*;
import com.revature.util.ConnectionWithProperties;
import com.revature.util.LogUtil;

// The implementation for the RequestDAO interface
public class RequestDAOImplement implements RequestDAO {

	private static RequestDAOImplement instance;

	private RequestDAOImplement() {
	}

	public static RequestDAOImplement getInstance() {
		if (instance == null) {
			instance = new RequestDAOImplement();
		}
		return instance;
	}

	@Override
	public boolean createNewRequest(String requester, double amount, String purpose) {
		boolean success = false;
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{call insert_request(?,?,?)}");
			stmt.setDouble(1, amount);
			stmt.setString(2, requester);
			stmt.setString(3, purpose);
			if (stmt.executeUpdate() > 0) {
				success = true;
				LogUtil.logger.info(requester + " submitted a new request for $" + amount);
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return success;
	}

	@Override
	public Request getRequestById(int requestId) {
		Request request = null;
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE r_id=?");
			stmt.setInt(1, requestId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				request = new Request(rs.getInt("r_id"), rs.getDouble("r_amount"), rs.getString("r_requester"),
						rs.getString("r_reviewed_by"), rs.getString("r_status"), rs.getString("r_purpose"),
						rs.getDate("r_request_date"), rs.getDate("r_review_date"));
			} else {
				LogUtil.logger.error("There was an issue getting the request with ID #" + requestId);
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return request;
	}

	@Override
	public List<Request> getAllRequestsBySingleEmployee(String email) {
		List<Request> thisEmployeesRequests = new ArrayList<>();
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE r_requester=?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				thisEmployeesRequests.add(new Request(rs.getInt("r_id"), rs.getDouble("r_amount"),
						rs.getString("r_requester"), rs.getString("r_reviewed_by"), rs.getString("r_status"),
						rs.getString("r_purpose"), rs.getDate("r_request_date"), rs.getDate("r_review_date")));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return thisEmployeesRequests;
	}

	@Override
	public List<Request> getEmployeesResolvedRequests(String email) {
		List<Request> theirResolved = new ArrayList<>();
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE r_requester=? AND r_status<>?");
			stmt.setString(1, email);
			stmt.setString(2, "Pending Approval");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				theirResolved.add(new Request(rs.getInt("r_id"), rs.getDouble("r_amount"),
						rs.getString("r_requester"), rs.getString("r_reviewed_by"), rs.getString("r_status"),
						rs.getString("r_purpose"), rs.getDate("r_request_date"), rs.getDate("r_review_date")));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return theirResolved;
	}
	
	@Override
	public List<Request> getEmployeesPendingRequests(String email) {
		List<Request> allPendingForThisEmployee = new ArrayList<>();
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE r_status=? AND r_requester=?");
			stmt.setString(1, "Pending Approval");
			stmt.setString(2, email);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				allPendingForThisEmployee.add(new Request(rs.getInt("r_id"), rs.getDouble("r_amount"),
						rs.getString("r_requester"), rs.getString("r_reviewed_by"), rs.getString("r_status"),
						rs.getString("r_purpose"), rs.getDate("r_request_date"), rs.getDate("r_review_date")));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return allPendingForThisEmployee;
	}

	@Override
	public List<Request> getAllRequests() {
		List<Request> all = new ArrayList<>();
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REQUEST");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				all.add(new Request(rs.getInt("r_id"), rs.getDouble("r_amount"), rs.getString("r_requester"),
						rs.getString("r_reviewed_by"), rs.getString("r_status"), rs.getString("r_purpose"),
						rs.getDate("r_request_date"), rs.getDate("r_review_date")));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return all;
	}

	@Override
	public List<Request> getAllResolvedRequests() {
		List<Request> allResolved = new ArrayList<>();
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE r_status <> ?");
			stmt.setString(1, "Pending Approval");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				allResolved.add(new Request(rs.getInt("r_id"), rs.getDouble("r_amount"), rs.getString("r_requester"),
						rs.getString("r_reviewed_by"), rs.getString("r_status"), rs.getString("r_purpose"),
						rs.getDate("r_request_date"), rs.getDate("r_review_date")));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return allResolved;
	}
	
	@Override
	public List<Request> getAllPendingRequests() {
		List<Request> allPending = new ArrayList<>();
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM REQUEST WHERE r_status=?");
			stmt.setString(1, "Pending Approval");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				allPending.add(new Request(rs.getInt("r_id"), rs.getDouble("r_amount"), rs.getString("r_requester"),
						rs.getString("r_reviewed_by"), rs.getString("r_status"), rs.getString("r_purpose"),
						rs.getDate("r_request_date"), rs.getDate("r_review_date")));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return allPending;
	}

	
	// resolve_request(id IN VARCHAR2, status IN VARCHAR2, manager IN VARCHAR2)
	@Override
	public boolean resolveRequest(int requestId, String newStatus, String manager) {
		boolean updated = false;
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{call resolve_request(?,?,?)}");
			stmt.setInt(1, requestId);
			stmt.setString(2, newStatus);
			stmt.setString(3, manager);
			if (stmt.executeUpdate() > 0) {
				updated = true;
				LogUtil.logger
						.info("Request with ID of " + requestId + " has been resolved. Its new status is: " + newStatus);
			} else {
				LogUtil.logger.error("There was an issue updating the request with ID #" + requestId);
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return updated;
	}

	@Override
	public boolean deleteRequest(int requestId) {
		// Not supported at this time
		return false;
	}

}
