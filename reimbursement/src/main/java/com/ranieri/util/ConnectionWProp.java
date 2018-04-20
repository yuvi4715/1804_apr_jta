package com.ranieri.util;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.io.InputStream;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Properties;

		public class ConnectionWProp {	
		
		private ConnectionWProp() {
					
		}
		
		public static  Connection getConnection() {
			
			InputStream in = null;
			
			try {
				Properties props = new Properties();
				in = new FileInputStream("src/main/resources/db.properties");
				props.load(in);
				return DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
				
			}catch(SQLException e) {
				
				System.err.println(e.getMessage());
				System.err.println("SQL state: "+ e.getSQLState());
				System.err.println("Error Code: " + e.getErrorCode());
						
			}catch(FileNotFoundException fnfe) {
				System.err.println(fnfe.getMessage());
			}catch(IOException ioe) {
				System.err.println(ioe.getMessage());
			}finally {
				try {
					in.close();
				}catch (IOException ioe) {
					System.out.println("When closing InputStream " + ioe.getMessage());
				}
			}
			return null;
			
		}
		
		public static void main(String[] args) {
			System.out.println(ConnectionWProp.getConnection());
		}
		
}
