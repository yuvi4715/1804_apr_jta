package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.Administrator;
import com.revature.model.BankCustomer;
import com.revature.util.ConnectDatabase;

public class AdminDaoImpl implements AdministratorDao {

	@Override
	public boolean insertAdmin(Administrator inputAdmin) {
		int index = 0;
		try (Connection conn = ConnectDatabase.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL insert_admin(?, ?, ?, ?)}");
			stmt.setString(++index, inputAdmin.getFirstName());
			stmt.setString(++index, inputAdmin.getLastName());
			stmt.setString(++index, inputAdmin.getUsername());
			stmt.setString(++index, inputAdmin.getPassword());

			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public Administrator getAdmin(String username) {
		int index = 0;
		try (Connection conn = ConnectDatabase.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ADMINISTRATOR WHERE username = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Administrator(rs.getString("firstname"), rs.getString("lastname"),
						rs.getString("username"), rs.getString("password"));
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public boolean updateAdmin(Administrator inputAdmin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAdmin(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
