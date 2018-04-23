package com.revature.ers.dao;

import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.ers.model.*;
import com.revature.ers.util.ConnectionUtil;

public class ERSDAOImpl implements ERSDAO{
    final static Logger log = Logger.getLogger(ERSDAO.class); 
	@Override
	public boolean insert_user(ERS_User user) {
        int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()){
			//Create a CallableStatement object to call the procedure inser_user() and pass
			//the arguments which are in the ERS_user object
            CallableStatement stmt = conn.prepareCall("{CALL insert_user(?,?,?,?,?)}");
            stmt.setString(++index, user.getEmail());
            stmt.setString(++index, user.getPasswd());
            stmt.setString(++index, user.getFirstName());
            stmt.setString(++index, user.getLastName());
            stmt.setInt(++index, user.getIsManager());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
			System.out.println("An error ocurrend when communicating with the database.");
            log.error(e.getMessage());
			log.error("SQL State: " + e.getSQLState());
			log.error("Error Code: " + e.getErrorCode());
        }
		return false;
	}

	@Override
	public boolean insert_request(Request request) {
		int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()){
			//Create a CallableStatement object to call the procedure insert_request() and pass
			//the arguments which are in the Request object
            CallableStatement stmt = conn.prepareCall("{CALL insert_request(?,?,?)}");
            stmt.setDouble(++index, request.getReq_amount());
            stmt.setInt(++index, request.getRequester());
            stmt.setString(++index, request.getPurpose());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
			System.out.println("An error ocurrend when communicating with the database.");
            log.error(e.getMessage());
			log.error("SQL State: " + e.getSQLState());
			log.error("Error Code: " + e.getErrorCode());
        }
		return false;
	}

	@Override
	public boolean modify_request(Request request) {
		int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()){
			//Create a CallableStatement object to call the procedure modify_request() and pass
			//the arguments which are in the Request object
            CallableStatement stmt = conn.prepareCall("{CALL modify_request(?,?)}");
            stmt.setInt(++index, request.getRequest_id());
            stmt.setString(++index, request.getStatus());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
			System.out.println("An error ocurrend when communicating with the database.");
            log.error(e.getMessage());
			log.error("SQL State: " + e.getSQLState());
			log.error("Error Code: " + e.getErrorCode());
        }
		return false;
	}

	@Override
	public boolean modify_user(ERS_User user) {
		int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()){
			//Create a CallableStatement object to call the procedure modify_user() and pass
			//the arguments which are in the Request object
			CallableStatement stmt = conn.prepareCall("{CALL modify_user(?,?,?,?,?)}");
			stmt.setString(++index, user.getFirstName());
			stmt.setString(++index, user.getLastName());
			stmt.setString(++index, user.getEmail());
			stmt.setString(++index, user.getPasswd());
			stmt.setInt(++index, user.getUser_id());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
			System.out.println("An error ocurred when communicating with the database.");
            log.error(e.getMessage());
			log.error("SQL State: " + e.getSQLState());
			log.error("Error Code: " + e.getErrorCode());
        }
		return false;
	}

	@Override
	public List<Request> emp_view_certain_requests(ERS_User user, String status) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()){
			//Create a PreparedStatement object to get a result set that should
			//contain the requests depending on the 'status' provided by the employee
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Request WHERE requester = ? AND status = ?");
			stmt.setInt(++index, user.getUser_id());
			stmt.setString(++index, status);

			ResultSet rs = stmt.executeQuery();
			index = -1;
			List<Request> requestList = new ArrayList<>();
			while(rs.next()){
				requestList.add(++index, new Request(rs.getInt("request_id"), rs.getInt("requester"), 
					rs.getInt("reviewer"), rs.getDouble("req_amount"), rs.getString("purpose"), 
					rs.getString("status"), rs.getDate("request_date"), rs.getDate("review_date")));
			}
			return requestList;
		} catch (SQLException e){
			System.out.println("An error ocurred when communicating with the database.");
            log.error(e.getMessage());
			log.error("SQL State: " + e.getSQLState());
			log.error("Error Code: " + e.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Request> man_view_all_requests() {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()){
			//Create a PreparedStatement object to get a result set that should
			//contain all the requests by all the employees.
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Request");

			ResultSet rs = stmt.executeQuery();
			index = -1;
			List<Request> requestList = new ArrayList<>();
			while(rs.next()){
				requestList.add(++index, new Request(rs.getInt("request_id"), rs.getInt("requester"), 
					rs.getInt("reviewer"), rs.getDouble("req_amount"), rs.getString("purpose"), 
					rs.getString("status"), rs.getDate("request_date"), rs.getDate("review_date")));
			}
			return requestList;
		} catch (SQLException e){
			System.out.println("An error ocurred when communicating with the database.");
            log.error(e.getMessage());
			log.error("SQL State: " + e.getSQLState());
			log.error("Error Code: " + e.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Request> man_view_certain_requests(String status) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()){
			//Create a PreparedStatement object to get a result set that should
			//contain the requests depending on the 'status' provided by the manager
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Request WHERE status = ?");
			stmt.setString(++index, status);

			ResultSet rs = stmt.executeQuery();
			index = -1;
			List<Request> requestList = new ArrayList<>();
			while(rs.next()){
				requestList.add(++index, new Request(rs.getInt("request_id"), rs.getInt("requester"), 
					rs.getInt("reviewer"), rs.getDouble("req_amount"), rs.getString("purpose"), 
					rs.getString("status"), rs.getDate("request_date"), rs.getDate("review_date")));
			}
			return requestList;
		} catch (SQLException e){
			System.out.println("An error ocurred when communicating with the database.");
            log.error(e.getMessage());
			log.error("SQL State: " + e.getSQLState());
			log.error("Error Code: " + e.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Request> man_view_emp_requests(int requester) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()){
			//Create a PreparedStatement object to get a result set that should
			//contain the requests depending on the user_id provided by the manager
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Request WHERE requester = ?");
			stmt.setInt(++index, requester);

			ResultSet rs = stmt.executeQuery();
			index = -1;
			List<Request> requestList = new ArrayList<>();
			while(rs.next()){
				requestList.add(++index, new Request(rs.getInt("request_id"), rs.getInt("requester"), 
					rs.getInt("reviewer"), rs.getDouble("req_amount"), rs.getString("purpose"), 
					rs.getString("status"), rs.getDate("request_date"), rs.getDate("review_date")));
			}
			return requestList;
		} catch (SQLException e){
			System.out.println("An error ocurred when communicating with the database.");
            log.error(e.getMessage());
			log.error("SQL State: " + e.getSQLState());
			log.error("Error Code: " + e.getErrorCode());
		}
		return null;
	}

}

