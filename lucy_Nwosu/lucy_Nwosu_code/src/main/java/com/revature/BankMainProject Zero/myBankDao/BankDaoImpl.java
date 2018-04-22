package myBankDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import myBankModel.Bank;
import myConnectionUtil.ConnectionsWithPropertiesUtil;

// This class is the implementation of the BankDAO interface

	public class BankDaoImpl implements BankDAO {

		
		private static BankDaoImpl instance;
		private BankDaoImpl()
		{}
		//Scanner k = new Scanner(System.in);
		// ensuring there is only one instance of the interface and this class
		public static BankDAO getInstance() {
			if (instance ==null) {
				instance = new BankDaoImpl();
				
			}
			return instance;
		}
		
		@Override
		public boolean insertBank_Account(Bank user) {
			// TODO Auto-generated method stub
					int index = 0;
					
					try (Connection conn =  ConnectionsWithPropertiesUtil.getConnection()) {
					PreparedStatement stmt = conn.prepareStatement("INSERT INTO Bank_Account (firstname, lastname, Username, Password, Privilege, isapproved, checkingbalance, savingbalance) VALUES (?,?,?,?,?,?,?,?)");
					stmt.setString(++index, user.getFirstName());
					stmt.setString(++index, user.getLastName());
					stmt.setString(++index, user.getUserName());
					stmt.setString(++index, user.getPassword());
					stmt.setString(++index, user.getPrivilege());
					stmt.setString(++index, user.getIsApproved());
					stmt.setInt(++index, user.getCheckingBalance());
					stmt.setInt(++index, user.getSavingBalance());
					
					if(!stmt.execute())
					{
						return true;
					}
				} catch (SQLException sqle) {
					System.err.println(sqle.getMessage());
					System.err.println("SQL State: " + sqle.getSQLState());
					System.err.println("Error code: " + sqle.getErrorCode());
							
				}
				return false;
			
			
					}

		@Override
		public Bank getBankUser(String username) {
			// TODO Auto-generated method stub
		
			try (Connection conn =  ConnectionsWithPropertiesUtil.getConnection()) {
				PreparedStatement stmt = conn.prepareStatement("SELECT firstname,lastname,password,privilege,isapproved,checkingbalance,savingbalance From Bank_Account WHERE username =?");
				stmt.setString(1, username);
				
				ResultSet rs = stmt.executeQuery();
				System.out.println(username);
				// Can use if statement instead of while loop if you only expect one record
				if (rs.next()) {
					System.out.println("here");
					Bank bank = new Bank(rs.getString("firstname"), rs.getString("lastname"), username, 
							rs.getString("password"), rs.getString("privilege"),rs.getString("isapproved"), rs.getInt("checkingbalance"),rs.getInt("savingbalance"));
					
					System.out.println(bank.toString());
					return bank;
				} 
				
				else {
					System.out.println("rs=null");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
				e.getSQLState();
				e.getErrorCode();
				e.printStackTrace();
			}
			return null;
				
				
		}

		@Override
		public List<Bank> getAllBankers() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean updateBankUser(String username) {
			
			
			
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean deleteBanker(String username) {
			// TODO Auto-generated method stub
			return false;
		}
//
//		@Override
//		public boolean updateSavings(Bank user, double amount) {
//			try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
//				PreparedStatement stmt = conn.prepareStatement("UPDATE bank_account SET savings_balance = (savings_balance + ?) WHERE username = ?");
//				stmt.setDouble(1, amount);
//				stmt.setString(2, user.getUserName());
//				
//				return stmt.executeUpdate() > 0;
//			
//			}catch (SQLException sqle) {
//				System.err.println(sqle.getMessage());
//				System.err.println("SQL State: " + sqle.getSQLState());
//				System.err.println("Error code: " +  sqle.getErrorCode());
//			}
//			return false;
//					
//			
//		}
//
//		@Override
//		public boolean updateChecking(Bank user, double amount) {
//			// TODO Auto-generated method stub
//			
//			
//					try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
//					PreparedStatement stmt = conn.prepareStatement("UPDATE bank_account SET checkingbalance = (checkingbalance + ?) WHERE username = ?");
//					stmt.setDouble(1, amount);
//					stmt.setString(2, user.getUserName());
//					
//					return stmt.executeUpdate() > 0;
//				
//				}catch (SQLException sqle) {
//					System.err.println(sqle.getMessage());
//					System.err.println("SQL State: " + sqle.getSQLState());
//					System.err.println("Error code: " +  sqle.getErrorCode());
//				}
//
//				return false;
//		}
		// deposit and withdrawal methods
				@Override
				public boolean depositChecking(Bank user, double amount) {
					try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
						PreparedStatement stmt = conn.prepareStatement("UPDATE bank_account SET checkingbalance = (checkingbalance + ?) WHERE username = ?");
						stmt.setDouble(1, amount);
						stmt.setString(2, user.getUserName());
						
						return stmt.executeUpdate() > 0;
					
					}catch (SQLException sqle) {
						System.err.println(sqle.getMessage());
						System.err.println("SQL State: " + sqle.getSQLState());
						System.err.println("Error code: " +  sqle.getErrorCode());
					}

					return false;
				}

				@Override
				public boolean depositSavings(Bank user, double amount) {
					try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
						PreparedStatement stmt = conn.prepareStatement("UPDATE bank_account SET savingbalance = (savingbalance + ?) WHERE username = ?");
						stmt.setDouble(1, amount);
						stmt.setString(2, user.getUserName());
						
						return stmt.executeUpdate() > 0;
					
					}catch (SQLException sqle) {
						System.err.println(sqle.getMessage());
						System.err.println("SQL State: " + sqle.getSQLState());
						System.err.println("Error code: " +  sqle.getErrorCode());
					}
					return false;
				}
				
				@Override
				public boolean withdrawSavings(Bank user, double amount) {
					try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
						PreparedStatement stmt = conn.prepareStatement("UPDATE bank_account SET savingbalance = (savingbalance - ?) WHERE username = ?");
						stmt.setDouble(1, amount);
						stmt.setString(2, user.getUserName());
						
						return stmt.executeUpdate() > 0;
					
					}catch (SQLException sqle) {
						System.err.println(sqle.getMessage());
						System.err.println("SQL State: " + sqle.getSQLState());
						System.err.println("Error code: " +  sqle.getErrorCode());
					}
					return false;
				}

				@Override
				public boolean withdrawChecking(Bank user, double amount) {
					try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
						PreparedStatement stmt = conn.prepareStatement("UPDATE bank_account SET checkingbalance = (checkingbalance - ?) WHERE username = ?");
						stmt.setDouble(1, amount);
						stmt.setString(2, user.getUserName());
						
						return stmt.executeUpdate() > 0;
					
					}catch (SQLException sqle) {
						System.err.println(sqle.getMessage());
						System.err.println("SQL State: " + sqle.getSQLState());
						System.err.println("Error code: " +  sqle.getErrorCode());
					}
					return false;
				}

				
				// admin only method, returns boolan and validates user.
				@Override
				public boolean validateUser(String username) { // Method should only be available to admins
					try (Connection conn = ConnectionsWithPropertiesUtil.getConnection()) {
						PreparedStatement stmt = conn.prepareStatement("UPDATE bank_account SET isapproved = 'true' WHERE username = ?");
						stmt.setString(1, username);
						
						
						return stmt.executeUpdate() > 0;
					
					}catch (SQLException sqle) {
						System.err.println(sqle.getMessage());
						System.err.println("SQL State: " + sqle.getSQLState());
						System.err.println("Error code: " +  sqle.getErrorCode());
					}

					return false;
					
				}

			
	}