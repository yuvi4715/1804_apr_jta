package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionsWithPropertiesUtil
{
	private ConnectionsWithPropertiesUtil() {}
	
	public static Connection getConnection()
	{
		InputStream iStream = null;
		try
		{
			Properties props = new Properties();
			iStream = new FileInputStream("src\\dao\\db.properties");
			props.load(iStream);
			return(DriverManager.getConnection(props.getProperty("jdbc.url"),
					props.getProperty("jdbc.username"), props.getProperty("jdbc.password")));
		}
		catch(SQLException sqle)
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		catch(FileNotFoundException fnfe)
		{
			System.err.println(fnfe.getMessage());
		}
		catch(IOException ioe)
		{
			System.err.println(ioe.getMessage());
		}
		finally
		{
			try
			{
				iStream.close();
			}
			catch(IOException ioe)
			{
				System.err.println("When closing InputStream: " + ioe.getMessage());
			}
		}
		
		
		return(null);
	}
}
