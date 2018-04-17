package joey.bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Connection used by BankApp to connect to bank_db
 * @author joeyi
 *
 */
public class ConnectDB 
{
	//Private static variable for ConnectDB singleton instance
	private static ConnectDB instance=null;
	//Private static Connection object
	private static Connection con =null;
	
	//Private ConnectDB constructor
	private ConnectDB()
	{
		new Log(); //start a log
		getConnection();
	}
	
	//Private method to establish a connection to bank_db and return a connection
	private static void getConnection()
	{
		
	//	try(FileInputStream in = new FileInputStream("src/main/resources/db.properties"))
	//	try(FileInputStream in = new FileInputStream("src/main/resources/admindb.properties"))
		try(FileInputStream in = new FileInputStream("src/main/resources/host.properties");
				FileInputStream in2= new FileInputStream("src/main/resources/userdb.properties"))
		{
			Properties host = new Properties();
			Properties props=new Properties();
			host.load(in); //load host
			props.load(in2); //load user login details
			con = DriverManager.getConnection(host.getProperty("url"), 
				    									 props.getProperty("username"), 
				    									 props.getProperty("password"));
			
			//Logs if connection is valid
			//Log.logInfo("Connection successfull: "+Boolean.toString(con.isValid(100)));
		} catch (FileNotFoundException e) {
			Log.logError(e.getMessage());
		} catch (IOException e) {
			Log.logError(e.getMessage());
		} catch (SQLException e) {
			Log.logError(e.getMessage());
		}
	}
	
	//Public method to return connection 
	public static Connection getCon() throws SQLException
	{
		if(con.isClosed() || con==null) getConnection();
		return con;
	}
	//Public getter for the singleton ConnectDB object
	public static ConnectDB getInstance()
	{
		if(instance==null) instance = new ConnectDB();
		return instance;
	}
	
	//Public method to close static Connection con
	public static void close()
	{
		try {
			if(con!=null)
			{ con.close();
			con=null;
			System.gc(); //garbage collection
			Log.logInfo("Bank closed successfully");
			}
		} catch (SQLException e) {
			Log.logError(e.getMessage());
		}
	}


}
