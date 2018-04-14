package revature.project0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminPage extends UserPage{
	static Scanner log = new Scanner(System.in);
	static int loginType;
	static AdminPage admin = new AdminPage();
	public static void Admin() {
		
		System.out.println("Welcome to Admin Singn-in Page.");
		System.out.println("Select you option \n1 for Log-In. \n2 for Sign-Up. \nEnter your option : ");
		do {
			loginType = log.nextInt();
			if(loginType == 1) {
				System.out.println("Enter your Credentials");
				
				System.out.println("Enter your Admin-Name : ");
				String userName = log.next();
				
				System.out.println("Enter your Password : ");
				String password = log.next();
				
				//System.out.println("UserName - " + userName +"\nPassword - " + password);
				int index = 0;
				try (Connection conn = dbConnection.getConnection()) {
					PreparedStatement stmt = conn.prepareStatement("SELECT adminName, adminPassword FROM adminInfo WHERE adminName = ? AND adminPassword = ?");
					stmt.setString(++index, userName);
					stmt.setString(++index, password);
					
					ResultSet rs = stmt.executeQuery();
					
					if(rs.next()) {
						admin.userDetails();
					}
				} catch (SQLException sqle) {
					System.err.println(sqle.getMessage());
					System.err.println("SQL State: " + sqle.getSQLState());
					System.err.println("Error Code: " + sqle.getErrorCode());
				}
			}else {
				if(loginType == 2) {
					System.out.println("Enter your Information");
					System.out.println("Name : ");
					String name = log.next();
					System.out.println("Password : ");
					String password = log.next();
	
					admin.savingData(name, password);
					
				}else {
					System.out.println("Select a valid user option");
				}
			}
		}while(loginType >2);
		log.close();
		
	}
	public void savingData(String name, String password) {
		System.out.println("Name : " + name);
		System.out.println("Password : " + password);
		//System.out.println("User-Name : " + username);
		int index = 0;
		try(Connection conn = dbConnection.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO adminInfo (adminName, adminPassword) VALUES (?, ?)");
			//stmt.setInt(++index, 0);
			stmt.setString(++index, name);
			stmt.setString(++index, password);
			if (!stmt.execute())
			MainAppPage.main(null);
			
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
	}
	
	public void userDetails() {
		try(Connection conn = dbConnection.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM userInfo");
			ResultSet rs = stmt.executeQuery();
			System.out.println("User-ID Name User-Name Password Amount Status");
			while(rs.next()) {
				System.out.println(rs.getInt("userId") +" "+rs.getString("name") + " " + rs.getString("userName")+" "+rs.getString("userPassword")
				+" "+ rs.getInt("depositAmount")+ " " + rs.getString("adminApprovalStatus"));
			}
			System.out.println("1 for Approving. \n2 for logout");
			int fun= log.nextInt();
			if(fun == 1) {
			System.out.println("Enter the User-ID to approve the account : ");
			int id = log.nextInt();
			try(Connection con = dbConnection.getConnection()){
				PreparedStatement stmt1 = con.prepareStatement("Update userInfo SET adminApprovalStatus = 'yes' where userId = " + id);
				if (!stmt1.execute()) {
					System.out.println("approved");
					admin.userDetails();
				}
					
				
			}catch (SQLException sql) {
				System.err.println(sql.getMessage());
				System.err.println("SQL State: " + sql.getSQLState());
				System.err.println("Error Code: " + sql.getErrorCode());
			}
			}else {
				MainAppPage.main(null);
			}
		}catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		
		
	}

}
