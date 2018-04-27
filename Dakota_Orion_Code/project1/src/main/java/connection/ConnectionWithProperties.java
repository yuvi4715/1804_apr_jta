package connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionWithProperties {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			LogUtil.logger.warn("Exception thrown adding oracle driver.",e);
		}
	}
	private ConnectionWithProperties() {}
	
	public static Connection getConnection() {
		InputStream in =null;
		try {
			Properties props = new Properties();
			in = new FileInputStream("C:\\Users\\Dakot\\Documents\\workspace-sts-2\\project1\\src\\main\\resources\\db.properties");
			props.load(in);
			return DriverManager.getConnection(props.getProperty("jdbc.url"),props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: "+e.getSQLState());
			System.err.println("Error Code: "+ e.getErrorCode());
		}
		catch(FileNotFoundException fnfe) {
			fnfe.getMessage();
		}
		catch(IOException ioe) {
			ioe.getMessage();
		}
		finally {
			try {
				in.close();
			} catch (IOException e) {
				e.getMessage();
			}
		}
		return null;
	}

}
