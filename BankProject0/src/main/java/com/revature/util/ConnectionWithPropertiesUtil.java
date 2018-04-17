package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionWithPropertiesUtil {
	private ConnectionWithPropertiesUtil() {} 
	
	public static Connection getConnection() {
		InputStream in = null;
		try {
			Properties props = new Properties();
			in = new FileInputStream("src/main/resources/db.properties");
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
		System.out.println(ConnectionWithPropertiesUtil.getConnection());
	}
}
