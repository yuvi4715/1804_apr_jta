package main.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionWithPropertiesUtil {
	private ConnectionWithPropertiesUtil()
	{
	}
	
	public static Connection getConnection()
	{
		InputStream in = null;
		try
		{
			Properties props = new Properties();
			in = new FileInputStream("src/main/resources/DB.properties");
			props.load(in);
			return DriverManager.getConnection(props.getProperty("jdbc.url"),props.getProperty("jdbc.username"),props.getProperty("jdbc.password"));
		} 
		catch(SQLException sqle)
		{
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		} 
		catch(FileNotFoundException info)
		{
			System.err.println(info.getMessage());
		}
		catch(IOException ioe)
		{
			System.err.println(ioe.getMessage());
		}
		finally
		{
			try
			{
				in.close();
			}
			catch(IOException ioe)
			{
				System.err.println("When closing InputStream: " + ioe.getMessage());
			}
		}
		
		return null; 
	}
}
