package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import dev.Log;

/**
 * Final utitlity class to get connection in modular way
 * session.invalidate to logout
 * @author joeyi
 *
 */
public final class ConnectionUtil {
	//Private static Connection object
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			new Log();
			Log.fatal("Oracle Driver not found. " + e.getMessage());
		}
	}
	
	public static Connection getConnection() throws SQLException, IOException
	{
		try(FileInputStream in = new FileInputStream("C:\\Users\\joeyi\\spring-workspace\\ers\\src\\main\\resources\\db.properties");
				FileInputStream in2= new FileInputStream("C:\\Users\\joeyi\\spring-workspace\\ers\\src\\main\\resources\\userdb.properties"))
		{
			Properties host = new Properties();
			Properties props=new Properties();
			host.load(in); //load host
			props.load(in2); //load user login details
			String url = host.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			Connection con = DriverManager.getConnection(url, username, password);
			return con;
			//Logs if connection is valid
			//Log.logInfo("Connection successfull: "+Boolean.toString(con.isValid(100)));
		} catch (FileNotFoundException e) {
			Log.debug(e.getMessage());
		} catch (IOException e) {
			Log.debug(e.getMessage());
		} catch (SQLException e) {
			Log.debug(e.getMessage());
		}
		
		return null;
	}
	
	
}

	


