package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.revature.model.Reimbursment;
import com.revature.util.ConnectionUtil;

public class ReimbursmentDAOImpl implements ReimbursmentDAO 
{

	@Override
	public boolean insertRecord(Reimbursment rec) 
	{
		int index = 0;
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		try (Connection conn = ConnectionUtil.getConnection()) 
		{
			CallableStatement stmt = conn.prepareCall("{CALL insert_reimbursment(?, ?, ?, ?,?)}");
			stmt.setString(++index, rec.getEmail());
			stmt.setString(++index, "PENDING");
			stmt.setDouble(++index, rec.getAmount());
			stmt.setString(++index, rec.getPurpose());
			stmt.setTimestamp(++index, ts);
			return stmt.executeUpdate() > 0;
		}
		catch (SQLException sqle)
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	
	public Reimbursment getRecord(int id)
	{
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Reimbursement  WHERE request_id = ?");
			stmt.setInt(++index, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				return new Reimbursment(rs.getString("em_email"), rs.getString("reviewed_by"),rs.getInt("request_id"), 
						rs.getString("status"),rs.getDouble("amount"),rs.getString("purpose"),rs.getTimestamp("request_date"),
						rs.getTimestamp("review_date"));
			}
		} 
		catch (SQLException sqle) 
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}
	
	
	@Override
	public List<Reimbursment> getAllMyPending(String username)
	{
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection())
		{
			List<Reimbursment> records = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Reimbursement  WHERE status = 'PENDING'AND em_email = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				records.add(new Reimbursment(rs.getString("em_email"), rs.getString("reviewed_by"),rs.getInt("request_id"), 
						rs.getString("status"),rs.getDouble("amount"),rs.getString("purpose"),rs.getTimestamp("request_date"),
						rs.getTimestamp("review_date")));
			}
			return records;
		} 
		catch (SQLException sqle) 
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	
	
	
	@Override
	public List<Reimbursment> getAllMyApproved(String username)
	{
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection())
		{
			List<Reimbursment> records = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("select * from Reimbursement where status = 'APPROVED' and EM_EMAIL = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				records.add(new Reimbursment(rs.getString("em_email"), rs.getString("reviewed_by"),rs.getInt("request_id"), 
						rs.getString("status"),rs.getDouble("amount"),rs.getString("purpose"),rs.getTimestamp("request_date"),
						rs.getTimestamp("review_date")));
			}
			return records;
		} 
		catch (SQLException sqle) 
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Reimbursment> getAllEmployeeRecords(String username)
	{
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection())
		{
			List<Reimbursment> records = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Reimbursement  WHERE em_email = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				records.add(new Reimbursment(rs.getString("em_email"), rs.getString("reviewed_by"),rs.getInt("request_id"), 
						rs.getString("status"),rs.getDouble("amount"),rs.getString("purpose"),rs.getTimestamp("request_date"),
						rs.getTimestamp("review_date")));
			}
			return records;
		} 
		catch (SQLException sqle) 
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Reimbursment> getAllPending() 
	{
		try (Connection conn = ConnectionUtil.getConnection())
		{
			List<Reimbursment> records = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Reimbursement  where status = 'PENDING'");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				records.add(new Reimbursment(rs.getString("em_email"), rs.getString("reviewed_by"),rs.getInt("request_id"), 
						rs.getString("status"),rs.getDouble("amount"),rs.getString("purpose"),rs.getTimestamp("request_date"),
						rs.getTimestamp("review_date")));
			}
			return records;
		} 
		catch (SQLException sqle) 
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Reimbursment> getAllRecords() 
	{
		try (Connection conn = ConnectionUtil.getConnection())
		{
		List<Reimbursment> records = new ArrayList<>();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Reimbursement ");
		ResultSet rs = stmt.executeQuery();
		while (rs.next())
		{
			records.add(new Reimbursment(rs.getString("em_email"), rs.getString("reviewed_by"),rs.getInt("request_id"), 
					rs.getString("status"),rs.getDouble("amount"),rs.getString("purpose"),rs.getTimestamp("request_date"),
					rs.getTimestamp("review_date")));
		}
		return records;
	} 
	catch (SQLException sqle) 
	{
		System.err.println(sqle.getMessage());
		System.err.println("SQL State: " + sqle.getSQLState());
		System.err.println("Error Code: " + sqle.getErrorCode());
	}
	return null;
	}

	@Override
	public boolean updateStatus(Reimbursment rec, String manger, String status) 
	{
		int index = 0;
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		try (Connection conn = ConnectionUtil.getConnection()) 
		{
			CallableStatement stmt = conn.prepareCall("{CALL update_status(?,?,?,?)}");
			System.out.println(rec.getRequestID(rec.getEmail()));
			stmt.setInt(++index, rec.getRequestID(rec.getEmail()));
			stmt.setString(++index, manger );
			stmt.setString(++index, status);
			stmt.setTimestamp(++index, ts );
			return stmt.executeUpdate() > 0;
		} 
		catch (SQLException sqle) 
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

}
