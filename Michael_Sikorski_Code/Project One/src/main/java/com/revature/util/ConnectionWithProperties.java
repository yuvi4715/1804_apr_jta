/*
 *	Author: Michael Sikorski
 *	Date: 4/29/2018
 *
 *	Project One - Reimbursement Request System
 */

package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionWithProperties {

	private ConnectionWithProperties() { }

	public static void main(String[] args) {
		System.out.println(ConnectionWithProperties.getConnection());
	}

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			LogUtil.logger.warn("Exception thrown while adding oracle driver.",e);
		}
	}
	
	public static Connection getConnection() {
		InputStream in = null;
		try {
			Properties props = new Properties();
			in = new FileInputStream("C:\\Users\\Michael\\Documents\\workspace-sts-3.9.3.RELEASE\\MS_Project_One\\src\\main\\resources\\db.properties");
			props.load(in);
			return DriverManager.getConnection(
					props.getProperty("jdbc.url"),
					props.getProperty("jdbc.username"),
					props.getProperty("jdbc.password"));
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL state: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				in.close();
			} catch (IOException ioe) {
				System.err.println(ioe.getMessage());
			}
		}
		return null;
	}
}
