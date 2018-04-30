package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

//import org.apache.log4j.logger;
import connection.ConnectionWithProperties;

public class RequestEmployeeDaoImpl implements EmployeeDao, RequestDao{
	private static RequestEmployeeDaoImpl instance;
	private RequestEmployeeDaoImpl() {}
	public static RequestEmployeeDaoImpl getInstance() {
		if(instance ==null) {
			instance = new RequestEmployeeDaoImpl();
		}
		return instance;
	}
	final static Logger log = Logger.getRootLogger();
	public boolean insertRequest(Request req) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			CallableStatement stmt = conn.prepareCall("CALL insert_request(?,?,?)");
			stmt.setInt(1, req.getAmmount());
			stmt.setInt(2, req.getRequester());
			stmt.setString(3, req.getPurpose());
			log.info("Creating Request in database");
			return stmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			log.error("SQL Exception thrown, SQL State: " + e.getSQLState());
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	public List<Request> getRequest(int id) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			List<Request> Request = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT request_id, ammount, requester, reviewed_by, status, purpose, image, request_date, review_date FROM Request WHERE requester = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Request temp= new Request(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getBlob(7),rs.getDate(8),rs.getDate(9));
				Request.add(temp);
			}
			return Request;
		} catch (SQLException e) {
			log.error("SQL Exception thrown, SQL State: " + e.getSQLState());
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}
	
	public List<Request> getResolvedRequests(){
		try(Connection conn = ConnectionWithProperties.getConnection()){
			List<Request> Request = new ArrayList<>();
			
			PreparedStatement stmt = conn.prepareStatement("SELECT request_id, ammount, requester, reviewed_by, status, purpose, image, request_date, review_date FROM Request WHERE status=? OR status=?");
			stmt.setString(1, "Approve");
			stmt.setString(2, "Deny");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Request temp= new Request(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getBlob(7),rs.getDate(8),rs.getDate(9));
				Request.add(temp);
			}
			return Request;
		} catch (SQLException e) {
			log.error("SQL Exception thrown, SQL State: " + e.getSQLState());
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}
	
	public List<Request> getUnresolvedRequests(){
		try(Connection conn = ConnectionWithProperties.getConnection()){
			List<Request> Request = new ArrayList<>();
			
			PreparedStatement stmt = conn.prepareStatement("SELECT request_id, ammount, requester, reviewed_by, status, purpose, image, request_date, review_date FROM Request Where status=?");
			stmt.setString(1, "Pending");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Request temp= new Request(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getBlob(7),rs.getDate(8),rs.getDate(9));
				Request.add(temp);
			}
			return Request;
		} catch (SQLException e) {
			log.error("SQL Exception thrown, SQL State: " + e.getSQLState());
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}

	public List<Request> getAllRequests() {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			List<Request> Request = new ArrayList<>();
			
			PreparedStatement stmt = conn.prepareStatement("SELECT request_id, ammount, requester, reviewed_by, status, purpose, image, request_date, review_date FROM Request");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Request temp= new Request(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getBlob(7),rs.getDate(8),rs.getDate(9));
				Request.add(temp);
			}
			return Request;
		} catch (SQLException e) {
			log.error("SQL Exception thrown, SQL State: " + e.getSQLState());
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}

	public boolean approveRequest(int reqID, int id) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt = conn.prepareCall("UPDATE request SET status=?, review_date=?, reviewed_by=? WHERE request_id=?");
			stmt.setString(1,"Approve");
			stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			stmt.setInt(3, id);
			stmt.setInt(4,reqID);
			log.info("Approving a request in the database");
			return stmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			log.error("SQL Exception thrown, SQL State: " + e.getSQLState());
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}
	
	public boolean denyRequest(int reqID, int id) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt = conn.prepareCall("UPDATE request SET status=?, review_date=?, reviewed_by=? WHERE request_id=?");
			stmt.setString(1,"Deny");
			stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			stmt.setInt(3, id);
			stmt.setInt(4,reqID);
			log.info("Approving a request in the database");
			return stmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			log.error("SQL Exception thrown, SQL State: " + e.getSQLState());
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}
	
	public boolean updateRequest(Request req) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt = conn.prepareCall("CALL update_request(?,?,?,?,?,?)");
			stmt.setInt(1,req.getRequestId());
			stmt.setInt(2, req.getRequester());
			stmt.setInt(3, req.getReviewedBy());
			stmt.setString(4, req.getStatus());
			stmt.setDate(5, req.getReviewDate());
			stmt.setBlob(6, req.getImage());
			log.info("Updating a Request in the database");
			return stmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			log.error("SQL Exception thrown, SQL State: " + e.getSQLState());
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	public boolean insertEmployee(Employee Employee) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			CallableStatement stmt = conn.prepareCall("CALL insert_employee(?,?,?,?,?,?)");
			stmt.setString(1, Employee.getFirstName());
			stmt.setString(2, Employee.getLastName());
			stmt.setString(3, Employee.getUsername());
			stmt.setString(4, Employee.getPassword());
			stmt.setString(5, Employee.getEmail());
			stmt.setString(6, Employee.getEmpRole());
			log.info("Creating a new Employee in database");
			return stmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			log.error("SQL Exception thrown, SQL State: " + e.getSQLState());
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	public Employee getEmployeeByID(int id) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT emp_id, first_name, last_name, username, password, email, emp_role FROM Employee WHERE emp_id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Employee temp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				return temp;
			}
		} catch (SQLException e) {
			log.error("SQL Exception thrown, SQL State: " + e.getSQLState());
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}
	
	public Employee getEmployeeByUsername(String str) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT emp_id, first_name, last_name, username, password, email, emp_role FROM Employee WHERE username = ?");
			stmt.setString(1, str);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Employee temp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				return temp;
			}
		} catch (SQLException e) {
			log.error("SQL Exception thrown, SQL State: " + e.getSQLState());
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}
	
	public Employee getEmployeeByEmail(String str) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT emp_id, first_name, last_name, username, password, email, emp_role FROM Employee WHERE email = ?");
			stmt.setString(1, str);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Employee temp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				return temp;
			}
		} catch (SQLException e) {
			log.error("SQL Exception thrown, SQL State: " + e.getSQLState());
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}

	public List<Employee> getAllEmployees() {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			List<Employee> Employee= new ArrayList<>();
			
			PreparedStatement stmt = conn.prepareStatement("SELECT emp_id, first_name, last_name, username, password, email, emp_role FROM employee");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Employee temp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				Employee.add(temp);
			}
			return Employee;
		} catch (SQLException e) {
			log.error("SQL Exception thrown, SQL State: " + e.getSQLState());
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return null;
	}

	public boolean updateEmployee(Employee Employee) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			CallableStatement stmt = conn.prepareCall("CALL update_employee_by_id(?,?,?,?,?,?,?)");
			stmt.setInt(1, Employee.getEmpId());
			stmt.setString(2, Employee.getFirstName());
			stmt.setString(3, Employee.getLastName());
			stmt.setString(4, Employee.getUsername());
			stmt.setString(5, Employee.getPassword());
			stmt.setString(6, Employee.getEmail());
			stmt.setString(7, Employee.getEmpRole());
			log.info("Updating an Employee in the database");
			return stmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			log.error("SQL Exception thrown, SQL State: " + e.getSQLState());
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	public boolean deleteEmployeeByID(int a) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			CallableStatement stmt= conn.prepareCall("CALL delete_employee_by_id(?)");
			stmt.setInt(1, a);
			log.info("Deleting an Employee in database");
			return stmt.executeUpdate()>0;
		} catch (SQLException e) {
			log.error("SQL Exception thrown, SQL State: " + e.getSQLState());
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}
	
	public boolean deleteEmployeeByUsername(String str) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			CallableStatement stmt= conn.prepareCall("CALL delete_employee_by_username(?)");
			stmt.setString(1, str);
			log.info("Deleting an Employee in database");
			return stmt.executeUpdate()>0;
		} catch (SQLException e) {
			log.error("SQL Exception thrown, SQL State: " + e.getSQLState());
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}

	public boolean deleteEmployeeByEmail(String str) {
		try(Connection conn = ConnectionWithProperties.getConnection()){
			CallableStatement stmt= conn.prepareCall("CALL delete_employee_by_email(?)");
			stmt.setString(1, str);
			log.info("Deleting an Employee in database");
			return stmt.executeUpdate()>0;
		} catch (SQLException e) {
			log.error("SQL Exception thrown, SQL State: " + e.getSQLState());
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
		return false;
	}
}
