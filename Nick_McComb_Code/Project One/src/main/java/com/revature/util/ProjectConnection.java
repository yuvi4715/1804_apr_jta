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

import com.revature.dao.Reimbursement_Impl;

public class ProjectConnection {
	private ProjectConnection() {}
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.out.println("Oracle Driver not found");
		}
	}
	
	final static Logger log = Logger.getLogger(Reimbursement_Impl.class);

	public static Connection getConnection() {
		log.info("Attempting to get connection");
		InputStream in = null;
		try{
			Properties props = new Properties();
			in = new FileInputStream("C:\\Users\\pinky\\Documents\\workspace-sts-3.9.3.RELEASE\\ProjectOne\\src\\main\\resources\\db.properties");
			props.load(in);
			log.info("Getting connection " + props.getProperty("jdbc.url"));
			return DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"),
						props.getProperty("jdbc.password"));
		} catch (SQLException e) {
			log.error("SQL error");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		} catch (FileNotFoundException f){
			log.error("FileNotFound Error");
			System.err.println((f.getMessage()));
		} catch (IOException i) {
			log.error("");
			System.err.println(i.getMessage());
		} finally {
			try {
				in.close();
			} catch (IOException i) {
				System.err.println("Error when closing InputStream: " + i.getMessage());
			}
		}
		log.error("Unable to get connection");
		return null;
	}
}
