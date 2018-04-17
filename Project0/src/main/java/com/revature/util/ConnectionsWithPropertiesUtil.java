package com.revature.util;
// class used to instantiate connection with parameters, making things easier
import java.io.*;
import java.sql.*;
import java.util.Properties; // need this to read property files


public class ConnectionsWithPropertiesUtil {
	
	private ConnectionsWithPropertiesUtil() {}
	
	public static Connection getConnection() {
		InputStream in = null;
		try {
			Properties props = new Properties(); 
			in = new FileInputStream("db.properties");
			props.load(in);
			return DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"), 
					props.getProperty("jdbc.password"));
			
			
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error code: " +  sqle.getErrorCode());
			
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe.getLocalizedMessage());
			
		}catch (IOException ioe) {
			System.err.println(ioe.getMessage());
			
		} finally {
			try {
				in.close();
				
			} catch (IOException ioe) {
				System.err.println("'When closing inputstream: " + ioe.getMessage());
			}
		}
		
		return null;
	}

	
	public static void main(String[] args) {
		System.out.println(ConnectionsWithPropertiesUtil.getConnection());
	}
}
