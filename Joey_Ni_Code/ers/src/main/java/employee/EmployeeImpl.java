package employee;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import app.ConnectionUtil;
import dev.InvalidInputException;
import dev.Log;
import manager.Manager;
import request.Request;

public class EmployeeImpl implements EmployeeDAO {

	private static EmployeeImpl instance;
	
	private EmployeeImpl() {}//never called outside the class
	
	public static EmployeeImpl getInstance()
	{
		if(instance==null) instance = new EmployeeImpl();
		return instance;
	}
	
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}
	public int getId(String username)
	{
		try(Connection con = ConnectionUtil.getConnection())
		{	
			PreparedStatement stmt = con.prepareStatement("SELECT EID FROM EMPLOYEE WHERE USERNAME=?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery(); 
			if (rs.next()) {
				return rs.getInt(1);
			}else
				//try {
					return -1;
					//throw new InvalidInputException("USERNAME not found");
				//} catch (InvalidInputException e) {
			//		Log.userError("USERNAME not found, please register or check spelling");
			//	}
		} catch (SQLException e) {
			dev.Log.debug("Employee get ID "+e.getMessage());
		} catch (IOException e1) {
			dev.Log.debug("Employee get ID "+e1.getMessage());
		}
		return -1;
		
	}

	public Employee getEmployee(int eid) {
		
		
		try(Connection con = ConnectionUtil.getConnection())
		{	
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE EID=?");
			stmt.setInt(1, eid);
			ResultSet rs = stmt.executeQuery(); 
			if (rs.next()) {
				return new Employee(rs.getInt(1),rs.getNString(2),rs.getNString(3),rs.getNString(4),rs.getNString(5));
			}else
				try {
					throw new InvalidInputException("EID not found");
				} catch (InvalidInputException e) {
					Log.userError("EID not found, cannot find you");
				}
			
			/*
			CallableStatement cs=con.prepareCall("{call GET_EMPLOYEE(?,?)}");
			cs.setInt(1, eid);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			//cs.registerOutParameter(null, null)
		//	cs.registerOutParameter("RETVAL", java.sql.Types.REF_CURSOR);
			cs.execute();
			ResultSet rs=(ResultSet)cs.getObject(2);
			
			if (rs.next())
			{
				a=new Employee(eid, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}*/
		} catch (SQLException e) {
			dev.Log.debug("GET EMPLOYEE"+e.getMessage());
		} catch (IOException e1) {
			dev.Log.debug("GET EMPLOYEE"+e1.getMessage());
		}
		return null;
	}

	//Updates an employee record and returns the new employee
	public Employee updateEmployee(int eid, String username, String password) {
		if (instance.getEmployee(eid) != null) {
		try(Connection con = ConnectionUtil.getConnection())
		{
			PreparedStatement stmt = con.prepareStatement("UPDATE EMPLOYEE SET USERNAME=?, PASSWORD=? WHERE EID=?");
			stmt.setString(1,username);
			stmt.setString(2, password);
			stmt.setInt(3, eid);
			stmt.executeUpdate();
			return instance.getEmployee(eid);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		}else
			try {
				throw new InvalidInputException("EID not found");
			} catch (InvalidInputException e) {
				Log.userError("EID not found, cannot find you");
			}
		return null;
	}

	public List<Request> getPendingRequests(int eid) {
		List<Request> req = new ArrayList<>();
		if (instance.getEmployee(eid) != null) {
		try(Connection con = ConnectionUtil.getConnection())
		{
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM REQUEST WHERE REID=? AND STATUS=9");
			stmt.setInt(1, eid);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				req.add(new Request(rs.getInt(1),
						rs.getFloat(2),rs.getString(3),rs.getInt(4), rs.getInt(5), rs.getInt(6)));
			}
		
		} catch (SQLException e) {
			dev.Log.debug(e.getMessage());
		} catch (IOException e1) {
			dev.Log.debug(e1.getMessage());
		}
	}else try {
			throw new InvalidInputException("EID not found");
		} catch (InvalidInputException e) {
			Log.userError("EID not found, cannot submit request");
			return null;
		}
		
		return req;
		
	}

	public List<Request> getResolvedRequests(int eid) {
		List<Request> req = new ArrayList<>();
		if (instance.getEmployee(eid) != null) {
		try(Connection con = ConnectionUtil.getConnection())
		{
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM REQUEST WHERE REID=? AND STATUS=1");
			stmt.setInt(1, eid);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				req.add(new Request(rs.getInt(1),
						rs.getFloat(2),rs.getString(3),rs.getInt(4), rs.getInt(5), rs.getInt(6)));
			}
		
		} catch (SQLException e) {
			dev.Log.debug(e.getMessage());
		} catch (IOException e1) {
			dev.Log.debug(e1.getMessage());
		}
		}else try {
			throw new InvalidInputException("EID not found");
		} catch (InvalidInputException e) {
			Log.userError("EID not found, cannot submit request");
			return null;
		}
		return req;
		
	}

	public boolean submitRequest(float amount, String purpose, int eid) {

		if (instance.getEmployee(eid) != null) {
			try (Connection con = ConnectionUtil.getConnection()) {
				//CallableStatement cs = con.prepareCall("{CALL INSERT_REQUEST(?,?,?)}");
				PreparedStatement stmt = con.prepareStatement("INSERT INTO REQUEST(AMOUNT, PURPOSE, REID)"+
									"VALUES(?, ?, ?)");
				stmt.setFloat(1, amount);
				stmt.setString(2, purpose);
				stmt.setInt(3, eid);
				stmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return true;
		} else
			try {
				throw new InvalidInputException("EID not found");
			} catch (InvalidInputException e) {
				Log.userError("EID not found, cannot submit request");
				return false;
			}
	}
	
	public boolean deleteRequest(int rid)
	{
		if(instance.getRequest(rid) != null)
		{
		try(Connection con = ConnectionUtil.getConnection())
		{
			CallableStatement cs=con.prepareCall("{call DELETE_REQUEST(?)}");
			cs.setInt(1, rid);
			cs.execute();
		} catch (SQLException e) {
			dev.Log.debug(e.getMessage());
			return false;
		} catch (IOException e1) {
			dev.Log.debug(e1.getMessage());
			return false;
		}
		}else try {
			throw new InvalidInputException("RID not found");
		} catch (InvalidInputException e) {
			Log.userError("RID not found, cannot delete request");
		}
		return true;
	}

	@Override
	public Request getRequest(int rid) {
		try(Connection con = ConnectionUtil.getConnection())
		{	
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM REQUEST WHERE RID=?");
			stmt.setInt(1, rid);
			ResultSet rs = stmt.executeQuery(); 
			if (rs.next()) {
				return new Request(rs.getInt(1),rs.getFloat(2),rs.getNString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
			}else
				try {
					throw new InvalidInputException("RID not found");
				} catch (InvalidInputException e) {
					Log.userError("RID not found, cannot find request");
				}
		
		} catch (SQLException e) {
			dev.Log.debug(e.getMessage());
		} catch (IOException e1) {
			dev.Log.debug(e1.getMessage());
		}
		return null;
	}

	public void uploadImg(int rid) {
		// TODO Auto-generated method stub
		
	}



}
