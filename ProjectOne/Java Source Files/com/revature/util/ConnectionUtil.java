package com.revature.util;

import java.io.*;
import java.sql.*;
import java.util.Properties;


public class ConnectionUtil {
	private ConnectionUtil() {}
	
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static Connection getConnection() {
		InputStream in = null;
		try {
			Properties props = new Properties();
			in = new FileInputStream("C:\\proj1.properties");
			props.load(in);
			return DriverManager.getConnection(props.getProperty("url"), props.getProperty("username" ), props.getProperty("password"));
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
		System.out.println(ConnectionUtil.getConnection());
	}
}