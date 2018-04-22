package com.ranieri.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ranieri.model.Request;
import com.ranieri.util.ConnectionWProp;
import com.ranieri.model.*;



public class RequestDaoImpl implements RequestDao{
	
	
	
private static RequestDaoImpl instance;
	
	private RequestDaoImpl() {}
	
	public static RequestDaoImpl getInstance() {
		if(instance == null) {
			instance = new RequestDaoImpl();
		}
		return instance;
	}
	
	
	
	
	
	

	@Override
	public List<Request> getAllRequest() {
		
		
		try(Connection conn = ConnectionWProp.getConnection()){
			
			//
			List<Request> requests = new ArrayList<>();
			
			// create statment object
			PreparedStatement stmt = conn.prepareStatement("SELECT requestid, email, reason, amount, status, manager, image FROM request");	
			ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				requests.add(new Request(rs.getInt("requestid"),rs.getString("email"),rs.getString("reason"),rs.getDouble("amount"),rs.getString("status"),rs.getString("manager"),rs.getString("image")));
			}
			
			return requests;
			
			
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			
		}		
		
		return null;
	}

	@Override
	public boolean createRequest(String email, String reason, double amount, String image) {
		
		
		try(Connection conn = ConnectionWProp.getConnection()){
			

			CallableStatement stmt = conn.prepareCall("CALL insertrequest(?,?,?,?)");
			stmt.setString(1,email);
			stmt.setString(2,reason );
			stmt.setDouble(3,amount );
			stmt.setString(4,image );
						
				return stmt.executeUpdate()> 0 ;
						
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			
		}
		return false;
	
	}

	@Override
	public boolean updateRequest(int requestID, String status, String manager) {
		// TODO Auto-generated method stub
		
		try(Connection conn = ConnectionWProp.getConnection()){
			

			CallableStatement stmt = conn.prepareCall("UPDATE request SET status = ?, manager = ? WHERE requestid = ? ");
			stmt.setString(1,status);
			stmt.setString(2, manager);
			stmt.setInt(3,requestID);
								
				return stmt.executeUpdate()> 0 ;
						
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			
		}
		return false;
		
		
	
	}
	
	
	
	

}
