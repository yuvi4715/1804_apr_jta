package ranieri.project0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionBanque {

	
	
	

	private ConnectionBanque() {
						
		}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@adam1804.cwrqnnecy1to.us-east-2.rds.amazonaws.com:1521:ORCL", "chinook","p4ssw0rd");
		}catch(SQLException e) {
			
			System.err.println(e.getMessage());
			System.err.println("SQL state: "+ e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
					
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
