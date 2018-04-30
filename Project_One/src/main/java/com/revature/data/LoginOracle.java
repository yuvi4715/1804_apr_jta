package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Login;
import com.revature.util.ConnectionUtil;

public class LoginOracle implements LoginDao {
	private static ConnectionUtil cu = ConnectionUtil.getInstance();
	
	@Override
	public Login login(String username, String password) {
		Login login = null;
		Connection conn = null;
		conn = cu.getConnection();
		String sql = "Select username, password, fav_color from login "
				+ "where username = ? and password =?";
		
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				login = new Login(rs.getString("username"),
						rs.getString("password"),
						rs.getString("fav_color"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}
}
