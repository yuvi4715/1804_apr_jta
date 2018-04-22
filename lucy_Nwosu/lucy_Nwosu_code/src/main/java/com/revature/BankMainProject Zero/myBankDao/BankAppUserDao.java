package myBankDao;

import java.util.List;
import bankModel.BankAppUser;

public interface BankAppUserDao {

			public boolean insertBankAppUserPersonal(BankAppUser bankAppUser);	
			public boolean insertBankAppUserCommercial(BankAppUser bankAppUser);// Create
			public BankAppUser getBankAppUser(String accountName);	// Read
			public List<BankAppUser> getAllBankAppUser();  //users?
			public boolean updateBankAppUser(BankAppUser bankAppUser);	// Update
			public boolean deleteBankAppUser(BankAppUser bankAppUser);	// Delete
		
		}