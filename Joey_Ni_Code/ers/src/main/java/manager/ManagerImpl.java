package manager;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import app.ConnectionUtil;
import dev.InvalidInputException;
import dev.Log;
import employee.Employee;
import employee.EmployeeImpl;
import request.Request;

public class ManagerImpl implements ManagerDAO{
	
	private static ManagerImpl instance;
	
	private ManagerImpl() {}//never called outside the class
	
	public static ManagerImpl getInstance()
	{
		if(instance==null) instance = new ManagerImpl();
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

	@Override
	public int getId(String username)
	{
		try(Connection con = ConnectionUtil.getConnection())
		{	
			PreparedStatement stmt = con.prepareStatement("SELECT MID FROM MANAGER WHERE USERNAME=?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery(); 
			if (rs.next()) {
				return rs.getInt(1);
			}else return -1;
			/*	try {
					throw new InvalidInputException("Manager USERNAME not found");
				} catch (InvalidInputException | NullPointerException e) {
					Log.userError("Manager USERNAME not found, please register or check spelling");
					return -1;
				}*/
		} catch (SQLException e) {
			dev.Log.debug(e.getMessage());
		} catch (IOException e1) {
			dev.Log.debug(e1.getMessage());
		} catch (NullPointerException e3) {
			dev.Log.debug("Not a manager");
			return -1;
		}
		return -1;
		
	}
	public Manager getManager(int mid) {
		
		try(Connection con = ConnectionUtil.getConnection())
		{	
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM MANAGER WHERE MID=?");
			stmt.setInt(1, mid);
			ResultSet rs = stmt.executeQuery(); 
			if (rs.next()) {
				return new Manager(rs.getInt(1),rs.getNString(2),rs.getNString(3),rs.getNString(4),rs.getNString(5));
			}else
				try {
					throw new InvalidInputException("MID not found");
				} catch (InvalidInputException e) {
					Log.userError("MID not found, cannot submit request");
				}
		} catch (SQLException e) {
			dev.Log.debug("Manager get ID "+e.getMessage());
		} catch (IOException e1) {
			dev.Log.debug("Manager get ID "+e1.getMessage());
		}
		return null;
	}

	public Manager updateManager(int mid, String username, String password) {
		if (instance.getManager(mid) != null) {
		try(Connection con = ConnectionUtil.getConnection())
		{
			PreparedStatement stmt = con.prepareStatement("UPDATE MANAGER SET USERNAME=?, PASSWORD=? WHERE MID=?");
			stmt.setString(1,username);
			stmt.setString(2, password);
			stmt.setInt(3, mid);
			stmt.executeUpdate();
			return instance.getManager(mid);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		}else
			try {
				throw new InvalidInputException("MID not found");
			} catch (InvalidInputException e) {
				Log.userError("MID not found, cannot submit request");
			}
		return null;
	}

	public List<Request> getAllPendingRequests() {
		List<Request> req = new ArrayList<>();
	
		try(Connection con = ConnectionUtil.getConnection())
		{
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM REQUEST WHERE STATUS=9");
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
		
		return req;
		
	}


	public List<Request> getAllResolvedRequests() {
		List<Request> req = new ArrayList<>();
		
		try(Connection con = ConnectionUtil.getConnection())
		{
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM REQUEST WHERE STATUS=1");
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
		
		return req;
		
	}



	public void getImg(int rid) {
		// TODO Auto-generated method stub
		
	}

	public List<Employee> getAllEmployees() {
		List<Employee> el=new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnection())
		{
			PreparedStatement stmt= con.prepareStatement("SELECT * FROM EMPLOYEE");
			stmt.executeQuery();
			ResultSet rs=stmt.getResultSet();
			while(rs.next())
			{
				el.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5)));
			//	System.out.println(rs.getInt(1) +rs.getString(2)+rs.getString(3)
				//			+rs.getString(4)+rs.getString(5));
			}
		} catch (SQLException e) {
			dev.Log.debug(e.getMessage());
		} catch (IOException e1) {
			dev.Log.debug(e1.getMessage());
		}

		return el;
	}

	public List<Request> getEmployeeRequests(int eid) {
		/*return Stream.concat(EmployeeImpl.getInstance().getPendingRequests(eid).stream(), 
				EmployeeImpl.getInstance().getResolvedRequests(eid).stream())
                .collect(Collectors.toList());*/
		List<Request> req = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnection())
		{	
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM REQUEST WHERE REID=?");
			stmt.setInt(1, eid);
			ResultSet rs = stmt.executeQuery(); 
			if (rs.next()) {
				req.add(new Request(rs.getInt(1),rs.getFloat(2),rs.getNString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)));
			}else
				try {
					throw new InvalidInputException("EID not found");
				} catch (InvalidInputException e) {
					Log.userError("EID not found, cannot find request");
					return null;
				}
		
		} catch (SQLException e) {
			dev.Log.debug(e.getMessage());
		} catch (IOException e1) {
			dev.Log.debug(e1.getMessage());
		}
		return req;
	}

	public boolean approveRequest(int rid, int mid, int ap) {
		if (instance.getRequest(rid) != null && instance.getManager(mid) !=null &&
				(ap==1 || ap==0 || ap==9)) 
		{
		try(Connection con = ConnectionUtil.getConnection())
		{
			//CallableStatement cs=con.prepareCall("{call APPROVE_REQUEST(?,?,?)}");
			PreparedStatement stmt = con.prepareStatement("UPDATE REQUEST SET STATUS=?, RMID=? WHERE RID=?");
			stmt.setInt(1, ap);
			stmt.setInt(2, mid);
			stmt.setInt(3, rid);
			stmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}else try {
			throw new InvalidInputException("Invalid approval code, MID or RID not found");
		} catch (InvalidInputException e) {
			Log.userError("Cannot get request");
		}
		return false;
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

	public boolean insertEmployee(String username, String password, String lastname, String firstname)
	{
		if(instance.getId(username)!=-1)
		{
		try(Connection con = ConnectionUtil.getConnection())
		{
			CallableStatement cs=con.prepareCall("{call INSERT_EMPLOYEE(?,?,?,?)}");
			cs.setString(1, username);
			cs.setString(2, password);
			cs.setString(3,lastname);
			cs.setString(4, firstname);
			cs.execute();
		} catch (SQLException e) {
			dev.Log.debug(e.getMessage());
			return false;
		} catch (IOException e1) {
			dev.Log.debug(e1.getMessage());
			return false;
		}
		}else try {
			throw new InvalidInputException("Username taken, please try a new one");
	} catch (InvalidInputException e) {
		Log.userError("Username taken, cannot create another ");
		return false;
	}
		return true;
		
	}
	
	public boolean insertManager(String username, String password, String lastname, String firstname)
	{
		if (getId(username)!=-1)
		{
		try(Connection con = ConnectionUtil.getConnection())
		{
			CallableStatement cs=con.prepareCall("{call INSERT_MANAGER(?,?,?,?)}");
			cs.setString(1, username);
			cs.setString(2, password);
			cs.setString(3,lastname);
			cs.setString(4, firstname);
			cs.execute();
		} catch (SQLException e) {
			dev.Log.debug(e.getMessage());
			return false;
		} catch (IOException e1) {
			dev.Log.debug(e1.getMessage());
			return false;
		}
		}else try {
			throw new InvalidInputException("Username taken, please try a new one");
	} catch (InvalidInputException e) {
		Log.userError("Username taken, cannot create another ");
		return false;
	}
	return true;
	}
	
	
	@Override
	public boolean deleteEmployee(int eid)
	{
		if(instance.getEmployee(eid) != null)
		{
		try(Connection con = ConnectionUtil.getConnection())
		{
			CallableStatement cs=con.prepareCall("{call DELETE_EMPLOYEE(?)}");
			dev.Log.warn("Deleting an employee will delete all of the employees too.");
			cs.setInt(1, eid);
			cs.execute();
		} catch (SQLException e) {
			dev.Log.debug(e.getMessage());
			return false;
		} catch (IOException e1) {
			dev.Log.debug(e1.getMessage());
			return false;
		}
		}else try {
			throw new InvalidInputException("EID not found");
		} catch (InvalidInputException e) {
			Log.userError("EID not found, cannot delete employee");
		}
		return true;
	}
	@Override
	public boolean createEmployeeLogin(String username, String password, int eid)
	{
		if (instance.getEmployee(eid) != null) {
		try(Connection con = ConnectionUtil.getConnection())
		{
			CallableStatement cs=con.prepareCall("{call ADD_USER(?,?)}");
			cs.setString(1, username);
			cs.setString(2, password);
			cs.execute();
		} catch (SQLException e) {
			dev.Log.debug(e.getMessage());
			return false;
		} catch (IOException e1) {
			dev.Log.debug(e1.getMessage());
			return false;
		}
		}else
			try {
				throw new InvalidInputException("EID not found");
			} catch (InvalidInputException e) {
				Log.userError("EID not found, cannot create new login");
			}
		return true;
	}
	@Override
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
					Log.userError("EID not found, no such employee");
				}
			
		} catch (SQLException e) {
			dev.Log.debug(e.getMessage());
		} catch (IOException e1) {
			dev.Log.debug(e1.getMessage());
		}
		return null;
	}
	
	@Override
	public void createUser(String username, String password)
		{
			try(Connection con = ConnectionUtil.getConnection())
			{
				
				PreparedStatement stmt = con.prepareStatement("CREATE USER "+username+" IDENTIFIED BY "+password);
				//stmt.setString(1, username);
				//stmt.setString(2, password);
				stmt.execute();
				Log.debug("Manager: User created: "+ username);
				
			} catch (SQLException e) {
				Log.debug("User creation error:"+e.getMessage());
			} catch (IOException e1) {
				Log.debug("User creation error:"+e1.getMessage());
			}
				
		}
	
	@Override
	public boolean deleteUser(String username)
	{
		try(Connection con = ConnectionUtil.getConnection())
		{
			
			PreparedStatement stmt = con.prepareStatement("DROP USER "+username);
			stmt.execute();
			Log.debug("Manager: User DROPPED: "+ username);
			return true;
		} catch (SQLException e) {
			Log.debug("User DROP error:"+e.getMessage());
			return false;
		} catch (IOException e1) {
			Log.debug("User DROP error:"+e1.getMessage());
			return false;
		}
			
	}
	
	@Override
	public void grantEmployee(String username)
	{
		try(Connection con = ConnectionUtil.getConnection())
		{
			
			PreparedStatement stmt = con.prepareStatement("GRANT ERS_EMPLOYEE TO "+username);
			stmt.execute();
			Log.debug("Manager Role granted to " + username);
		} catch (SQLException e) {
			Log.debug("Manager Role error:" +e.getMessage());
		} catch (IOException e1) {
			Log.debug("Manager Role error:" +e1.getMessage());
		}
	}

}
