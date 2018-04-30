package com.revature.dao;

import org.apache.log4j.Logger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Reimbursements;
import com.revature.model.Users;
import com.revature.util.ConnectionUtil;

public class ExpenseReimbursementDAOImple implements ExpenseReimbursementDAO {

	final static Logger logger = Logger.getLogger(ExpenseReimbursementDAOImple.class);

	@Override
	public boolean insert_users(Users users_id) {

		int in = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {

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
		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO reimbursement_request VALUES (?,?,?,?,?,?,?,?)");
			stmt.setInt(++in, reimb_request.getReimb_id());

			stmt.setDouble(++in, reimb_request.getReimb_amount());
			stmt.setTimestamp(++in, reimb_request.getReimb_request());
			stmt.setTimestamp(++in, reimb_request.getReimb_review());
			stmt.setString(++in, reimb_request.getReimb_purpose());
			stmt.setString(++in, reimb_request.getReimb_purpose());
			stmt.setInt(++in, reimb_request.getReimb_requester());
			stmt.setInt(++in, reimb_request.getReimb_reviewer());
			stmt.setString(++in, reimb_request.getReimb_status());

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
		try (Connection conn = ConnectionUtil.getConnection()) {

			CallableStatement stmt = conn.prepareCall("{CALL modify_requests(?,?)}");
			stmt.setInt(++in, reimb_request.getReimb_id());
			stmt.setString(++in, reimb_request.getReimb_status());

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
		try (Connection conn = ConnectionUtil.getConnection()) {

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
	public List<Reimbursements> emp_view_pending_requests(Users users_id, String reimb_status) {

		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(
					"SELECT * FROM reimbursement_request WHERE reimb_requester = ? AND reimb_status = ?");
			stmt.setInt(++index, users_id.getUsers_id());
			stmt.setString(++index, reimb_status);

			ResultSet rs = stmt.executeQuery();
			index = -1;
			List<Reimbursements> requestList = new ArrayList<>();
			while (rs.next()) {
				requestList.add(++index,
						new Reimbursements(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"),
								rs.getTimestamp("reimb_request"), rs.getTimestamp("reimb_review"),
								rs.getString("reimb_purpose"), rs.getInt("reimb_requester"),
								rs.getInt("reimb_reviewer"), rs.getString("reimb_status")));
			}
			return requestList;
		} catch (SQLException e) {
			System.out.println("The Database could not be reached at this moment.");
			logger.error(e.getMessage());
			logger.error("SQL State: " + e.getSQLState());
			logger.error("Error Code: " + e.getErrorCode());
		}

		return null;
	}

	@Override
	public List<Reimbursements> emp_view_resolved_requests(Users users_id, String reimb_status) {
		return null;
	}

	@Override
	public List<Reimbursements> man_view_all_requests() {

		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement_request");

			ResultSet rs = stmt.executeQuery();
			index = -1;
			List<Reimbursements> requestList = new ArrayList<>();
			while (rs.next()) {
				requestList.add(++index,
						new Reimbursements(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"),
								rs.getTimestamp("reimb_request"), rs.getTimestamp("reimb_review"),
								rs.getString("reimb_purpose"), rs.getInt("reimb_requester"),
								rs.getInt("reimb_reviewer"), rs.getString("reimb_status")));
			}
			return requestList;
		} catch (SQLException e) {
			System.out.println("The Database could not be reached at this moment.");
			logger.error(e.getMessage());
			logger.error("SQL State: " + e.getSQLState());
			logger.error("Error Code: " + e.getErrorCode());
		}

		return null;
	}

	@Override
	public List<Reimbursements> man_view_pending_requests(String status) {

		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM reimbursement_request WHERE reimb_status = ?");
			stmt.setString(++index, status);

			ResultSet rs = stmt.executeQuery();
			index = -1;
			List<Reimbursements> requestList = new ArrayList<>();
			while (rs.next()) {
				requestList.add(++index,
						new Reimbursements(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"),
								rs.getTimestamp("reimb_request"), rs.getTimestamp("reimb_review"),
								rs.getString("reimb_purpose"), rs.getInt("reimb_requester"),
								rs.getInt("reimb_reviewer"), rs.getString("reimb_status")));
			}
			return requestList;
		} catch (SQLException e) {
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
		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM reimbursement_request WHERE reimb_requester = ?");
			stmt.setInt(++index, reimb_requester);

			ResultSet rs = stmt.executeQuery();
			index = -1;
			List<Reimbursements> requestList = new ArrayList<>();
			while (rs.next()) {
				requestList.add(++index,
						new Reimbursements(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"),
								rs.getTimestamp("reimb_request"), rs.getTimestamp("reimb_review"),
								rs.getString("reimb_purpose"), rs.getInt("reimb_requester"),
								rs.getInt("reimb_reviewer"), rs.getString("reimb_status")));
			}
			return requestList;
		} catch (SQLException e) {
			System.out.println("The Database could not be reached at this moment.");
			logger.error(e.getMessage());
			logger.error("SQL State: " + e.getSQLState());
			logger.error("Error Code: " + e.getErrorCode());
		}

		return null;
	}

	@Override
	public Users getUser(Users users_id) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ers_users WHERE email = ? AND password = ?");
			stmt.setString(++index, users_id.getEmail());
			stmt.setString(++index, users_id.getPassword());

			ResultSet rs = stmt.executeQuery();

			if (rs.next() == false) {
				logger.error("Incorrect credentials, login failed.");
				return null;
			} else
				logger.info("Successfully retrieved the user with the provided credentials.");

			return new Users(rs.getInt("users_id"), rs.getString("username"), rs.getString("password"),
					rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"),
					rs.getInt("isManager"));

		} catch (SQLException e) {
			System.out.println("The Database could not be reached at this moment.");
			logger.error(e.getMessage());
			logger.error("SQL State: " + e.getSQLState());
			logger.error("Error Code: " + e.getErrorCode());
		}

