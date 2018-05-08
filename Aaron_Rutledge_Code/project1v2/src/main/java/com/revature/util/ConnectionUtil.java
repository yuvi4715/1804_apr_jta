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
	
	public static Connection getConnection() {
		InputStream in = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Properties props = new Properties();
			
			in = new FileInputStream("C:\\Users\\haunt\\Documents\\workspace-sts-3.9.3.RELEASE\\project1v2\\src\\main\\resources\\db.properties");
			
			props.load(in);
			
			return DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"),
												props.getProperty("jdbc.password"));
			
		} catch (ClassNotFoundException cfe) {
			
			System.err.println(cfe.getMessage());
			
		} catch (SQLException sqle) {
			
			System.err.println(sqle.getMessage());
			
		} catch (FileNotFoundException fnfe) {
			
			System.err.println(fnfe.getMessage());
			
		} catch (IOException ioe) {
			
			System.err.println(ioe.getMessage());
			
		} finally {
			
			try {
				in.close();
			} catch (IOException ioe) {
				
				ioe.getMessage();
			}
			
		}
		
		return null;
		
		
		
	}
	

}