package main.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import main.Model.Employee;
import main.Model.Manager;
import main.Model.Reimbursement;
import main.util.ConnectionWithPropertiesUtil;

public class DaoImpl implements EmployeeDao, ManagerDao, ReimbursementDao
{
	private static DaoImpl instance;
	final static Logger log = Logger.getLogger(DaoImpl.class);
	
	public static DaoImpl getInstance()
	{
		if(instance == null)
		{
			instance = new DaoImpl();
		}
		return instance;
	}

	//REIMBURSEMENT DAO STUFF
	@Override
	public boolean insertReimbursement(Reimbursement r) 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			CallableStatement stmt = conn.prepareCall("{CALL insert_reimb( ?, ?, ?)}");
			stmt.setDouble(1, r.getAmount());
			stmt.setString(2, r.getEmail());
			stmt.setString(3, r.getPurpose());
			
			return stmt.executeUpdate() > 0;
		}
		catch (SQLException sqle) 
		{
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public Reimbursement getReimbursement(int id) 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimb WHERE reimb_id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
			{
				return new Reimbursement(rs.getInt("reimb_id"), rs.getString("email"), rs.getString("status"),
						rs.getDouble("amount"), rs.getString("reviewer"), rs.getString("purpose"),
						rs.getDate("request_date"), rs.getDate("review_date"));
			}
		}
		catch (SQLException sqle) 
		{
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public boolean updateReimbursement(Reimbursement r) 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("UPDATE reimb SET status = ?, reviewer = ?, review_date = ? WHERE reimb_id = ?");
			stmt.setString(1, r.getStatus());
			stmt.setString(2, r.getManager());
			stmt.setDate(3, r.getApprovedDate());
			stmt.setInt(4, r.getID());
			
			return stmt.executeUpdate() > 0;
		}
		catch (SQLException sqle) 
		{
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public List<Reimbursement> getAllReimbursements() 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			List<Reimbursement> reimbursements = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimb");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				reimbursements.add(new Reimbursement(rs.getInt("reimb_id"), rs.getString("email"),
						rs.getString("status"), rs.getDouble("amount"), rs.getString("reviewer"),
						rs.getString("purpose"), rs.getDate("request_date"), rs.getDate("review_date")));
			}
			
			return reimbursements;
		}
		catch (SQLException sqle) 
		{
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Reimbursement> getAllPending() 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			List<Reimbursement> reimbursements = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimb WHERE status = 'Pending'");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				reimbursements.add(new Reimbursement(rs.getInt("reimb_id"), rs.getString("email"),
						rs.getString("status"), rs.getDouble("amount"), rs.getString("reviewer"),
						rs.getString("purpose"), rs.getDate("request_date"), rs.getDate("review_date")));
			}
			
			return reimbursements;
		}
		catch (SQLException sqle) 
		{
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Reimbursement> getAllResolved() 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			List<Reimbursement> reimbursements = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimb WHERE status = 'Approved' OR status = 'Denied'");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				reimbursements.add(new Reimbursement(rs.getInt("reimb_id"), rs.getString("email"),
						rs.getString("status"), rs.getDouble("amount"), rs.getString("reviewer"),
						rs.getString("purpose"), rs.getDate("request_date"), rs.getDate("review_date")));
			}
			
			return reimbursements;
		}
		catch (SQLException sqle) 
		{
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}
	
	public List<Reimbursement> getAllForE(Employee e) 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			List<Reimbursement> reimbursements = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimb WHERE email = ?");
			stmt.setString(1, e.getEmail());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				reimbursements.add(new Reimbursement(rs.getInt("reimb_id"), rs.getString("email"),
						rs.getString("status"), rs.getDouble("amount"), rs.getString("reviewer"),
						rs.getString("purpose"), rs.getDate("request_date"), rs.getDate("review_date")));
			}
			
			return reimbursements;
		}
		catch (SQLException sqle) 
		{
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	
	@Override
	public List<Reimbursement> getAllPendingForE(Employee e) 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			List<Reimbursement> reimbursements = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimb WHERE status = 'Pending' AND email = ?");
			stmt.setString(1, e.getEmail());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				reimbursements.add(new Reimbursement(rs.getInt("reimb_id"), rs.getString("email"),
						rs.getString("status"), rs.getDouble("amount"), rs.getString("reviewer"),
						rs.getString("purpose"), rs.getDate("request_date"), rs.getDate("review_date")));
			}
			
			return reimbursements;
		}
		catch (SQLException sqle) 
		{
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Reimbursement> getAllResolvedForE(Employee e) 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			List<Reimbursement> reimbursements = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimb WHERE (status = 'Approved' OR status = 'Denied') AND email = ?");
			stmt.setString(1, e.getEmail());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				reimbursements.add(new Reimbursement(rs.getInt("reimb_id"), rs.getString("email"),
						rs.getString("status"), rs.getDouble("amount"), rs.getString("reviewer"),
						rs.getString("purpose"), rs.getDate("request_date"), rs.getDate("review_date")));
			}
			
			return reimbursements;
		}
		catch (SQLException sqle) 
		{
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}
	
	//MANAGER DAO STUFF

	@Override
	public boolean insertManager(Manager m) 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO manager (email, pass, mananame) VALUES (?, ?, ?)");
			stmt.setString(1, m.getEmail());
			stmt.setString(1, m.getPassword());
			stmt.setString(1, m.getName());
			
			if (!stmt.execute())//returns number of rows modified
				return stmt.getUpdateCount() > 0;
		}
		catch (SQLException sqle) 
		{
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public Manager getManager(String email) 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM manager WHERE email = ?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
			{
				return new Manager(rs.getString("email"), rs.getString("pass"), rs.getString("mananame"));
			}
		}
		catch (SQLException sqle) 
		{
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public boolean updateManager(Manager m) 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("UPDATE manager SET pass = ?, mananame = ? WHERE email = ?");
			stmt.setString(1, m.getPassword());
			stmt.setString(2, m.getName());
			stmt.setString(3, m.getEmail());
			
			return stmt.executeUpdate() > 0;
		}
		catch (SQLException sqle) 
		{
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}
	
	//EMPLOYEE DAO STUFF

	@Override
	public boolean insertEmployee(Employee e) 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO employee (email, pass, empname) VALUES (?, ?, ?)");
			stmt.setString(1, e.getEmail());
			stmt.setString(1, e.getPassword());
			stmt.setString(1, e.getName());
			
			if (!stmt.execute())//returns number of rows modified
				return stmt.getUpdateCount() > 0;
		}
		catch (SQLException sqle) 
		{
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public Employee getEmployee(String email) 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee WHERE email = ?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
			{
				return new Employee(rs.getString("email"), rs.getString("pass"), rs.getString("empname"));
			}
		}
		catch (SQLException sqle) 
		{
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public boolean updateEmployee(Employee e) 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("UPDATE employee SET pass = ?, empname = ? WHERE email = ?");
			stmt.setString(1, e.getPassword());
			stmt.setString(2, e.getName());
			stmt.setString(3, e.getEmail());
			
			return stmt.executeUpdate() > 0;
		}
		catch (SQLException sqle) 
		{
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() 
	{
		try(Connection conn = ConnectionWithPropertiesUtil.getConnection())
		{
			List<Employee> employees = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				employees.add(new Employee(rs.getString("email"), rs.getString("pass"), rs.getString("empname")));
			}
			
			return employees;
		}
		catch (SQLException sqle) 
		{
			log.error(sqle.getMessage());
			log.error("SQL State: " + sqle.getSQLState());
			log.error("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}
}
