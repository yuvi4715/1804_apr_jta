package revature.project0;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class dbConnection {
	
	private dbConnection() {
		
	}
	
	public static Connection getConnection() {
		InputStream in = null;
		try {
			Properties props = new Properties();
			in = new FileInputStream("src/main/resources/database.properties");
			props.load(in);
			return DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
			System.out.println("SQL State:" + sqle.getSQLState());
			System.out.println("Error code:" + sqle.getErrorCode());
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		}catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return null;
	}
	
	public static void main(String [] args) {
		System.out.println(dbConnection.getConnection());
	}

}
