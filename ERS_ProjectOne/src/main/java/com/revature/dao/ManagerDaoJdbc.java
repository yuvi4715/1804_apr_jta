package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.Manager;
import com.revature.util.ConnectionUtil;

public class ManagerDaoJdbc implements ManagerDao {

	@Override
	public Manager getManager(String username, String password) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM manager WHERE user_name = ? AND password = ?");
			stmt.setString(++index, username);
			stmt.setString(++index, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Manager(rs.getString("email"),
						rs.getString("password"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("user_name"));
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}
}
