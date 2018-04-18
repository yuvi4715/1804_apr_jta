package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* Final utility class to obtain connections in a modular way */
public final class ConnectionUtil {
	
	/* Make tomcat now which database driver to use */
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			LogUtil.logger.warn("Exception thrown adding oracle driver.",e);
		}
	}
	
	/* Get connection to JDBC */
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@usfdbjava.cgmoq4yzdcov.us-east-1.rds.amazonaws.com:1521:ORCL";
		String username = "LOGIN_TEST_DB";
		String password = "p4ssw0rd";
		
		return DriverManager.getConnection(url, username, password);
	}
}