		return null;
	}

	public static void main(String[] args) {
		Reimbursements reimb_object = new Reimbursements(0, 0, new Timestamp(0), new Timestamp(0), (""), 1234, 0,
				("PENDING"));
		ExpenseReimbursementDAOImple dao_object = new ExpenseReimbursementDAOImple();
		// dao_object.insert_request(reimb_object);

		Reimbursements updateTest = new Reimbursements(71, 20, new Timestamp(0), new Timestamp(0), (""), 1234, 1234,
				("DENIED"));

		// dao_object.man_update_requests(updateTest);

		List<Reimbursements> testList = dao_object.get_reimbursements_by_email("test");

		for (Reimbursements request : testList) {
			System.out.println(request.toString());
		}
	}

	@Override
	public boolean insert_request(Reimbursements r) {
		int in = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO reimbursement_request (reimb_id, reimb_amount, reimb_requester, reimb_purpose, reimb_request) VALUES (?,?,?,?,?)");
			stmt.setInt(++in, 0);

			stmt.setDouble(++in, r.getReimb_amount());
			stmt.setInt(++in, r.getReimb_requester());
			stmt.setString(++in, r.getReimb_purpose());
			stmt.setTimestamp(++in, r.getReimb_request());

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
	public boolean man_update_requests(Reimbursements update) {
		int in = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE reimbursement_request SET reimb_status = ?, reimb_reviewer = ? WHERE reimb_id = ?");

			stmt.setString(++in, update.getReimb_status());
			stmt.setInt(++in, update.getReimb_reviewer());
			stmt.setInt(++in, update.getReimb_id());
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
	public List<Reimbursements> get_reimbursements_by_email(String email) {
		int in = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement(
					"select * from reimbursement_request rr, ers_users u where u.users_id=rr.reimb_requester AND u.email like ?");

			stmt.setString(++in, "%" + email + "%");

			ResultSet rs = stmt.executeQuery();
			int index = -1;
			List<Reimbursements> requestList = new ArrayList<>();
			while (rs.next()) {
				requestList.add(++index,
						new Reimbursements(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"),
								rs.getTimestamp("reimb_request"), rs.getTimestamp("reimb_review"),
								rs.getString("reimb_purpose"), rs.getInt("reimb_requester"),
								rs.getInt("reimb_reviewer"), rs.getString("reimb_status")));
			}
			return requestList;
		} catch (SQLException e) {
			System.out.println("The Database could not be reached at this moment.");
			logger.error(e.getMessage());
			logger.error("SQL State: " + e.getSQLState());
			logger.error("Error Code: " + e.getErrorCode());
		}

		return null;
	}

}
