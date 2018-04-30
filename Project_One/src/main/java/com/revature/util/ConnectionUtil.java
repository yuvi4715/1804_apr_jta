package com.revature.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class ConnectionUtil {

	final static Logger logger = Logger.getLogger(ConnectionUtil.class); 
	private ConnectionUtil() {}
	
	public static Connection getConnection() {
		InputStream in = null;
		try {
			Properties props = new Properties();
			in = new FileInputStream("/Users/ramnerylugo/Documents/workspace-sts-3.9.3.RELEASE/Project_One/src/main/resources/db.properties");
			props.load(in);
			Class.forName("oracle.jdbc.OracleDriver");
			
		return DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
		}catch(ClassNotFoundException e) {
			
		} catch (SQLException e){
			logger.error(e.getMessage());
			logger.error("SQL State: " + e.getSQLState());
			logger.error("Error Code: " + e.getErrorCode());
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public static void main(String[] args) {
		System.out.println(ConnectionUtil.getConnection());
	}
	
	
}
