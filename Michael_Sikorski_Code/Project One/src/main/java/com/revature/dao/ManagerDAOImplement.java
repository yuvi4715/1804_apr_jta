/*
 *	Author: Michael Sikorski
 *	Date: 4/29/2018
 *
 *	Project One - Reimbursement Request System
 */

package com.revature.dao;

import java.sql.*;
import com.revature.model.*;
import com.revature.util.ConnectionWithProperties;
import com.revature.util.LogUtil;

// The implementation for the ManagerDAO interface
public class ManagerDAOImplement implements ManagerDAO {

	private static ManagerDAOImplement instance;

	private ManagerDAOImplement() {
	}

	public static ManagerDAOImplement getInstance() {
		if (instance == null) {
			instance = new ManagerDAOImplement();
		}
		return instance;
	}

	@Override
	public boolean createNewManager(String email, String username, String password, String first, String last) {
		boolean created = false;
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{call insert_manager(?,?,?,?,?)}");
			stmt.setString(1, email);
			stmt.setString(2, username);
			stmt.setString(3, password);
			stmt.setString(4, first);
			stmt.setString(5, last);
			if (stmt.executeUpdate() > 0) {
				created = true;
				LogUtil.logger
						.info("A new Manager has been registered with the following email address: " + email);
			} else {
				LogUtil.logger.error("There was an issue registering a new Manager with the following email address: " + email);
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return created;
	}

	@Override
	public Manager getManager(String email) {
		Manager manager = null;
		try (Connection conn = ConnectionWithProperties.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM MANAGER WHERE m_email=?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				manager = new Manager(email, rs.getString("m_username"), rs.getString("m_first_name"), rs.getString("m_last_name"));
			}
		} catch (SQLException sqle) {
			LogUtil.logger.error(sqle.getMessage());
			LogUtil.logger.error("SQL State: " + sqle.getSQLState());
			LogUtil.logger.error("Error Code: " + sqle.getErrorCode());
		}
		return manager;
	}

}
