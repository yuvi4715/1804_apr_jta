package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
private ConnectionUtil() {} 
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Connection getConnection() {
		InputStream in = null;
		try {
			Properties props = new Properties();
			//put absolute path to properties folder in here
			in = new FileInputStream("C:\\Users\\Mitchell H's PC\\Documents\\workspace-sts-3.9.3.RELEASE\\ersProject1\\src\\main\\resources\\db.properties");
			props.load(in);
			return DriverManager.getConnection(props.getProperty("jdbc.url"),
					props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
		}catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch(IOException io) {
			io.printStackTrace();
		}
		finally {
			try {
				in.close();
			}catch (IOException e) {
				e.getMessage();
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(ConnectionUtil.getConnection());
	}
}
