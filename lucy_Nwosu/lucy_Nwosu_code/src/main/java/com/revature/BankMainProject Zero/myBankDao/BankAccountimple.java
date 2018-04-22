package myBankDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bankConnection.ConnectionUtil;
import bankModel.BankAccount;
import bankModel.BankAppUser;
	
		
	public class BankAccountimple implements BankAccountDao {
		
			private static BankAccountimple instance;
			
			private BankAccountimple()
			{
				
			}
			
			public static BankAccountimple getInstance()
			{
				if(instance == null)
				{
					instance = new BankAccountimple();
				}
				return instance;
			}

			@Override
			public boolean insertBankAccount(BankAccount bankAccount) {
				// TODO Auto-generated method stub
				try(Connection conn = ConnectionUtil.getConnection())
				{
					PreparedStatement stmt = conn.prepareStatement("INSERT INTO BANKACCOUNT"
							+ "(Id, AccountNumber, TransactionId, TransactionType, TransactionAmount, AccountBalance) VALUES (?,?,?,?,?,?)");
								
					
			
					stmt.setInt(1, 1); 
					stmt.setInt(2, bankAccount.getAccountNumber());
					stmt.setInt(3, bankAccount.getTransactionId());
					stmt.setString(4, bankAccount.getTransactionType());
					stmt.setInt(5, bankAccount.getTransactionAmount());
					stmt.setInt(6, bankAccount.getAccountBalance());
					
					
					if(!stmt.execute())
					{
						//executeupdate returns
						return stmt.getUpdateCount()>0;
					}
				}catch(SQLException e)
				{
					
				}
				
				return false;
			}

			//public BankAppUser getBankAppUser(String accountName) { 
			@Override
			public BankAccount getBankAccount(int accountNumber) { 
				try(Connection conn = ConnectionUtil.getConnection()){
					PreparedStatement stmt = conn.prepareStatement("SELECT Id, TransactionId, TransactionType, TransactionAmount, AccountBalance  FROM BankAccount WHERE AccountNumber = ?");///updatePassWord?
					stmt.setInt(1, accountNumber);
					ResultSet rs = stmt.executeQuery();
					// Can use if statement instead of while loop if your expecting only one result
					
				if(rs.next())
				{
								
					 return new BankAccount(rs.getInt("accountNumber"), rs.getInt("TransactionId"), rs.getString("TransactionType"),rs.getInt("TransactionAmount"), rs.getInt("AccountBalance"));
				}
				}catch(SQLException e)
				{
					System.err.println(e.getMessage());
					System.err.println(e.getSQLState());
					System.err.println(e.getErrorCode());
				}
				return null;
			}

			@Override
			public List<BankAccount> getAllBankAccount() {
			//Try-with-resources will automatically close your resources in the reverse order in which you declare them.
				//In the reverse order in which you declared the,
				try(Connection conn  = ConnectionUtil.getConnection()){
					//1. Create a List<Customer>
					List<BankAccount>bankAccount = new ArrayList<>();
					
					//2. Create a statement
		    		PreparedStatement stmt = conn.prepareStatement("SELECT accountNumber,TransactionAmount, AccountBalance FROM BankAccount");
					//stmt.setString(1,  Customer);
					ResultSet rs = stmt.executeQuery();
					while(rs.next()){
						bankAccount.add(new BankAccount(rs.getInt("accountNumber"), rs.getInt("TransactionId"), rs.getString("TransactionType"),rs.getInt("TransactionAmount"), rs.getInt("AccountBalance")));
						
					}
					return bankAccount;
					}
			
			catch(SQLException e)
				{
					System.err.println(e.getMessage());
					System.err.println(e.getSQLState());
					System.err.println(e.getErrorCode());
				}
				return null;
			}

			@Override
			public boolean updateBankAccount(BankAccount bankAccount) {
				// TODO Auto-generated method stub
				return false;
			}

//				@Override
//				public BankAccount getBankAccount(int accountNumber) {
//					// TODO Auto-generated method stub
//					return null;
//				}

				@Override
				public boolean deleteBankAccount(int accountNumber) {
					// TODO Auto-generated method stub
					return false;
				}
				
					}
