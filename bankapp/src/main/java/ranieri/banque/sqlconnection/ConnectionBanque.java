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

public class ConnectionBanque {

	
	
	

	private ConnectionBanque() {
						
		}
	
	public static Connection getConnection() {
		
		InputStream in = null;
		try {
			
			Properties props = new Properties();
			in = new FileInputStream("C:\\SpringToolSuite\\Projects\\bankapp\\db.properties");
			props.load(in);
			return DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
			
			
		}catch(SQLException e) {
			
			System.err.println(e.getMessage());
			System.err.println("SQL state: "+ e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
