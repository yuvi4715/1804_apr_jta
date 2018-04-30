package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*connection to oracle sql*/
public final class ConnectionUtil {

	
	private ConnectionUtil() {
	}

	public static Connection getConnection() {
		InputStream in = null;
		try {
			Properties props = new Properties();
			in = new FileInputStream("C:\\revature\\ERS_ProjectOne\\src\\main\\resources\\database.properties");
			props.load(in);
			try {
				Class.forName(props.getProperty("driver"));
			} catch (ClassNotFoundException e) {
				System.out.println("Can not find the driver.");
			}
			return DriverManager.getConnection(props.getProperty("url"),
					props.getProperty("username"),
					props.getProperty("password"));
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
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
