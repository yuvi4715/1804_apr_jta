package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.model.Request;
import com.revature.util.ConnectionUtil;

public class ERSDaoImp implements ERSDao {

	@Override
	public boolean findEmployee(String username, String password) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM employee WHERE employee_username = ? AND employee_password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();
			return rs.next();

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}

		return false;
	}

	@Override
	public Employee employeeInfo(String username) {
		Employee emp = new Employee();
		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT employee_id ,employee_firstname,"
					+ " employee_lastname, employee_email, employee_password FROM employee WHERE employee_username = ?");// change
																															// to
																															// what
			// table
			// contains
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			String fn = null, ln = null, email = null, password = null;
			int id = 0;

			if (rs.next()) {

				id = rs.getInt("employee_id");
				fn = rs.getString("employee_firstname");
				ln = rs.getString("employee_lastname");
				email = rs.getString("employee_email");
				password = rs.getString("employee_password");
			}
			emp = new Employee(id, fn, ln, email, username, password);
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return emp;
	}

	@Override
	public boolean submitRequest(String empEmail, Double amount, String purpose) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL insert_request" + "(?, ?, ?, ?, ?)}");
			stmt.setDouble(++index, amount);
			stmt.setString(++index, empEmail);
			stmt.setString(++index, null);
			stmt.setString(++index, "PENDING");
			stmt.setString(++index, purpose);
			return stmt.executeUpdate() > 0;

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	// same as view resolved except look for pending keyword
	@Override
	public List<Request> viewPending(String email) {
		int index = 0;
		List<Request> requestList = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE requester = ? AND status = ?");
			stmt.setString(++index, email);
			stmt.setString(++index, "PENDING");
			ResultSet rs = stmt.executeQuery();
			String status = null, purpose = null, requester = null, reviewed_by = null;
			int request_id = 0;
			double amount = 0;

			while (rs.next()) {
				request_id = rs.getInt("request_id");
				amount = rs.getDouble("request_amount");
				requester = rs.getString("requester");
				reviewed_by = rs.getString("reviewed_by");
				status = rs.getString("status");
				purpose = rs.getString("purpose");
				Request req = new Request(request_id, amount, requester, reviewed_by, status, purpose);
				requestList.add(req);
			}

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return requestList;
	}

	// problem with null reviewed by
	// check for resolved keyword
	@Override
	public List<Request> viewResolved(String email) {
		int index = 0;
		List<Request> requestList = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM request WHERE requester = ? AND ( status = ? OR status = ?)");
			stmt.setString(++index, email);
			stmt.setString(++index, "APPROVED");
			stmt.setString(++index, "DENIED");
			ResultSet rs = stmt.executeQuery();
			String status = null, purpose = null, requester = null, reviewed_by = null;
			int request_id = 0;
			double amount = 0;

			while (rs.next()) {
				request_id = rs.getInt("request_id");
				amount = rs.getDouble("request_amount");
				requester = rs.getString("requester");
				reviewed_by = rs.getString("reviewed_by");
				status = rs.getString("status");
				purpose = rs.getString("purpose");
				Request req = new Request(request_id, amount, requester, reviewed_by, status, purpose);
				requestList.add(req);
			}

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return requestList;
	}

	@Override
	public boolean insertEmployee(Employee emp) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL insert_employee" + "(?, ?, ?, ?, ?");
			stmt.setString(++index, emp.getFirst_name());
			stmt.setString(++index, emp.getLast_name());
			stmt.setString(++index, emp.getEmail());
			stmt.setString(++index, emp.getUsername());
			stmt.setString(++index, emp.getPassword());
			return stmt.executeUpdate() > 0;

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL update_employee" + "(?, ?, ?, ?, ?)}");
			stmt.setString(++index, emp.getFirst_name());
			stmt.setString(++index, emp.getLast_name());
			stmt.setString(++index, emp.getEmail());
			stmt.setString(++index, emp.getUsername());
			stmt.setString(++index, emp.getPassword());
			return stmt.executeUpdate() > 0;

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean findManager(String username, String password) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			// search if manager with username and password exists
			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM manager WHERE manager_username = ? AND manager_password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();
			return rs.next();// there is such a employee, make into object

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}

		return false;
	}

	@Override
	public Manager managerInfo(String username) {
		Manager mgr = new Manager();
		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT manager_id ,manager_firstname,"
					+ " manager_lastname, manager_email, manager_password FROM manager WHERE manager_username = ?");// change
																													// to
																													// what
			// table
			// contains
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			String fn = null, ln = null, email = null, password = null;
			int id = 0;

			if (rs.next()) {

				id = rs.getInt("manager_id");
				fn = rs.getString("manager_firstname");
				ln = rs.getString("manager_lastname");
				email = rs.getString("manager_email");
				password = rs.getString("manager_password");
			}
			mgr = new Manager(id, fn, ln, email, username, password);
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return mgr;
	}

	@Override
	public boolean handleRequest(Request req, String approvalStatus, String mgrEmail) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL update_request" + "(?, ?, ?)}");
			System.out.println("handleRequest: " + req.getRequest_id() + " " + mgrEmail + " " + approvalStatus);
			stmt.setInt(++index, req.getRequest_id());
			stmt.setString(++index, mgrEmail);
			stmt.setString(++index, approvalStatus);
			return stmt.executeUpdate() > 0;

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public List<Request> viewAllPending() {
		int index = 0;
		List<Request> pendingList = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE status = ?");
			stmt.setString(++index, "PENDING");
			ResultSet rs = stmt.executeQuery();
			String status = null, purpose = null, requester = null, reviewed_by = null;
			int request_id = 0;
			double amount = 0;

			while (rs.next()) {
				request_id = rs.getInt("request_id");
				amount = rs.getDouble("request_amount");
				requester = rs.getString("requester");
				reviewed_by = rs.getString("reviewed_by");
				status = rs.getString("status");
				purpose = rs.getString("purpose");
				Request req = new Request(request_id, amount, requester, reviewed_by, status, purpose);
				pendingList.add(req);
			}

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return pendingList;
	}

	@Override
	public String viewReceiptImg(Request req) {
		// TODO Auto-generated method stub
		return null;
	}

	// TODO
	@Override
	public List<Request> viewAllResolved() {
		int index = 0;
		List<Request> resolvedList = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE  status = ? OR status = ?");
			stmt.setString(++index, "APPROVED");
			stmt.setString(++index, "DENIED");
			ResultSet rs = stmt.executeQuery();
			String status = null, purpose = null, requester = null, reviewed_by = null;
			int request_id = 0;
			double amount = 0;

			while (rs.next()) {
				request_id = rs.getInt("request_id");
				amount = rs.getDouble("request_amount");
				requester = rs.getString("requester");
				reviewed_by = rs.getString("reviewed_by");
				status = rs.getString("status");
				purpose = rs.getString("purpose");
				Request req = new Request(request_id, amount, requester, reviewed_by, status, purpose);
				resolvedList.add(req);
			}

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return resolvedList;
	}

	// TODO
	@Override
	public List<Employee> viewAllEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		Employee emp;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = stmt.executeQuery();
			String fn = null, ln = null, email = null, un = null, pw = null;
			int id = 0;

			while (rs.next()) {

				id = rs.getInt("employee_id");
				fn = rs.getString("employee_firstname");
				ln = rs.getString("employee_lastname");
				email = rs.getString("employee_email");
				un = rs.getString("employee_username");
				pw = rs.getString("employee_password");

				emp = new Employee(id, fn, ln, email, un, pw);
				employeeList.add(emp);
			}

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return employeeList;
	}

	@Override
	public List<Request> viewRequestsFrom(String email) {
		int index = 0;
		List<Request> empRequest = new ArrayList<>();
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE  requester = ?");
			stmt.setString(++index, email);
			ResultSet rs = stmt.executeQuery();
			String status = null, purpose = null, requester = null, reviewed_by = null;
			int request_id = 0;
			double amount = 0;

			while (rs.next()) {
				request_id = rs.getInt("request_id");
				amount = rs.getDouble("request_amount");
				requester = rs.getString("requester");
				reviewed_by = rs.getString("reviewed_by");
				status = rs.getString("status");
				purpose = rs.getString("purpose");
				Request req = new Request(request_id, amount, requester, reviewed_by, status, purpose);
				empRequest.add(req);
			}

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return empRequest;
	}

	

	@Override
	public Request getRequest(int reqID) {
		int index = 0;
		Request req = new Request(index, index, null, null, null, null);
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM request WHERE request_id = ?");
			stmt.setInt(++index, reqID);
			ResultSet rs = stmt.executeQuery();
			String status = null, purpose = null, requester = null, reviewed_by = null;
			int request_id = 0;
			double amount = 0;

			if (rs.next()) {
				request_id = rs.getInt("request_id");
				amount = rs.getDouble("request_amount");
				requester = rs.getString("requester");
				reviewed_by = rs.getString("reviewed_by");
				status = rs.getString("status");
				purpose = rs.getString("purpose");
				req = new Request(request_id, amount, requester, reviewed_by, status, purpose);

			}

		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return req;
	}

	@Override
	public boolean uploadImage(String img) {
		// TODO Auto-generated method stub
		return false;
	}

}
