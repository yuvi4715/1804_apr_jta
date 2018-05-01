package com.system.dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.system.model.Request;
import com.system.model.User;
import com.system.service.UserService;
import com.system.util.ConnectionProperties;

public class RequestImpl implements RequestInterface {

	private static RequestImpl instance;

	private RequestImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static RequestImpl getInstance() {
		if (instance == null) {
			instance = new RequestImpl();
		}
		return instance;
	}

	public boolean createrequest(Request request, int id) throws SQLException {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionProperties.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Request"
					+ "(requestdetails, requestamount, requester) VALUES (?,?,?)");
		
			stmt.setString(1, request.getRequestdetails());
			
			stmt.setInt(2,  (int) request.getReqamount());
			stmt.setInt(3, id);
		
			
			if(!stmt.execute())
			{  
				//executeupdate returns
				return stmt.getUpdateCount()>0;  
			}
		}
		
		return false;
	
	
	}

	public List<Request> getrequest(User user) {
		
		try(Connection conn = ConnectionProperties.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT requestid, "
					+ "requestamount,  reviewer, requestdate, status, requestdetails, reviewdate FROM Request WHERE requester = ?");
			stmt.setInt(1, user.getID());
			ResultSet rs = stmt.executeQuery();
			 List<Request>requests = new ArrayList<Request>();
			 while(rs.next()){
					Request t = new Request();
					t.setID(rs.getInt("requestid"));
					t.setReqamount(rs.getInt("requestamount"));
					if(rs.getInt("reviewer")== 0)
					{
						
					}
					else
					{
					User u = UserService.getUser(null, "manager", rs.getInt("reviewer"));
					t.setReviewer( u);
					}
					//t.setReviewer(rs.getInt("reviewer"));
					t.setRequestdate(rs.getDate("requestdate"));
					t.setStatus(rs.getString(("status")));
					t.setRequestdetails(rs.getString("requestdetails"));
					t.setReviewdate(rs.getDate("reviewdate"));
					t.setRequester(user);
					requests.add(t);
				}
				
				return requests;
		
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
			e.printStackTrace();
		}
		return null;
	}
	
	

	public List<Request> getallrequest() {
		// TODO Auto-generated method stub

		try(Connection conn = ConnectionProperties.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT requestid, "
					+ "requestamount, requester, reviewer, requestdate, status, requestdetails, reviewdate FROM Request ");
			ResultSet rs = stmt.executeQuery();
			 List<Request>requests = new ArrayList<Request>();
			 while(rs.next()){
					Request t = new Request();
					t.setID(rs.getInt("requestid"));
					t.setReqamount(rs.getInt("requestamount"));
					{
						User y =UserService.getUser(null, "employee", rs.getInt("requester") );
						t.setRequester(y);
					}
					if(rs.getInt("reviewer")== 0)
					{
						
					}
					else
					{
					User u = UserService.getUser(null, "manager", rs.getInt("reviewer"));
					t.setReviewer( u);
					}
					//t.setReviewer(rs.getInt("reviewer"));
					t.setRequestdate(rs.getDate("requestdate"));
					t.setStatus((rs.getString("status")));
					t.setRequestdetails(rs.getString("requestdetails"));
					t.setReviewdate(rs.getDate("reviewdate"));
					requests.add(t);
				}
				
				return requests;
		
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateRequest(int request, String status, int userid) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionProperties.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("UPDATE Request SET status = ?, reviewer = ? WHERE requestid = ?");

			stmt.setString(1, status);

			stmt.setInt(2, userid);
			stmt.setInt(3, request);

			if (!stmt.execute()) {

				return stmt.getUpdateCount() > 0;

			}

		} catch (SQLException sqle) {

			System.err.println(sqle.getMessage());

			System.err.println("SQL State: " + sqle.getSQLState());

			System.err.println("Error Code: " + sqle.getErrorCode());

		}
		return false;
	}
	
	public List<Request>getsortedrequest(String y)
	{	System.out.println(y);
		try(Connection conn = ConnectionProperties.getConnection())
		{
			if(y.equals("Y"))
			{
			PreparedStatement stmt = conn.prepareStatement("SELECT requestid, "
					+ "requestamount,  reviewer, requestdate, status, requestdetails, reviewdate, requester FROM Request WHERE (status = ? AND status = ?)");
			stmt.setString(1, "D");
			stmt.setString(2, "Y");
			ResultSet rs = stmt.executeQuery();
			 List<Request>requests = new ArrayList<Request>();
			 while(rs.next()){
					Request t = new Request();
					t.setID(rs.getInt("requestid"));
					t.setReqamount(rs.getInt("requestamount"));
					{
						User o  =UserService.getUser(null, "employee", rs.getInt("requester") );
						t.setRequester(o);
					}
					if(rs.getInt("reviewer")== 0)
					{
						
					}
					else
					{
					User u = UserService.getUser(null, "manager", rs.getInt("reviewer"));
					t.setReviewer(u);
					}
					//t.setReviewer(rs.getInt("reviewer"));
					t.setRequestdate(rs.getDate("requestdate"));
					t.setStatus(rs.getString(("status")));
					t.setRequestdetails(rs.getString("requestdetails"));
					t.setReviewdate(rs.getDate("reviewdate"));
					requests.add(t);
				}
				
				return requests;
		
		}
			else
			{
				PreparedStatement stmt = conn.prepareStatement("SELECT requestid, "
						+ "requestamount,  reviewer, requestdate, status, requestdetails, reviewdate, requester FROM Request WHERE status = ?");
				stmt.setString(1, y);
				ResultSet rs = stmt.executeQuery();
				 List<Request>requests = new ArrayList<Request>();
				 while(rs.next()){
						Request t = new Request();
						t.setID(rs.getInt("requestid"));
						t.setReqamount(rs.getInt("requestamount"));
						{
							User o  =UserService.getUser(null, "employee", rs.getInt("requester") );
							t.setRequester(o);
						}
						if(rs.getInt("reviewer")== 0)
						{
							
						}
						else
						{
						User u = UserService.getUser(null, "manager", rs.getInt("reviewer"));
						t.setReviewer(u);
						}
						//t.setReviewer(rs.getInt("reviewer"));
						t.setRequestdate(rs.getDate("requestdate"));
						t.setStatus(rs.getString(("status")));
						t.setRequestdetails(rs.getString("requestdetails"));
						t.setReviewdate(rs.getDate("reviewdate"));
						requests.add(t);
					}
					
					return requests;
			}
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
			System.err.println(e.getSQLState());
			System.err.println(e.getErrorCode());
			e.printStackTrace();
		}
		return null;
		
	}

	public boolean deleteRequest() {
		// TODO Auto-generated method stub
		return false;
	}

}
