package com.revature.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class ConnectionsWithPropertiesUtil {
	
	public static void main(String[] args) {
		System.out.println(getConnection());
		ConnectionsWithPropertiesUtil.getConnection();
	}

	private ConnectionsWithPropertiesUtil() {
	}

	public static Connection getConnection() {
		InputStream in = null;
		try {
			Properties props = new Properties();
			in = new FileInputStream(
					"src/main/resources/db.properties");
			props.load(in);
			return DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"),
					props.getProperty("password"));
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		} finally {
			try {
				in.close();
			} catch (IOException ioe) {
				System.err.println("When closing InputStream: " + ioe.getMessage());
			}
		}
		return null;
	}
}
