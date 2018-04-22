package myBankDao;

	import java.sql.Connection;

	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	import bankConnection.ConnectionUtil;
	import bankModel.BankAppUser;
	
	
	public class BankAppUserDaoImp implements BankAppUserDao {

		private static BankAppUserDaoImp instance;
		
		private BankAppUserDaoImp()
		{
			
		}
		
		public static BankAppUserDaoImp getInstance()
		{
			if(instance == null)
			{
				instance = new BankAppUserDaoImp();
			}
			return instance;
		}

		@Override
		public boolean insertBankAppUserPersonal(BankAppUser bankAppUser) {
			// TODO Auto-generated method stub
			try(Connection conn = ConnectionUtil.getConnection())
			{
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO BANKAPPUSER"
						+ "(id, AccountName, Address, homephone, workphone) VALUES (?,?,?,?,?)");
							
				stmt.setInt(1, 2); 
				stmt.setString(2, bankAppUser.getAccountName());
				stmt.setString(3, bankAppUser.getAddress());
				stmt.setString(4, bankAppUser.getHomePhone());
				stmt.setString(5, bankAppUser.getWorkPhone());
				//stmt.setString(6, bankAppUser.getContactPersonName());
				//stmt.setString(7, bankAppUser.getContactPersonPhone());
				
				
//				
//				stmt.setInt(1, 3); 
//				stmt.setString(2, bankAppUser.getAccountName());
//				stmt.setString(3, bankAppUser.getAddress());
////				stmt.setString(3, 'errr'));
////				stmt.setString(4, bankAppUser.getWorkPhone());
				
				if(!stmt.execute())
				{
					//executeupdate returns
					return stmt.getUpdateCount()>0;
				}
			}catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
			
			return false;
		}
		@Override
		public boolean insertBankAppUserCommercial(BankAppUser bankAppUser) {
			// TODO Auto-generated method stub
			try(Connection conn = ConnectionUtil.getConnection())
			{
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO BANKAPPUSER"
						+ "(id, AccountName, Address, ContactPersonName,ContactPersonPhone) VALUES (?,?,?,?,?)");
							
				stmt.setInt(1, 26); 
				stmt.setString(2, bankAppUser.getAccountName());
				stmt.setString(3, bankAppUser.getAddress());
				//stmt.setString(4, bankAppUser.getHomePhone());
				//stmt.setString(5, bankAppUser.getWorkPhone());
				stmt.setString(4, bankAppUser.getContactPersonName());
				stmt.setString(5, bankAppUser.getContactPersonPhone());
				
				
				
				
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

		@Override
		public BankAppUser getBankAppUser(String accountName) { 
			try(Connection conn = ConnectionUtil.getConnection()){
				PreparedStatement stmt = conn.prepareStatement("SELECT accountname,  address, homephone, workPhone, ContactPersonName, ContactPersonPhone  FROM BAnkAppUser WHERE HomePhone = ?");///updatePassWord?
				stmt.setString(1, accountName);
				ResultSet rs = stmt.executeQuery();
				// Can use if statement instead of while loop if your expecting only one result
				
			if(rs.next())
			{
							
				 return new BankAppUser(rs.getString("accountName"), rs.getString("address"), rs.getString("HomePhone"),rs.getString("WorkPhone"), rs.getString("ContacPersonName"),rs.getString("ContactPersonPhone")); //,rs.getInt("AccountNumber"),rs.getString("TransactionType"),rs.getInt("TransactionAmount"),rs.getInt("AccountBalance"));
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
		public List<BankAppUser> getAllBankAppUser() {
		//Try-with-resources will automatically close your resources in the reverse order in which you declare them.
			//In the reverse order in which you declared the,
			try(Connection conn  = ConnectionUtil.getConnection()){
				//1. Create a List<Customer>
				List<BankAppUser>bankAppUser = new ArrayList<>();
				
				//2. Create a statement
	    		PreparedStatement stmt = conn.prepareStatement("SELECT accountName, Address, HomePhone FROM BankAppUser");
				//stmt.setString(1,  Customer);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()){
					bankAppUser.add(new BankAppUser(rs.getString("accountName"), rs.getString("address"), rs.getString("HomePhone"),rs.getString("WorkPhone"), rs.getString("ContacPersonNamw"),rs.getString("ContactPersonPhone"))); //,rs.getInt("AccountNumber"),rs.getString("TransactionType"),rs.getInt("TransactionAmount"),rs.getInt("AccountBalance")));
					
				}
				return bankAppUser;
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
		public boolean updateBankAppUser(BankAppUser bankAppUser) {
			// TODO Auto-generated method stub
			return false;
		}

			@Override
		public boolean deleteBankAppUser(BankAppUser bankAppUser) {
			// TODO Auto-generated method stub
			return false;
		}

	}	