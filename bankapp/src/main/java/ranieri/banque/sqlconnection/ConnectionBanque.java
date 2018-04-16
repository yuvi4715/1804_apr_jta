package ranieri.banque.sqlconnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

import ranieri.logger.*;

public class ConnectionBanque {

	
	
	

	private ConnectionBanque() {
						
		}
	
	public static Connection getConnection() {
		final Logger log = Logger.getLogger(Logger4j.class);
		InputStream in = null;
		try {
			
			Properties props = new Properties();
			in = new FileInputStream("C:\\SpringToolSuite\\Projects\\bankapp\\db.properties");
			props.load(in);
			return DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));

		}catch(SQLException e) {
			
//			System.err.println(e.getMessage());
//			System.err.println("SQL state: "+ e.getSQLState());
//			System.err.println("Error Code: " + e.getErrorCode());
			System.out.println("There was an error connecting please try again later");
			log.error("SQL exception");
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("There was an error connecting please try again later");
			log.error("FNFE");
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("There was an error connecting please try again later");

			log.error("IO exception");
		}
		return null;
	
	}
	
	public static void main(String[] args)  {
		System.out.println(ConnectionBanque.getConnection());
		
		
		// Create the statement to be used to get the results.
	
		       Statement stm;
			try {
				stm = getConnection().createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
